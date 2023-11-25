package com.example.contactappwithworker.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import com.example.contactappwithworker.navigation.AppNavigationDispatcher
import com.example.contactappwithworker.navigation.AppNavigationHandler
import com.example.contactappwithworker.navigation.AppNavigator
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface NavigationModule {

    @[Binds Singleton]
    fun bindAppNavigator(impl: AppNavigationDispatcher) : AppNavigator

    @[Binds Singleton]
    fun bindsAppNavigationHandler(impl: AppNavigationDispatcher) : AppNavigationHandler
}