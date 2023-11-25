package com.example.contactappwithworker.navigation

import kotlinx.coroutines.flow.MutableSharedFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppNavigationDispatcher @Inject constructor() : AppNavigator, AppNavigationHandler {
    override val navigationFlow = MutableSharedFlow<NavigationArgs>()


    private suspend fun navigate(navigationArgs: NavigationArgs) {
        navigationFlow.emit(navigationArgs)
    }

    override suspend fun navigateTo(myScreen: MyScreen) = navigate {
        push(myScreen)
    }

    override suspend fun replace(myScreen: MyScreen) = navigate {
        replace(myScreen)
    }

    override suspend fun replaceAll(myScreen: MyScreen) = navigate {
        replaceAll(myScreen)
    }

    override suspend fun back() = navigate {
        pop()
    }

    override suspend fun backToRoot(myScreen: MyScreen) = navigate {
        popUntil { it == myScreen }
    }

}