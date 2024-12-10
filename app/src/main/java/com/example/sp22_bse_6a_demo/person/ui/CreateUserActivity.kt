package com.example.sp22_bse_6a_demo.person.ui

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.sp22_bse_6a_demo.R
import com.example.sp22_bse_6a_demo.api_tests.models.CatFactModel
import com.example.sp22_bse_6a_demo.application_data_base.dao.PersonDao
import com.example.sp22_bse_6a_demo.application_data_base.entities.PersonEntity
import com.example.sp22_bse_6a_demo.application_data_base.roomDataBase.Sp22Database
import com.example.sp22_bse_6a_demo.databinding.ActivityCreatePersonBinding
import com.example.sp22_bse_6a_demo.person.viewmodel.PersonViewModel
import com.example.sp22_bse_6a_demo.remote_configuration.APIConfiguration
import com.example.sp22_bse_6a_demo.remote_configuration.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class CreateUserActivity : AppCompatActivity() {

    lateinit var binding: ActivityCreatePersonBinding

    val createPersonBtn: String = ""
//    val person: PersonModel = PersonModel()

    var db: Sp22Database? = null
    var personDao: PersonDao? = null
    private val personViewModel: PersonViewModel by viewModels()
    var apiInterface: ApiInterface? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding =
            DataBindingUtil.setContentView(this@CreateUserActivity, R.layout.activity_create_person)

        apiInterface = APIConfiguration.getClient()?.create(ApiInterface::class.java)


        /**
         * GET List Resources
         */
        val call: Call<List<CatFactModel>?>? = apiInterface?.getCatsData()
        call?.enqueue(object : Callback<List<CatFactModel>?>
             {
            override fun onResponse(
                call: Call<List<CatFactModel>?>?,
                response: Response<List<CatFactModel>?>
            ) {
                Log.d("TAG", response.code().toString())
                Log.d("TAG", response.body().toString())
            }

            override fun onFailure(call: Call<List<CatFactModel>?>, t: Throwable?) {
                call.cancel()
            }
        })


        // Corotines

//        var count = 0;
//        lifecycleScope.launch(Dispatchers.IO) {
//            while (true) {
//                delay(100)
//                withContext(Dispatchers.Main) {
//                    binding.counterTV.text = "$count"
//                }
//                count = count + 1
//            }
//        }


//        db = Room.databaseBuilder(
//            applicationContext,
//            Sp22Database::class.java, "sp22_bse"
//        ).build()
//        personDao =  db?.personDao()
        with(binding) {
//            personModel = person

            lifecycleOwner = this@CreateUserActivity
            personViewModel = this@CreateUserActivity.personViewModel
//            createPersonBtn.setOnClickListener {
//                savePersonData(
//                    PersonEntity(
//                        name = person.name,
//                        email = person.email,
//                        age = person.age,
//                        address = person.address
//                    )
//                )
//            }
        }

        personViewModel.personMLD.observe(this@CreateUserActivity) { newPerson ->
            Log.e("CreateUserActivity", "onCreate: personModel = ${newPerson}")
        }

        personViewModel.counterLD.observe(this@CreateUserActivity) { count ->
//            binding.counterTV.text = "$count"
        }

//        GlobalScope.launch(Dispatchers.IO) {
//            while (true) {
//                Log.e("CreateUserActivity", "onCreate: personModel = ${personViewModel.personMLD.value}", )
//                delay(1000)
//            }
//        }

    }


    private fun savePersonData(personEntity: PersonEntity) {
//        personDao?.insertAll(personEntity)
        // val users: List<User> = userDao.getAll()
    }
}