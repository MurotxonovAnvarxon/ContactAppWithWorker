package com.example.contactappwithworker.domain.usecase.impl

import com.example.contactappwithworker.domain.repository.ContactRepository
import com.example.contactappwithworker.domain.usecase.SyncMergeUseCase
import javax.inject.Inject

class SyncMergeUseCaseImpl @Inject constructor(
    private val repository: ContactRepository
) : SyncMergeUseCase {
    override suspend fun invoke() = repository.syncMerge()
}