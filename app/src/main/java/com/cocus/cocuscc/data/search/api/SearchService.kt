package com.cocus.cocuscc.data.search.api

import com.cocus.cocuscc.data.search.model.User
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface SearchService {

    @GET("users/{user}")
    suspend fun getUser(
        @Path(value = "user") userName: String
    ): Response<User>
}