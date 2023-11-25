package com.example.contactappwithworker.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import com.example.contactappwithworker.data.source.local.room.ContactDatabase
import com.example.contactappwithworker.data.source.local.room.dao.ContactDao
import com.example.contactappwithworker.data.source.local.room.dao.DeletedContactDao
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): ContactDatabase =
        Room.databaseBuilder(context, ContactDatabase::class.java, "Contact.db").build()

    @Provides
    fun provideContactDao(contactDatabase: ContactDatabase): ContactDao =
        contactDatabase.getContactDao()

    @Provides
    fun provideDeletedContactDao(contactDatabase: ContactDatabase): DeletedContactDao =
        contactDatabase.getDeletedContactDao()
}