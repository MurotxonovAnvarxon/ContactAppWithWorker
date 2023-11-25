package com.example.contactappwithworker.domain.usecase.impl

import com.example.contactappwithworker.data.common.ContactData
import com.example.contactappwithworker.domain.repository.ContactRepository
import com.example.contactappwithworker.domain.usecase.DeleteContactUseCase
import javax.inject.Inject

class DeleteContactUseCaseImpl @Inject constructor(
    private val contactRepository: ContactRepository
) : DeleteContactUseCase {
    override suspend fun invoke(contactData: ContactData) = contactRepository.delete(contactData)
}