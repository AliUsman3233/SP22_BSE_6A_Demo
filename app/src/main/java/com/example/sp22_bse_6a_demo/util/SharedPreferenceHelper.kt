package com.example.sp22_bse_6a_demo.util

import android.content.Context

class SharedPreferenceHelper {

    companion object {
        fun saveUserName(context: Context, name: String?) {
            val sharedPreferences = context.getSharedPreferences("SP22", Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putString(CONST.USER_NAME, name?:"")
            editor.apply()
        }

        fun getUserName(context: Context):String {
            val sharedPreferences = context.getSharedPreferences("SP22", Context.MODE_PRIVATE)
            return sharedPreferences.getString(CONST.USER_NAME, "")!!
        }
    }
}