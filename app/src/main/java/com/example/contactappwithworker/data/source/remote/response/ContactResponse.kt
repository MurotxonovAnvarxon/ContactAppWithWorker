package com.example.contactappwithworker.data.source.remote.response

import com.example.contactappwithworker.data.source.local.room.entity.ContactEntity


data class ContactResponse(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val phone: String
)

fun ContactResponse.toEntity(localId: String, state: Boolean) =
    ContactEntity(id, localId = localId, firstName, lastName, phone, needSync = state)
