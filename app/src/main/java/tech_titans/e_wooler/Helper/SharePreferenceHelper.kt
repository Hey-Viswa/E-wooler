package tech_titans.e_wooler.Helper

import android.content.Context
import android.content.SharedPreferences

object SharedPreferencesHelper {
    private const val PREF_NAME = "WoolerPrefs"
    private const val KEY_IS_LOGGED_IN = "isLoggedIn"

    fun setLoggedIn(context: Context, isLoggedIn: Boolean) {
        val editor: SharedPreferences.Editor =
            context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE).edit()
        editor.putBoolean(KEY_IS_LOGGED_IN, isLoggedIn)
        editor.apply()
    }

    fun isLoggedIn(context: Context): Boolean {
        val prefs: SharedPreferences =
            context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        return prefs.getBoolean(KEY_IS_LOGGED_IN, false)
    }
}
