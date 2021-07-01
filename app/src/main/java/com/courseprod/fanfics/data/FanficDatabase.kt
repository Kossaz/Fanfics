package com.courseprod.fanfics.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Fanfic::class], version = 1)
abstract class FanficDatabase : RoomDatabase() {

    abstract fun fanficDao(): FanficDao
}