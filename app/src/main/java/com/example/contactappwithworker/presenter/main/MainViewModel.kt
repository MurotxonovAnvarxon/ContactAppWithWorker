package com.example.contactappwithworker.presenter.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import com.example.contactappwithworker.domain.usecase.DeleteContactUseCase
import com.example.contactappwithworker.domain.usecase.LoadContactsUseCase
import com.example.contactappwithworker.presenter.main.MainContract
import com.example.contactappwithworker.presenter.main.MainDirection
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val direction: MainDirection,
    private val loadContactsUseCase: LoadContactsUseCase,
    private val deleteContactUseCase: DeleteContactUseCase
) : ViewModel(), MainContract.ViewModel {
    override val uiState: MutableStateFlow<MainContract.UIState> =
        MutableStateFlow(MainContract.UIState())

    init {
        loadContactsUseCase()
            .onEach { uiState.update { state -> state.copy(list = it) } }
            .launchIn(viewModelScope)
    }

    override fun onEventDispatcher(intent: MainContract.Intent) {
        when (intent) {
            MainContract.Intent.AddButton -> {
                viewModelScope.launch {
                    direction.moveToAddScreen()
                }
            }

            MainContract.Intent.Settings -> {
                viewModelScope.launch {
                    direction.moveToSettings()
                }
            }

            is MainContract.Intent.Delete -> {
                viewModelScope.launch {
                    deleteContactUseCase(intent.contactData)
                }
            }

            is MainContract.Intent.Edit -> {
                viewModelScope.launch {
                    direction.moveToEditScreen(intent.contactData)
                }
            }
        }
    }
}