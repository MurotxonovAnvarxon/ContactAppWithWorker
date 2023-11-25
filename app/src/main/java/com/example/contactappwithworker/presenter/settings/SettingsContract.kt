package com.example.contactappwithworker.presenter.settings

import kotlinx.coroutines.flow.StateFlow

interface SettingsContract {
    interface ViewModel{
        val uiState  : StateFlow<UIState>
        fun onEventDispatcher(intent: Intent)
    }

    data class UIState(val time : String = "")

    interface Intent{
        object CLickTime : Intent
    }
}