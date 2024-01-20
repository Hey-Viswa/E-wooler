package tech_titans.e_wooler.Domain.Manager.UseCases

import kotlinx.coroutines.flow.Flow
import tech_titans.e_wooler.Domain.Manager.LocalUserManager

class EwoolerAppEntry(
    private val localUserManager: LocalUserManager
) {
    suspend operator fun invoke(): Flow<Boolean>{
        return localUserManager.LoginEntry()
    }
}