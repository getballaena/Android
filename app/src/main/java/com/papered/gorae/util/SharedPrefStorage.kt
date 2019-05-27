package com.papered.gorae.util

import android.content.Context
import android.content.SharedPreferences
import java.util.*

val key = "uuid"

fun saveToken(context: Context, token: String) =
    getPref(context).edit().let {
        it.putString(key, token)
        it.apply()
    }

fun getToken(context: Context): String {
    if (getPref(context).getString(key, "") == "") {
        saveToken(context, UUID.randomUUID().toString())
    }
    return getPref(context).getString(key, "")
}

fun removeToken(context: Context) =
    getPref(context).edit().let {
        it.remove(key)
        it.apply()
    }

private fun getPref(context: Context): SharedPreferences = context.getSharedPreferences("pref", Context.MODE_PRIVATE)

