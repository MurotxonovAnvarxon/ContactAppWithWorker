package com.example.contactappwithworker.di

import com.example.contactappwithworker.domain.usecase.AddContactUseCase
import com.example.contactappwithworker.domain.usecase.DeleteContactUseCase
import com.example.contactappwithworker.domain.usecase.LoadContactsUseCase
import com.example.contactappwithworker.domain.usecase.StartWorkerUseCase
import com.example.contactappwithworker.domain.usecase.SyncDeleteUseCase
import com.example.contactappwithworker.domain.usecase.SyncInsertedUseCase
import com.example.contactappwithworker.domain.usecase.SyncMergeUseCase
import com.example.contactappwithworker.domain.usecase.SyncUpdatedUseCase
import com.example.contactappwithworker.domain.usecase.impl.AddContactUseCaseImpl
import com.example.contactappwithworker.domain.usecase.impl.DeleteContactUseCaseImpl
import com.example.contactappwithworker.domain.usecase.impl.LoadContactsUseCaseImpl
import com.example.contactappwithworker.domain.usecase.impl.StartWorkerUseCaseImpl
import com.example.contactappwithworker.domain.usecase.impl.SyncDeleteUseCaseImpl
import com.example.contactappwithworker.domain.usecase.impl.SyncInsertedUseCaseImpl
import com.example.contactappwithworker.domain.usecase.impl.SyncMergeUseCaseImpl
import com.example.contactappwithworker.domain.usecase.impl.SyncUpdatedUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import javax.inject.Singleton

@Module
@InstallIn(ViewModelComponent::class)
interface UseCaseModule {

    @Binds
    fun bindsStartWorkerUseCase(impl: StartWorkerUseCaseImpl): StartWorkerUseCase

    @[Binds Singleton]
    fun bindsDeleteUseCase(impl: SyncDeleteUseCaseImpl): SyncDeleteUseCase

    @[Binds Singleton]
    fun bindsInsertedUseCase(impl: SyncInsertedUseCaseImpl): SyncInsertedUseCase

    @[Binds Singleton]
    fun bindsMergeUseCase(impl: SyncMergeUseCaseImpl): SyncMergeUseCase

    @[Binds Singleton]
    fun bindsUpdateUseCase(impl: SyncUpdatedUseCaseImpl): SyncUpdatedUseCase

    @Binds
    fun bindsLoadContactsUseCase(impl: LoadContactsUseCaseImpl): LoadContactsUseCase

    @Binds
    fun bindDeleteContactUseCase(impl: DeleteContactUseCaseImpl): DeleteContactUseCase

    @Binds
    fun bindAddContactUseCase(impl: AddContactUseCaseImpl): AddContactUseCase


}