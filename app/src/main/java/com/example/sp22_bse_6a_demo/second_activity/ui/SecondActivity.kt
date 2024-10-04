package com.example.sp22_bse_6a_demo.second_activity.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.sp22_bse_6a_demo.R
import com.example.sp22_bse_6a_demo.databinding.ActivitySecondBinding
import com.example.sp22_bse_6a_demo.login.LoginActivity
import com.example.sp22_bse_6a_demo.second_activity.model.UserUIModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SecondActivity : AppCompatActivity() {

    lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_second)

        val userData = intent.extras
//        val userName = userData?.getString(LoginActivity.userName)
//        val email = userData?.getString(LoginActivity.email)
//        val password = userData?.getString(LoginActivity.passoword)

        val userUiModel = UserUIModel(
            userName = userData?.getString(LoginActivity.userName),
            email = userData?.getString(LoginActivity.email),
            password = userData?.getString(LoginActivity.passoword)
        )

        GlobalScope.launch(Dispatchers.IO) {
            for (i in 1..5) {
                withContext(Dispatchers.Main) {
                    binding.counterTV.setText(i.toString())
                }
                delay(1000)
            }

            withContext(Dispatchers.Main) {
                binding.counterTV.setVisibility(View.GONE)
                binding.userUiModel = userUiModel
            }
        }


    }
}