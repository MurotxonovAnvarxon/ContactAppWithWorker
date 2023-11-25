package com.example.contactappwithworker.data.common

import com.example.contactappwithworker.data.source.local.room.entity.ContactEntity

data class ContactData(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val phone: String,
    val state: Boolean,
    val localId: String
)

fun ContactData.toEntity() = ContactEntity(id, localId, firstName, lastName, phone)
