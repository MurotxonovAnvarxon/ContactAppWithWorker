package com.example.contactappwithworker.data.source.local.room.entity

import androidx.room.Entity
import com.example.contactappwithworker.data.common.ContactData
import com.example.contactappwithworker.data.source.remote.request.ContactRequest

@Entity(primaryKeys = ["id", "localId"])
data class ContactEntity(
    val id: Int = 0,
    val localId: String,
    val firstName: String,
    val lastName: String,
    val phone: String,
    val needSync: Boolean = true
)

fun ContactEntity.toRequest() = ContactRequest(firstName, lastName, phone)
fun ContactEntity.toData() = ContactData(id, firstName, lastName, phone, needSync, localId = localId)
