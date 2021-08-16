package com.cocus.cocuscc.feature.search.view.fragment.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cocus.cocuscc.data.search.model.SearchResponse
import com.cocus.cocuscc.data.search.model.User
import com.cocus.cocuscc.domain.interactor.UseCase
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

class SearchViewModel @Inject constructor(
    private val getUser: UseCase<@JvmSuppressWildcards SearchResponse, @JvmSuppressWildcards String>
) : ViewModel() {

    init {
        loadCache()
    }

    val state = MutableLiveData<SearchState>()

    private fun loadCache() {

    }

    fun findUser(username: String) {
        getUser.run(username)
            .onStart { state.value = SearchState.LoadingUser }
            .onEach { result ->
                if (result.isSuccess) {
                    state.value = result.user?.let { user ->
                        SearchState.LoadedUser(user)
                    } ?: SearchState.Error
                } else {
                    state.value = SearchState.Error
                }
            }.catch {
                state.value = SearchState.Error
            }.launchIn(viewModelScope)
    }

    sealed class SearchState {
        object LoadingUser : SearchState()

        data class LoadedUser(
            val response: User
        ) : SearchState()

        object Error : SearchState()
    }
}