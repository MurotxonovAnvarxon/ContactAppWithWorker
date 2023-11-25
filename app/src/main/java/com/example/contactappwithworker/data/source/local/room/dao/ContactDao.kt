package com.example.contactappwithworker.data.source.local.room.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import kotlinx.coroutines.flow.Flow
import com.example.contactappwithworker.data.source.local.room.entity.ContactEntity

@Dao
interface ContactDao : BaseDao<ContactEntity> {
    @Query("select * from contactentity where id =:id and needSync = :state")
    suspend fun getByIdAndState(id: Int, state: Boolean): List<ContactEntity>

    @Query("select * from ContactEntity where id != :id and needSync = :state")
    suspend fun getNeedUpdates(id: Int = 0, state: Boolean = true): List<ContactEntity>

    @Query("delete from contactentity")
    suspend fun clearCache()

    @Transaction
    suspend fun resetItem(old: ContactEntity, newItem: ContactEntity) {
        delete(old)
        insert(newItem)
    }

    @Transaction
    suspend fun resetAllTime(items: List<ContactEntity>) {
        clearCache()
        insertAll(items)
    }

    @Query("SELECT * FROM contactentity")
    fun getAllContacts(): Flow<List<ContactEntity>>
}