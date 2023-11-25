package com.example.contactappwithworker.presenter.edit

import kotlinx.coroutines.flow.StateFlow
import com.example.contactappwithworker.data.common.ContactData

interface EditContract {
    interface ViewModel {
        val uiState: StateFlow<UIState>
        fun onEventDispatcher(intent: Intent)
    }

    data class UIState(
        val contactData: ContactData = ContactData(1, "", "", "", false, "")
    )

    interface Intent {
        object Back : Intent
        data class EditContact(val firstName: String, val lastName: String, val phone: String) :
            Intent

        data class PutOldData(
            val contactParam: ContactData
        ) : Intent

        data class ChangingName(
            val name: String
        ) : Intent

        data class ChangingLastName(
            val lastName: String
        ) : Intent

        data class ChangingPhone(
            val phone: String
        ) : Intent
    }
}