package com.jhavidit.core.preferences

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class PreferenceManager @Inject constructor(
    private val dataStore: DataStore<Preferences>
) {
    suspend fun saveIntPreference(key: String, value: Int) {
        val dataStoreKey = intPreferencesKey(key)
        dataStore.edit { preferences ->
            preferences[dataStoreKey] = value
        }
    }

    fun getIntPreference(key: String, defaultValue: Int): Flow<Int> {
        val dataStoreKey = intPreferencesKey(key)
        return dataStore.data.catch {
            emit(emptyPreferences())
        }.map { preferences ->
            preferences[dataStoreKey] ?: defaultValue
        }
    }

    suspend fun saveStringPreference(key: String, value: String) {
        val dataStoreKey = stringPreferencesKey(key)
        dataStore.edit { preferences ->
            preferences[dataStoreKey] = value
        }
    }

    fun getStringPreference(key: String): Flow<String?> {
        val dataStoreKey = stringPreferencesKey(key)
        return dataStore.data.catch {
            emit(emptyPreferences())
        }.map { preferences ->
            preferences[dataStoreKey]
        }
    }

    suspend fun saveBooleanPreference(key: String, value: Boolean) {
        val dataStoreKey = booleanPreferencesKey(key)
        dataStore.edit { preferences ->
            preferences[dataStoreKey] = value
        }
    }

    fun getBooleanPreference(key: String, defaultValue: Boolean): Flow<Boolean> {
        val dataStoreKey = booleanPreferencesKey(key)
        return dataStore.data.catch {
            emit(emptyPreferences())
        }.map { preferences ->
            preferences[dataStoreKey] ?: defaultValue
        }
    }

    suspend fun removeStringToken(key: String) {
        val dataStoreKey = stringPreferencesKey(key)
        dataStore.edit { preferences ->
            preferences.remove(dataStoreKey)
        }
    }

    suspend fun removeIntToken(key: String) {
        val dataStoreKey = intPreferencesKey(key)
        dataStore.edit { preferences ->
            preferences.remove(dataStoreKey)
        }
    }

    suspend fun removeBooleanToken(key: String) {
        val dataStoreKey = booleanPreferencesKey(key)
        dataStore.edit { preferences ->
            preferences.remove(dataStoreKey)
        }
    }


}