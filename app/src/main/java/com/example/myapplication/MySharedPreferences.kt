package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences

class MySharedPreferences {
    var context : Context
    var sharedPreferences : SharedPreferences
    val editor : SharedPreferences.Editor

    @SuppressLint("CommitPrefEdits")
    constructor(context: Context) {
        this.context = context
        this.sharedPreferences = context.getSharedPreferences("TALLER_KOTLIN_FORM", Context.MODE_PRIVATE)
        this.editor = this.sharedPreferences.edit()
    }
    fun put(key:String, value : String) {
        this.editor.putString(key, value)
    }
    fun save() {
        this.editor.apply()
    }

    fun getKey(key: String) : String? {
        return this.sharedPreferences.getString(key, "none")
    }

}