package com.example.contactappwithworker.presenter.add

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import com.example.contactappwithworker.data.common.ContactData
import com.example.contactappwithworker.domain.usecase.AddContactUseCase
import com.example.contactappwithworker.presenter.add.AddContract
import com.example.contactappwithworker.presenter.add.AddDirection
import javax.inject.Inject

@HiltViewModel
class AddViewModel @Inject constructor(
    private val direction: AddDirection,
    private val addContactUseCase: AddContactUseCase
) : ViewModel(), AddContract.ViewModel {
    override fun onEventDispatcher(intent: AddContract.Intent) {
        when (intent) {
            is AddContract.Intent.AddButtonClick -> {
                viewModelScope.launch {
                    val contactData = ContactData(0, intent.firstName, intent.lastName, intent.phone, true, intent.phone)
                    addContactUseCase(contactData)
                    direction.backToMain()
                }
            }
        }
    }
}