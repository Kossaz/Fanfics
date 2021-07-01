package com.courseprod.fanfics.data

import androidx.room.withTransaction
import com.courseprod.fanfics.api.FanficApi
import com.courseprod.fanfics.util.networkBoundResource
import kotlinx.coroutines.delay
import javax.inject.Inject

class FanficRepository @Inject constructor(
    private val api: FanficApi,
    private val db: FanficDatabase
) {
    private val fanficDao = db.fanficDao()

    fun getFanfics() = networkBoundResource(
        query = {
            fanficDao.getAllFanfics()
        },
        fetch = {
            delay(2000)
            api.getFanfics()
        },
        saveFetchResult = { fanfics ->
            db.withTransaction {
                fanficDao.deleteAllFanfics()
                fanficDao.insertFanfics(fanfics)
            }
        }
    )
}