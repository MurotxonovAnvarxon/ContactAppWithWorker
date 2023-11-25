package com.example.contactappwithworker.presenter.settings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import com.example.contactappwithworker.domain.usecase.StartWorkerUseCase
import com.example.contactappwithworker.presenter.settings.SettingsContract
import com.example.contactappwithworker.presenter.settings.SettingsDirection
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val direction: SettingsDirection,
    private val startWorkerUseCase: StartWorkerUseCase
): ViewModel(), SettingsContract.ViewModel {
    override val uiState: StateFlow<SettingsContract.UIState> = MutableStateFlow(SettingsContract.UIState())

    override fun onEventDispatcher(intent: SettingsContract.Intent) {
        when(intent){
            SettingsContract.Intent.CLickTime -> {
                viewModelScope.launch {
                    startWorkerUseCase(30, TimeUnit.MINUTES)
                    direction.backToMain()
                }
            }
        }
    }
}