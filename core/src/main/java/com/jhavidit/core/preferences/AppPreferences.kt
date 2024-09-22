package com.jhavidit.core.preferences


import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AppPreferences @Inject constructor(
    private val preferenceManager: PreferenceManager
) {

    suspend fun saveAuthToken(authToken: String) {
        preferenceManager.saveStringPreference(AUTH_TOKEN, authToken)
    }

     fun getAuthToken() : Flow<String?> {
        return preferenceManager.getStringPreference(AUTH_TOKEN)
    }

    suspend fun removeAuthToken(){
        preferenceManager.removeStringToken(AUTH_TOKEN)
    }

}