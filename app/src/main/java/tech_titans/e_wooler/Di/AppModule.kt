package tech_titans.e_wooler.Di

import android.app.Application
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import tech_titans.e_wooler.Data.Manager.LocalUserManagerImpl
import tech_titans.e_wooler.Domain.Manager.LocalUserManager
import tech_titans.e_wooler.Domain.Manager.UseCases.AppEntryUseCase
import tech_titans.e_wooler.Domain.Manager.UseCases.EwoolerAppEntry
import tech_titans.e_wooler.Domain.Manager.UseCases.SaveAppEntry
import tech_titans.e_wooler.Presentation.Onboarding.Repository.AuthRepository
import tech_titans.e_wooler.Presentation.Onboarding.Repository.AuthRepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideLocalUserManager(
        application: Application
    ): LocalUserManager = LocalUserManagerImpl(application)


    @Provides
    @Singleton
    fun provideAppEntryUseCase(
        localUserManager: LocalUserManager
    ) = AppEntryUseCase(
        readAppEntry = EwoolerAppEntry(localUserManager),
        saveAppEntry = SaveAppEntry(localUserManager)
    )

    @Provides
    @Singleton
    fun providesFirebaseAuth() = FirebaseAuth.getInstance()


    @Provides
    @Singleton
    fun provideAuthRepository(): AuthRepository = AuthRepositoryImpl(
        auth = Firebase.auth
    )

//    @Provides
//    @Singleton
//    fun providesDatabaseRepositoryImpl(): DatabaseRepository {
//        return DatabaseRepositoryImpl()
//    }


}