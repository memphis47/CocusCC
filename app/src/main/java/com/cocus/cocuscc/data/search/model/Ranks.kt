package com.cocus.cocuscc.data.search.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class Ranks(
    val overall: Overall,

    @SerializedName("languages")
    @Expose
    val languages: Map<String,Language>
)
