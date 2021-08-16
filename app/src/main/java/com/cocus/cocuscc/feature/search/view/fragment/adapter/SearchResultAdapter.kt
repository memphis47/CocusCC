package com.cocus.cocuscc.feature.search.view.fragment.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cocus.cocuscc.R
import com.cocus.cocuscc.data.search.model.Language
import com.cocus.cocuscc.data.search.model.SearchResponse

class SearchResultAdapter(var context: Context) :
    RecyclerView.Adapter<SearchResultAdapter.SearchResultViewHolder>() {

    private var responseList = emptyList<SearchResponse>()

    internal fun setResponseList(productList: List<SearchResponse>) {
        this.responseList = productList
        notifyDataSetChanged()
    }

    class SearchResultViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var rank: TextView = itemView.findViewById(R.id.rank_content_tv)
        var userName: TextView = itemView.findViewById(R.id.user_content_tv)
        var language: TextView = itemView.findViewById(R.id.languages_content_tv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchResultViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.search_result_content_layout, parent, false)
        return SearchResultViewHolder(view)
    }

    override fun onBindViewHolder(holderSearch: SearchResultViewHolder, position: Int) {
        val response = responseList[position]
        response.user?.let { user ->
            holderSearch.rank.text = String.format(
                context.getString(R.string.rank),
                user.leaderBoardPosition.toString()
            )
            holderSearch.userName.text = user.username
            val bestLanguage =
                user.ranks.languages.values.maxByOrNull { language -> language.score } as Language
            holderSearch.language.text = String.format(
                context.getString(R.string.best_language),
                bestLanguage.language,
                bestLanguage.score
            )

        }

    }

    override fun getItemCount(): Int {
        return responseList.size
    }
}