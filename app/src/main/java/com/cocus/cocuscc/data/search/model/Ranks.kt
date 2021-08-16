package com.cocus.cocuscc.data.search.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Ranks(
    val overall: Overall,

    @SerializedName("languages")
    @Expose
    val languages: Map<String,Language>
)
