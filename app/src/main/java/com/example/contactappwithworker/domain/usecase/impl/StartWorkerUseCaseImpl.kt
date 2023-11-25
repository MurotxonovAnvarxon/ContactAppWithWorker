package com.example.contactappwithworker.domain.usecase.impl

import com.example.contactappwithworker.domain.repository.ContactRepository
import com.example.contactappwithworker.domain.usecase.StartWorkerUseCase
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class StartWorkerUseCaseImpl @Inject constructor(
    private val repository: ContactRepository
) : StartWorkerUseCase {
    override suspend fun invoke(date: Long, timeUnit: TimeUnit) = repository.startWorker(date, timeUnit)
}