package com.example.contactappwithworker.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import com.example.contactappwithworker.data.repository.ContactRepositoryImpl
import com.example.contactappwithworker.domain.repository.ContactRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    @Singleton
    fun bindsRepository(impl: ContactRepositoryImpl) : ContactRepository
}