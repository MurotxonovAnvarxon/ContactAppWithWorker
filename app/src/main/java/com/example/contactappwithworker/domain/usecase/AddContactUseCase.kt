package com.example.contactappwithworker.domain.usecase

import com.example.contactappwithworker.data.common.ContactData

interface AddContactUseCase {
    suspend operator fun invoke(contactData: ContactData)
}