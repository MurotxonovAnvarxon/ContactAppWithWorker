package com.example.contactappwithworker.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import com.example.contactappwithworker.presenter.add.AddDirection
import com.example.contactappwithworker.presenter.add.AddDirectionImpl
import com.example.contactappwithworker.presenter.edit.EditDirection
import com.example.contactappwithworker.presenter.edit.EditDirectionImpl
import com.example.contactappwithworker.presenter.main.MainDirection
import com.example.contactappwithworker.presenter.main.MainDirectionImpl
import com.example.contactappwithworker.presenter.settings.SettingsDirection
import com.example.contactappwithworker.presenter.settings.SettingsDirectionImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DirectionModule {

    @[Binds Singleton]
    fun bindsMainDirection(impl: MainDirectionImpl) : MainDirection

    @[Binds Singleton]
    fun bindsAddDirection(impl: AddDirectionImpl): AddDirection

    @[Binds Singleton]
    fun bindsEditDirection(impl: EditDirectionImpl) : EditDirection

    @[Binds Singleton]
    fun bindsSettingsDirection(impl: SettingsDirectionImpl) : SettingsDirection
}