package com.app.pizzahut.data.preferences

import androidx.appcompat.app.AppCompatActivity
import com.app.pizzahut.MainActivity

object SharedPreferencesManager {

    private val manager by lazy {
        MainActivity.activity.getSharedPreferences("Ping", AppCompatActivity.MODE_PRIVATE)
    }
    private val shEditor by lazy {
        manager.edit()
    }

    fun setKeyValue(key: String, value: String) {
        shEditor.putString(key, value).apply()
    }

    fun getValue(key: String): String? {
        return manager.getString(key, null)
    }
}