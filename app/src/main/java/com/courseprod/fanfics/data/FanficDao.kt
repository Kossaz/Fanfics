package com.courseprod.fanfics.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface FanficDao {

    @Query("SELECT * FROM fanfics")
    fun getAllFanfics(): Flow<List<Fanfic>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFanfics(fanfics: List<Fanfic>)

    @Query("DELETE FROM fanfics")
    suspend fun deleteAllFanfics()
}