package com.cocus.cocuscc.data.database.mapper

import com.cocus.cocuscc.data.database.model.SearchCache
import com.cocus.cocuscc.data.search.model.SearchResponse
import com.cocus.cocuscc.data.search.model.User
import com.google.gson.Gson

object ResultMapper {

    fun mapCacheToResult(cacheListData: List<SearchCache>): List<SearchResponse> {
        return if (cacheListData.isNullOrEmpty()) {
            listOf(SearchResponse(null, false))
        } else {
            val list = ArrayList<SearchResponse>()
            cacheListData.forEach { cache ->
                list.add(
                    SearchResponse(
                        getObjectFromString(cache.user),
                        false
                    )
                )
            }
            list
        }
    }

    fun mapsResultToCache(result: SearchResponse): SearchCache {
        return result.user?.let { user ->
            SearchCache(
                user = stringFromObject(user)
            )
        } ?: SearchCache(user = "")
    }

    private fun stringFromObject(user: User): String {
        val gson = Gson()
        return gson.toJson(user)
    }

    private fun getObjectFromString(jsonString: String): User {
        return Gson().fromJson(jsonString, User::class.java)
    }

}