package com.example.contactappwithworker.worker

import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import com.example.contactappwithworker.domain.repository.ContactRepository
import com.example.contactappwithworker.utils.myLog

@HiltWorker
class MyWorker @AssistedInject constructor(
    @Assisted context: Context,
    @Assisted parameters: WorkerParameters,
    private val contactRepository: ContactRepository
) : CoroutineWorker(context, parameters) {

    override suspend fun doWork(): Result {

        myLog("Worker worekd")
        contactRepository.syncDelete()
        contactRepository.syncInserted()
        contactRepository.syncUpdated()

        return Result.success()
    }

}