package com.example.contactappwithworker.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.contactappwithworker.data.source.local.room.dao.ContactDao
import com.example.contactappwithworker.data.source.local.room.dao.DeletedContactDao
import com.example.contactappwithworker.data.source.local.room.entity.ContactEntity
import com.example.contactappwithworker.data.source.local.room.entity.DeletedContactEntity

@Database(entities = [ContactEntity::class, DeletedContactEntity::class], version = 1)
abstract class ContactDatabase : RoomDatabase() {
    abstract fun getContactDao(): ContactDao
    abstract fun getDeletedContactDao(): DeletedContactDao
}