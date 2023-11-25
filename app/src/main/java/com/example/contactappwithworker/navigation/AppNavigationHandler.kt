package com.example.contactappwithworker.navigation

import cafe.adriel.voyager.navigator.Navigator
import kotlinx.coroutines.flow.SharedFlow

typealias NavigationArgs = Navigator.() -> Unit
interface AppNavigationHandler {
    val navigationFlow: SharedFlow<NavigationArgs>
}