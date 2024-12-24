package com.example.sp22_bse_6a_demo

import android.app.Activity
import android.app.Application
import android.content.Context
import android.content.pm.ApplicationInfo
import android.graphics.Color
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.LifecycleOwner

import dagger.hilt.android.HiltAndroidApp


@HiltAndroidApp
class MyApplication : Application() {

    companion object {
        lateinit var context: Context

    }

    override fun onCreate() {
        super.onCreate()
        context = baseContext
    }
}