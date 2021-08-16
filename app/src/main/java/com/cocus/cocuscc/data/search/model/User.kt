package com.cocus.cocuscc.data.search.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class User(
    val username: String,
    val name: String,
    val honor: Int,
    val clan: String,
    @SerializedName("leaderboardPosition")
    val leaderBoardPosition: Int,
    val skills: List<String>,
    val ranks: Ranks,
    val codeChallenges: CodeChallenges
)
