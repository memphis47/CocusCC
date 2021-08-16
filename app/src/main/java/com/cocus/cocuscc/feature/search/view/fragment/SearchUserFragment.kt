package com.cocus.cocuscc.feature.search.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.zup.multistatelayout.MultiStateLayout
import com.cocus.cocuscc.CocusCCApplication
import com.cocus.cocuscc.R
import com.cocus.cocuscc.data.search.model.Language
import com.cocus.cocuscc.databinding.SearchUserFragmentBinding
import com.cocus.cocuscc.di.viewModel
import com.cocus.cocuscc.feature.search.view.fragment.adapter.SearchResultAdapter
import com.cocus.cocuscc.feature.search.view.fragment.viewModel.SearchViewModel

class SearchUserFragment : Fragment() {

    private lateinit var searchAdapter: SearchResultAdapter
    private lateinit var binding: SearchUserFragmentBinding

    private val viewModel: SearchViewModel by viewModel {
        CocusCCApplication.searchUserComponent.viewModelComponent.searchViewModel
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = SearchUserFragmentBinding.inflate(inflater, container, false)
        context ?: return binding.root

        defineList()
        defineListeners()
        defineObservers()

        return binding.root
    }

    private fun defineList() {
        activity?.let { activity ->
            binding.lastSearchRv.layoutManager = LinearLayoutManager(activity)
            searchAdapter = SearchResultAdapter(activity.applicationContext)
            binding.lastSearchRv.adapter = searchAdapter
        }
    }


    private fun defineObservers() {
        viewModel.state.observe(viewLifecycleOwner, { state ->
            when (state) {
                is SearchViewModel.SearchState.LoadingUser -> binding.multiStateLayout.setState(
                    MultiStateLayout.State.LOADING
                )
                is SearchViewModel.SearchState.Error -> binding.multiStateLayout.setState(
                    MultiStateLayout.State.ERROR
                )
                is SearchViewModel.SearchState.LoadedUser -> {
                    createSuccessResultView(state)
                    viewModel.updateCache(state.response)
                }

            }
        }
        )

        viewModel.cacheList.observe(viewLifecycleOwner, { cacheList ->
            searchAdapter.setResponseList(cacheList)
        })

        viewModel.isCacheUpdated.observe(viewLifecycleOwner, { isCacheUpdated ->
            if(isCacheUpdated){
                viewModel.loadCache()
            }
        })
    }

    private fun createSuccessResultView(state: SearchViewModel.SearchState.LoadedUser) {
        val rank =
            binding.searchResultLayout.findViewById<TextView>(R.id.rank_content_tv)
        val content =
            binding.searchResultLayout.findViewById<TextView>(R.id.user_content_tv)
        val bestLanguages =
            binding.searchResultLayout.findViewById<TextView>(R.id.languages_content_tv)
        rank.text = String.format(
            getString(R.string.rank),
            state.response.leaderBoardPosition.toString()
        )
        content.text = state.response.username
        val bestLanguage =
            state.response.ranks.languages.values.maxByOrNull { language -> language.score } as Language
        bestLanguages.text = String.format(
            getString(R.string.best_language),
            bestLanguage.language,
            bestLanguage.score
        )
        binding.multiStateLayout.setState(MultiStateLayout.State.CONTENT)
    }

    private fun defineListeners() {
        binding.searchBtn.setOnClickListener {
            viewModel.findUser(binding.searchEt.text.toString())
        }
    }
}