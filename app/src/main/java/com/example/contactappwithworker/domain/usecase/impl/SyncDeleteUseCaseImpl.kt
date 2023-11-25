package com.example.contactappwithworker.domain.usecase.impl

import com.example.contactappwithworker.domain.repository.ContactRepository
import com.example.contactappwithworker.domain.usecase.SyncDeleteUseCase
import javax.inject.Inject

class SyncDeleteUseCaseImpl @Inject constructor(
    private val repository: ContactRepository
) : SyncDeleteUseCase {
    override suspend fun invoke() = repository.syncDelete()
}