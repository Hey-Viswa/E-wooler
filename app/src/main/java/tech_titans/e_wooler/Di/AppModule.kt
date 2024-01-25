package tech_titans.e_wooler.Di

import android.app.Application
import com.google.firebase.auth.FirebaseAuth
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import tech_titans.e_wooler.AuthRepository
import tech_titans.e_wooler.Data.Manager.LocalUserManagerImpl
import tech_titans.e_wooler.Domain.Manager.LocalUserManager
import tech_titans.e_wooler.Domain.Manager.UseCases.AppEntryUseCase
import tech_titans.e_wooler.Domain.Manager.UseCases.EwoolerAppEntry
import tech_titans.e_wooler.Domain.Manager.UseCases.SaveAppEntry
import tech_titans.e_wooler.Util.AuthRepositoryImpl
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
    fun providesAuthRepositoryImpl(firebaseAuth: FirebaseAuth):AuthRepository{
        return AuthRepositoryImpl(firebaseAuth = firebaseAuth)
    }

//    @Provides
//    @Singleton
//    fun providesDatabaseRepositoryImpl(): DatabaseRepository {
//        return DatabaseRepositoryImpl()
//    }


}