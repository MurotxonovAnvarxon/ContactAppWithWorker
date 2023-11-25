package com.example.contactappwithworker.domain.usecase

import java.util.concurrent.TimeUnit

interface StartWorkerUseCase {
    suspend operator fun invoke(date: Long, timeUnit: TimeUnit)
}