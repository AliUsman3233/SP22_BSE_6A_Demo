package com.example.sp22_bse_6a_demo.users.ui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sp22_bse_6a_demo.R
import com.example.sp22_bse_6a_demo.databinding.ActivityUsersBinding
import com.example.sp22_bse_6a_demo.users.adopter.UserAdopter
import com.example.sp22_bse_6a_demo.users.model.User

class users_activity : AppCompatActivity() {

    lateinit var binding: ActivityUsersBinding
    val userAdopter: UserAdopter =  UserAdopter(UserAdopter.diffCallBack)

    val userList: List<User> = arrayListOf(
        User("Maowiz", 21),
        User("Umar", 21),
        User("Anwar", 23),
        User("Nasir Mehdi", 40),
        User("Hassan", 23),
        User("Umar Farooq", 23),
        User("Muhammad Bilal", 20),
        User("Hamza", 23),
        User("Kashif", 20),
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this@users_activity,R.layout.activity_users)

        userAdopter.submitList(userList)
        binding.userRV.adapter = userAdopter
        binding.userRV.layoutManager = LinearLayoutManager(this)

    }
}