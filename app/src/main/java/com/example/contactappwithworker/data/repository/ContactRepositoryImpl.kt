package com.example.contactappwithworker.data.repository

import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import com.example.contactappwithworker.data.common.ContactData
import com.example.contactappwithworker.data.common.toEntity
import com.example.contactappwithworker.data.source.local.room.dao.ContactDao
import com.example.contactappwithworker.data.source.local.room.dao.DeletedContactDao
import com.example.contactappwithworker.data.source.local.room.entity.DeletedContactEntity
import com.example.contactappwithworker.data.source.local.room.entity.toData
import com.example.contactappwithworker.data.source.local.room.entity.toRequest
import com.example.contactappwithworker.data.source.remote.api.ContactApi
import com.example.contactappwithworker.data.source.remote.response.toEntity
import com.example.contactappwithworker.domain.repository.ContactRepository
import com.example.contactappwithworker.utils.myLog
import com.example.contactappwithworker.worker.MyWorker
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class ContactRepositoryImpl @Inject constructor(
    private val deletedContactDao: DeletedContactDao,
    private val contactDao: ContactDao,
    private val contactApi: ContactApi,
    private val workManager: WorkManager
) : ContactRepository {
    override suspend fun syncDelete() = withContext(Dispatchers.IO) {
        deletedContactDao.getAll().forEach {
            try {
                val response = contactApi.deleteContact(it.id)
                if (response.isSuccessful) {
                    deletedContactDao.delete(it)
                }
            } catch (e: Exception) {
                e.stackTrace
            }
        }
    }

    override suspend fun syncInserted() = withContext(Dispatchers.IO) {
        contactDao.getByIdAndState(0, true).forEach {
            try {
                val response = contactApi.addContact(it.toRequest())
                if (response.isSuccessful) {
                    response.body()?.let { response ->
                        contactDao.resetItem(it, response.toEntity(it.localId, false))
                    }
                }
            } catch (e: Exception) {
                e.stackTrace
            }
        }
    }

    override suspend fun syncUpdated() = withContext(Dispatchers.IO) {
        contactDao.getNeedUpdates().forEach {
            val response = contactApi.updateContact(it.toRequest())
            if (response.isSuccessful) {
                response.body()?.let { result ->
                    contactDao.resetItem(it, result.toEntity(it.localId, false))
                }
            }
        }
    }

    override suspend fun syncMerge(): Unit = withContext(Dispatchers.IO) {
        try {
            val response = contactApi.getContacts()
            if (response.isSuccessful) {
                response.body()?.let { res ->
                    contactDao.resetAllTime(res.map { it.toEntity(it.phone, false) })
                }
            }
        } catch (e: Exception) {
            e.stackTrace
        }
    }

    override fun startWorker(date: Long, timeUnit: TimeUnit) {
        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .setRequiresBatteryNotLow(true)
            .build()
        workManager.cancelAllWorkByTag("CONTACT")
        val periodicWorkRequest = PeriodicWorkRequestBuilder<MyWorker>(date, timeUnit)
            .setConstraints(constraints)
            .addTag("CONTACT")
            .build()

        myLog("Worker worked startWorker")

        workManager.enqueue(periodicWorkRequest)
    }


    override fun loadContacts(): Flow<List<ContactData>> = contactDao.getAllContacts()
        .map { it.map { it.toData() } }
        .flowOn(Dispatchers.IO)

    override suspend fun delete(contactData: ContactData) = withContext(Dispatchers.IO) {
        contactDao.delete(contactData.toEntity())
        deletedContactDao.insert(DeletedContactEntity(contactData.id))
    }

    override suspend fun insert(contactData: ContactData) = withContext(Dispatchers.IO) {
        contactDao.insert(contactData.toEntity())
    }




}