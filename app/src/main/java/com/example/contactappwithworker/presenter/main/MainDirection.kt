package com.example.contactappwithworker.presenter.main

import com.example.contactappwithworker.data.common.ContactData
import com.example.contactappwithworker.navigation.AppNavigator
import com.example.contactappwithworker.presenter.add.AddScreen
import com.example.contactappwithworker.presenter.edit.EditScreen
import com.example.contactappwithworker.presenter.settings.SettingsScreen
import javax.inject.Inject
import javax.inject.Singleton

interface MainDirection {
    suspend fun moveToAddScreen()
    suspend fun moveToEditScreen(contactData: ContactData)
    suspend fun moveToSettings()
}
@Singleton
class MainDirectionImpl @Inject constructor(
    private val appNavigator: AppNavigator
) : MainDirection {
    override suspend fun moveToAddScreen() {
        appNavigator.navigateTo(AddScreen())
    }

    override suspend fun moveToEditScreen(contactData: ContactData) {
        appNavigator.navigateTo(EditScreen(contactData))
    }

    override suspend fun moveToSettings() {
        appNavigator.navigateTo(SettingsScreen())
    }

}