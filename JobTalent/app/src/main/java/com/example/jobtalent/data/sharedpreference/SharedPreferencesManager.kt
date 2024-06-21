package com.example.jobtalent.data.sharedpreference

import android.content.Context
import com.example.jobtalent.utils.PreferencesKey.EMAIL_KEY
import com.example.jobtalent.utils.PreferencesKey.NAME_PREF

class SharedPreferencesManager(context: Context) {
    private val preferences = context.getSharedPreferences(NAME_PREF, Context.MODE_PRIVATE)
    private val editor = preferences.edit()

    var name
        get() = preferences.getString(NAME_PREF, "")
        set(value) {
            editor.putString(NAME_PREF, value)
            editor.commit()
        }

    var email
        get() = preferences.getString(EMAIL_KEY, "")
        set(value) {
            editor.putString(EMAIL_KEY, value)
            editor.commit()
        }

    fun clear() {
        editor.clear()
        editor.commit()
    }
}