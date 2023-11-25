package com.example.contactappwithworker.presenter.add

import com.example.contactappwithworker.navigation.AppNavigator
import javax.inject.Inject
import javax.inject.Singleton

interface AddDirection {
    suspend fun backToMain()
}

@Singleton
class AddDirectionImpl @Inject constructor(
    private val appNavigator: AppNavigator
) : AddDirection {
    override suspend fun backToMain() {
        appNavigator.back()
    }

}