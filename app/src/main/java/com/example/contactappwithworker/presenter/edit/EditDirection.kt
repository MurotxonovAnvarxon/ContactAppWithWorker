package com.example.contactappwithworker.presenter.edit

import com.example.contactappwithworker.data.common.ContactData
import com.example.contactappwithworker.navigation.AppNavigator
import com.example.contactappwithworker.presenter.main.MainScreen
import javax.inject.Inject
import javax.inject.Singleton

interface EditDirection {
    suspend fun backToMain()
    suspend fun save(firstName: String, lastName: String, phone: String)
}

@Singleton
class EditDirectionImpl @Inject constructor(
    private val appNavigator: AppNavigator
) : EditDirection {
    override suspend fun backToMain() {
        appNavigator.back()
    }

    override suspend fun save(firstName: String, lastName: String, phone: String) {
        appNavigator.navigateTo(MainScreen())
    }


}