package com.virtusa.virginmoney.di

import com.virtusa.virginmoney.common.Constants
import com.virtusa.virginmoney.data.remote.ConferenceRoomApi
import com.virtusa.virginmoney.data.remote.PeopleContactApi
import com.virtusa.virginmoney.data.repository.PeopleRepositoryImpl
import com.virtusa.virginmoney.data.repository.RoomRepositoryImpl
import com.virtusa.virginmoney.domain.repository.PeopleRepository
import com.virtusa.virginmoney.domain.repository.RoomRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providePeopleApi(okHttpClient:OkHttpClient): PeopleContactApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PeopleContactApi::class.java)
    }

    @Provides
    @Singleton
    fun providePeopleRepository(api: PeopleContactApi): PeopleRepository {
        return PeopleRepositoryImpl(api)
    }


    @Provides
    @Singleton
    fun provideRoomsApi(okHttpClient:OkHttpClient): ConferenceRoomApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ConferenceRoomApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRoomRepository(api: ConferenceRoomApi): RoomRepository {
        return RoomRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideHttpClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC)

        return OkHttpClient.Builder().addInterceptor(interceptor).build()
    }

}