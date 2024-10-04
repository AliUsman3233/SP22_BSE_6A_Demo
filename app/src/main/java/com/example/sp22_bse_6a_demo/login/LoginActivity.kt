package com.example.sp22_bse_6a_demo.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.sp22_bse_6a_demo.MainActivity
import com.example.sp22_bse_6a_demo.R
import com.example.sp22_bse_6a_demo.second_activity.ui.SecondActivity
import com.example.sp22_bse_6a_demo.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    val tag = this@LoginActivity.javaClass.name

    companion object {
        val userName = "UserName"
        val email = "Email"
        val passoword = "Password"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)

        binding.loginBtn.setOnClickListener {
            Log.e(tag, "onCreate: Button clicked -> loginBtn")
//            Toast.makeText(this@LoginActivity, "Button clicked -> loginBtn", Toast.LENGTH_LONG)
//                .show()
            val nextScreenIntent = Intent(this@LoginActivity, SecondActivity::class.java)
            nextScreenIntent.putExtra(userName,binding.userNameET.text.toString())
            nextScreenIntent.putExtra(email,binding.emailET.text.toString())
            nextScreenIntent.putExtra(passoword,binding.passwordET.text.toString())
            Toast.makeText(this@LoginActivity, "${binding.userNameET.text}", Toast.LENGTH_LONG)
                .show()
            startActivity(nextScreenIntent)

        }

        binding.signupBtn.setOnClickListener {
            startActivity(
                Intent(this@LoginActivity, MainActivity::class.java)
            )
            finish()
        }

    }
}