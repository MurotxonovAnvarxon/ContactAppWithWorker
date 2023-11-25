package com.example.contactappwithworker.domain.usecase

import kotlinx.coroutines.flow.Flow
import com.example.contactappwithworker.data.common.ContactData

interface LoadContactsUseCase {
    operator fun invoke(): Flow<List<ContactData>>
}