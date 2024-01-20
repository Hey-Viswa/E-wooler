package tech_titans.e_wooler.Domain.Manager

import kotlinx.coroutines.flow.Flow

interface LocalUserManager {
    suspend fun saveAppEntry()

    fun LoginEntry(): Flow<Boolean>



}