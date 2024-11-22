package com.example.sp22_bse_6a_demo.person.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.room.Room
import com.example.sp22_bse_6a_demo.R
import com.example.sp22_bse_6a_demo.application_data_base.dao.PersonDao
import com.example.sp22_bse_6a_demo.application_data_base.entities.PersonEntity
import com.example.sp22_bse_6a_demo.application_data_base.roomDataBase.Sp22Database
import com.example.sp22_bse_6a_demo.databinding.ActivityCreatePersonBinding
import com.example.sp22_bse_6a_demo.person.model.PersonModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CreateUserActivity : AppCompatActivity() {

    lateinit var binding: ActivityCreatePersonBinding

    val createPersonBtn: String = ""
    val person: PersonModel = PersonModel()

    var db : Sp22Database? = null
    var personDao: PersonDao? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding =
            DataBindingUtil.setContentView(this@CreateUserActivity, R.layout.activity_create_person)

        db = Room.databaseBuilder(
            applicationContext,
            Sp22Database::class.java, "sp22_bse"
        ).build()
        personDao =  db?.personDao()
        with(binding) {
            personModel = person
            lifecycleOwner = this@CreateUserActivity
            createPersonBtn.setOnClickListener {
                savePersonData(
                    PersonEntity(
                        name = person.name,
                        email = person.email,
                        age = person.age,
                        address = person.address
                    )
                )
            }
        }


//        GlobalScope.launch(Dispatchers.IO) {
//            while (true) {
//                Log.e("CreateUserActivity", "onCreate: personModel = ${person}", )
//                delay(1000)
//            }
//        }

    }


    private fun savePersonData(personEntity: PersonEntity) {
        personDao?.insertAll(personEntity)
        // val users: List<User> = userDao.getAll()
    }
}