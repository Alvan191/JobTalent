package com.example.jobtalent.utils

import androidx.datastore.preferences.core.booleanPreferencesKey

object PreferencesKey {
    const val NAME_PREF = "name"

    val STATUS_LOGIN_KEY = booleanPreferencesKey("status_login")
}