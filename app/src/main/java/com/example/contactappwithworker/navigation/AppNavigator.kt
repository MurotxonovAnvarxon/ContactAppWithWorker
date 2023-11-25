package com.example.contactappwithworker.navigation

import cafe.adriel.voyager.androidx.AndroidScreen

typealias MyScreen = AndroidScreen
interface AppNavigator {
    suspend fun navigateTo(myScreen: MyScreen)
    suspend fun replace(myScreen: MyScreen)
    suspend fun replaceAll(myScreen: MyScreen)
    suspend fun back()
    suspend fun backToRoot(myScreen: MyScreen)
}