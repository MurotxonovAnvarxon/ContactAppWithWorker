package com.example.contactappwithworker.domain.repository

import kotlinx.coroutines.flow.Flow
import com.example.contactappwithworker.data.common.ContactData
import java.util.concurrent.TimeUnit

interface ContactRepository {

    suspend fun syncDelete()
    suspend fun syncInserted()
    suspend fun syncUpdated()
    suspend fun syncMerge()

    fun startWorker(date: Long, timeUnit: TimeUnit)

    fun loadContacts(): Flow<List<ContactData>>

    suspend fun delete(contactData: ContactData)

    suspend fun insert(contactData: ContactData)
}