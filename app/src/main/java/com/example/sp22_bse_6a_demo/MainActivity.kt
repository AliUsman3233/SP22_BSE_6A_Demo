package com.example.sp22_bse_6a_demo

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        print("I am Android")

        add(num2 = 70, num1 =  40)
        dispaly(name = "ALi", num =  20)
    }

    fun add(num1: Int, num2: Int): Int {
        return num1 + num2;
    }

    fun dispaly(num: Int, name: String) {
        print("num  = $num")
        print("name = $name")
    }


}