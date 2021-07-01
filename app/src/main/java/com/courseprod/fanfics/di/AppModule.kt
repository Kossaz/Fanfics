package com.courseprod.fanfics.di

import android.app.Application
import androidx.room.Room
import com.courseprod.fanfics.api.FanficApi
import com.courseprod.fanfics.data.FanficDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(FanficApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideFanficApi(retrofit: Retrofit): FanficApi =
        retrofit.create(FanficApi::class.java)

    @Provides
    @Singleton
    fun provideDatabase(app: Application) : FanficDatabase =
        Room.databaseBuilder(app, FanficDatabase::class.java, "fanfic_database")
            .build()
}