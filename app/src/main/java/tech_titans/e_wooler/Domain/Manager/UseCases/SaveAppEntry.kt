package tech_titans.e_wooler.Domain.Manager.UseCases

import tech_titans.e_wooler.Domain.Manager.LocalUserManager

class SaveAppEntry(
    private val localUserManager: LocalUserManager
) {
    suspend operator fun invoke(){
        localUserManager.saveAppEntry()
    }
}