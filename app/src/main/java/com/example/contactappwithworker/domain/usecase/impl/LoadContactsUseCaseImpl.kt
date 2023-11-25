package com.example.contactappwithworker.domain.usecase.impl

import kotlinx.coroutines.flow.Flow
import com.example.contactappwithworker.data.common.ContactData
import com.example.contactappwithworker.domain.repository.ContactRepository
import com.example.contactappwithworker.domain.usecase.LoadContactsUseCase
import javax.inject.Inject

class LoadContactsUseCaseImpl @Inject constructor(private val contactRepository: ContactRepository) :
    LoadContactsUseCase {
    override fun invoke(): Flow<List<ContactData>> = contactRepository.loadContacts()
}