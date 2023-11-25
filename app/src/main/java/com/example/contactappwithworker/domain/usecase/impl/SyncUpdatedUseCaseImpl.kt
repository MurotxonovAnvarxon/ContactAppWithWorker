package com.example.contactappwithworker.domain.usecase.impl

import com.example.contactappwithworker.domain.repository.ContactRepository
import com.example.contactappwithworker.domain.usecase.SyncUpdatedUseCase
import javax.inject.Inject

class SyncUpdatedUseCaseImpl @Inject constructor(
    private val repository: ContactRepository
) : SyncUpdatedUseCase {
    override suspend fun invoke() = repository.syncUpdated()
}