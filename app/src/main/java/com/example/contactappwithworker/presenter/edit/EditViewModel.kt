package com.example.contactappwithworker.presenter.edit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.contactappwithworker.data.common.ContactData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EditViewModel @Inject constructor(
    private val direction: EditDirection,
) : ViewModel(), EditContract.ViewModel {
    override val uiState: StateFlow<EditContract.UIState> = MutableStateFlow(EditContract.UIState())


    override fun onEventDispatcher(intent: EditContract.Intent) {

        when (intent) {
            EditContract.Intent.Back -> {
                viewModelScope.launch {
                    direction.backToMain()
                }
            }

            is EditContract.Intent.EditContact -> {
                viewModelScope.launch {
                    val contactData = ContactData(0, intent.firstName, intent.lastName, intent.phone, true, intent.phone)
                    direction.save(intent.firstName,intent.lastName,intent.phone)
                }
            }
        }
    }

}