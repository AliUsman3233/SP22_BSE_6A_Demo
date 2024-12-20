package com.example.sp22_bse_6a_demo.second_activity.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.sp22_bse_6a_demo.R
import com.example.sp22_bse_6a_demo.databinding.ActivitySecondBinding
import com.example.sp22_bse_6a_demo.login.ui.LoginActivity
import com.example.sp22_bse_6a_demo.second_activity.model.UserUIModel
import com.google.firebase.Firebase
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.database
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SecondActivity : AppCompatActivity() {

    lateinit var binding: ActivitySecondBinding
    val database = Firebase.database
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_second)

//        val userData = intent.extras
//        val userName = userData?.getString(LoginActivity.userName)
//        val email = userData?.getString(LoginActivity.email)
//        val password = userData?.getString(LoginActivity.passoword)

//        val userUiModel = UserUIModel(
//            userName = userData?.getString(LoginActivity.userName),
//            email = userData?.getString(LoginActivity.email),
//            password = userData?.getString(LoginActivity.passoword)
//        )
        val myRef = database.getReference("counter")
        GlobalScope.launch(Dispatchers.IO) {
            for (i in 1..1000) {
                withContext(Dispatchers.Main) {
                    binding.counterLocalTV.setText(i.toString())
                    myRef.setValue(i.toString())
                }
                delay(1000)
            }
//
//            withContext(Dispatchers.Main) {
//                binding.counterTV.setVisibility(View.GONE)
//                binding.userUiModel = userUiModel
//            }
        }
        myRef.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                binding.counterRemoteTV.setText(snapshot.value.toString())
            }
            override fun onCancelled(error: DatabaseError) {
            }
        })


    }
}