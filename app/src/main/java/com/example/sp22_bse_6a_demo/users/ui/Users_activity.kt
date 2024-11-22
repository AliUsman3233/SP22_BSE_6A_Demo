package com.example.sp22_bse_6a_demo.users.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sp22_bse_6a_demo.R
import com.example.sp22_bse_6a_demo.databinding.ActivityUsersBinding
import com.example.sp22_bse_6a_demo.users.adopter.UserAdopter
import com.example.sp22_bse_6a_demo.users.model.Gender
import com.example.sp22_bse_6a_demo.users.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class users_activity : AppCompatActivity() {

    lateinit var binding: ActivityUsersBinding
    val userAdopter: UserAdopter =
        UserAdopter(UserAdopter.diffCallBack, maleNameClickCallBack = { name ->
            Toast.makeText(
                this@users_activity,
                "(Male) User just clicked on $name",
                Toast.LENGTH_SHORT
            )
                .show()
        }, feMaleNameClickCallBack = { name ->
            Toast.makeText(
                this@users_activity,
                "(Female) User just clicked on $name",
                Toast.LENGTH_SHORT
            )
                .show()
        })

    var userList: List<User> = arrayListOf(
        User("Maowiz", 21, Gender.MALE),
        User("Umar", 21, Gender.MALE),
        User("Mehwish Hayat", 50, Gender.FEMALE),
        User("Anwar", 23, Gender.MALE),
        User("Nasir Mehdi", 40, Gender.MALE),
        User("Hassan", 23, Gender.MALE),
        User("Hania Amir", 23, Gender.FEMALE),
        User("Umar Farooq", 23, Gender.MALE),
        User("Muhammad Bilal", 20, Gender.MALE),
        User("Laiba Khan", 23, Gender.FEMALE),
        User("Hamza", 23, Gender.MALE),
        User("Kashif", 20, Gender.MALE),
        User("Nimra Mehra", 23, Gender.FEMALE),
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this@users_activity, R.layout.activity_users)

        userAdopter.submitList(userList)
        binding.userRV.adapter = userAdopter
        binding.userRV.layoutManager = LinearLayoutManager(this)

        GlobalScope.launch(Dispatchers.IO) {
            delay(10000)
            userList = userList.map { user: User ->
                user.copy(name = user.name?.split(" ")?.get(0),)
            }
            userAdopter.submitList(userList)
            withContext(Dispatchers.Main) {
                userAdopter.notifyDataSetChanged()
            }
        }

    }
}