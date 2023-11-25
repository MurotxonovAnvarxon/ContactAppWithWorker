package com.example.contactappwithworker.data.source.local.room.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.contactappwithworker.data.source.local.room.entity.DeletedContactEntity
@Dao
interface DeletedContactDao : BaseDao<DeletedContactEntity> {
    @Query("SELECT * FROM DeletedContactEntity")
    suspend fun getAll(): List<DeletedContactEntity>
}