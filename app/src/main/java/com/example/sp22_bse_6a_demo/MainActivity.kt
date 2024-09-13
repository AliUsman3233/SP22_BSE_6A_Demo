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
        print("result of sum = ${add(num2 = 70, num1 =  40)}")

        dispaly(name = "ALi", num =  20)
    }

    fun add(num1: Int, num2: Int): Int {
//        return num1 + num2;
        val sum = num1 + num2;
        return sum

    }

    fun dispaly(num: Int, name: String) {
        print("num  = $num")
        print("name = $name")
    }


}