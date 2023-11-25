package com.example.contactappwithworker.domain.usecase

import com.example.contactappwithworker.data.common.ContactData

interface DeleteContactUseCase {
    suspend operator fun invoke(contactData: ContactData)
}