package com.example.contactappwithworker.domain.usecase.impl

import com.example.contactappwithworker.data.common.ContactData
import com.example.contactappwithworker.domain.repository.ContactRepository
import com.example.contactappwithworker.domain.usecase.AddContactUseCase
import javax.inject.Inject

class AddContactUseCaseImpl @Inject constructor(private val contactRepository: ContactRepository) :
    AddContactUseCase {
    override suspend fun invoke(contactData: ContactData) = contactRepository.insert(contactData)
}