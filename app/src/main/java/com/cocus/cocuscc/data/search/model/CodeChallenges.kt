package com.cocus.cocuscc.data.search.model

import kotlinx.serialization.Serializable

@Serializable
data class CodeChallenges(
    val totalAuthored: Int,
    val totalCompleted: Int,
)
