package com.example.contactappwithworker.presenter.main

import kotlinx.coroutines.flow.StateFlow
import com.example.contactappwithworker.data.common.ContactData

interface MainContract {

    interface ViewModel {
        val uiState: StateFlow<UIState>

        fun onEventDispatcher(intent: Intent)
    }

    interface Intent {
        object AddButton : Intent
        data class Delete(val contactData: ContactData) : Intent
        data class Edit(val contactData: ContactData) : Intent
        object Settings : Intent
    }

    data class UIState(
        val loading: Boolean = false,
        val list: List<ContactData> = arrayListOf()
    )
}