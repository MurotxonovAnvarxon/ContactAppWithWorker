package com.example.contactappwithworker.domain.usecase.impl

import com.example.contactappwithworker.domain.repository.ContactRepository
import com.example.contactappwithworker.domain.usecase.SyncInsertedUseCase
import javax.inject.Inject

class SyncInsertedUseCaseImpl @Inject constructor(
    private val repository: ContactRepository
) : SyncInsertedUseCase {
    override suspend fun invoke() = repository.syncInserted()

}