package com.example.sp22_bse_6a_demo

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.sp22_bse_6a_demo.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {


    lateinit var binding: ActivityLoginBinding
    val tag = this@LoginActivity.localClassName
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_login)

        binding.loginBtn.setOnClickListener {
            Log.e(tag, "onCreate: Button clicked -> loginBtn" )
        }

    }
}