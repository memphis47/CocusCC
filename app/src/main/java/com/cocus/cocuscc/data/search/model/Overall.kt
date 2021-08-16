package com.cocus.cocuscc.data.search.model

import kotlinx.serialization.Serializable


@Serializable
data class Overall(
    val rank: Int,
    val name: String,
    val color: String,
    val score: Int,
)