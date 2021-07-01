package com.courseprod.fanfics.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "fanfics")
data class Fanfic(
    @PrimaryKey val title: String,
    val description: String,
    val tag: String,
    val fandom: String
)