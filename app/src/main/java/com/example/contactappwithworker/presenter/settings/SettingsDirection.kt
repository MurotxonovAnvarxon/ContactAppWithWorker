package com.example.contactappwithworker.presenter.settings

import com.example.contactappwithworker.navigation.AppNavigator
import javax.inject.Inject
import javax.inject.Singleton

interface SettingsDirection {
    suspend fun backToMain()
}

@Singleton
class SettingsDirectionImpl @Inject constructor(
    private val appNavigator: AppNavigator
) : SettingsDirection {
    override suspend fun backToMain() {
        appNavigator.back()
    }

}