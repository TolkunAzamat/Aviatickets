package com.example.aviatickets.sharedpreference

import android.content.Context
import android.content.SharedPreferences

class SharedPreferences(context: Context) {
    private val APP_NAME="SharedPreference"
    private var pref: SharedPreferences
    init{
        pref=context.getSharedPreferences(APP_NAME, Context.MODE_PRIVATE)

    }
    var number:String?
        get()=pref.getString("number",null)
        set(value)=pref.edit().putString("number",value).apply ()
    var password:String?
        get()=pref.getString("password",null)
        set(value)=pref.edit().putString("password",value).apply ()
}