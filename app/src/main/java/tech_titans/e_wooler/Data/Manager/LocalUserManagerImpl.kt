package tech_titans.e_wooler.Data.Manager

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import tech_titans.e_wooler.Domain.Manager.LocalUserManager
import tech_titans.e_wooler.Util.Constants
import tech_titans.e_wooler.Util.Constants.USER_SETTING


class LocalUserManagerImpl(
    private val context: Context
): LocalUserManager {
    override suspend fun saveAppEntry() {
       context.dataStore.edit { settings ->
           settings[PreferencesKeys.APP_ENTRY] = true

       }
    }

    override fun LoginEntry(): Flow<Boolean> {
       return context.dataStore.data.map { preferences ->
           preferences[PreferencesKeys.APP_ENTRY] ?: false
       }
    }
}

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = USER_SETTING)

private object PreferencesKeys{
    val APP_ENTRY = booleanPreferencesKey(name = Constants.APP_ENTRY)
}
