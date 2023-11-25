package com.example.contactappwithworker.data.source.local.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity
data class DeletedContactEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Int
)