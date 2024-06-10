package com.example.it_learn_app.repositorys
import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.PreferencesSerializer.defaultValue
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewmodel.CreationExtras
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

class UserSettingsDataRepository(val context: Context) {

    /*
    fun <T>getUserSettings(settingsKey: Preferences.Key<T>):
            LiveData<T>{
        return context.dataStore.data
            .map { preferences ->
                preferences[settingsKey] ?: defaultValue
            }
            .asLiveData()
    }
    */

    suspend fun <T>setUserSettings(context: Context,settingsKey: Preferences.Key<T>,newSettings: T){
        context.dataStore.edit { settings ->
            settings[settingsKey] = newSettings
        }
    }
}