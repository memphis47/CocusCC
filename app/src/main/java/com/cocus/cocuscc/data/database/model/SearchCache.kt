package com.cocus.cocuscc.data.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "result")
data class SearchCache(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val user: String

)
