package com.example.contactappwithworker.di

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.example.contactappwithworker.data.source.remote.api.ContactApi
import com.example.contactappwithworker.utils.Constants.BASE_URL
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @[Provides Singleton]
    fun provideClient(@ApplicationContext context: Context): OkHttpClient = OkHttpClient.Builder().addInterceptor(ChuckerInterceptor.Builder(context).build()).build()

    @[Provides Singleton]
    fun provideNetwork(client: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @[Provides Singleton]
    fun provideContactApi(retrofit: Retrofit) : ContactApi = retrofit.create(ContactApi::class.java)
}