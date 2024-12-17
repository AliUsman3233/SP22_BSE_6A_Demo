package com.example.sp22_bse_6a_demo.api_tests.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sp22_bse_6a_demo.R
import com.example.sp22_bse_6a_demo.api_tests.adopters.CatAdapter
import com.example.sp22_bse_6a_demo.api_tests.models.CatFactModel
import com.example.sp22_bse_6a_demo.databinding.ActivityCatBinding
import com.example.sp22_bse_6a_demo.remote_configuration.APIConfiguration
import com.example.sp22_bse_6a_demo.remote_configuration.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class CatsActivity : AppCompatActivity() {
    lateinit var binding: ActivityCatBinding
    var catAdopter: CatAdapter? = null
    var catList: MutableList<CatFactModel> = arrayListOf()
    var apiInterface: ApiInterface? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this@CatsActivity, R.layout.activity_cat)
        // Create a list of Cat objects
//        catList.add(
//            CatFactModel(
//                1, "Persian", "Iran", "Sweet, Gentle, Quiet",
//                arrayListOf(),
//                "The Persian cat is a long-haired breed known for its luxurious coat and sweet personality. They are calm and affectionate cats that enjoy a relaxed indoor lifestyle.",
//                "https://fakeimg.pl/500x500/cc5500"
//            )
//        )


        apiInterface = APIConfiguration.getClient()?.create(ApiInterface::class.java)


        /**
         * GET List Resources
         */
        val call: Call<List<CatFactModel>?>? = apiInterface?.getCatsData()
        call?.enqueue(object : Callback<List<CatFactModel>?> {
            override fun onResponse(
                call: Call<List<CatFactModel>?>?,
                response: Response<List<CatFactModel>?>?
            ) {
//                Log.d("TAG", response?.code().toString())
//                Log.d("TAG", response?.body().toString())
                val data = response?.body()?.map { actualData -> actualData.copy(image = "https://cdn.britannica.com/34/235834-050-C5843610/two-different-breeds-of-cats-side-by-side-outdoors-in-the-garden.jpg") }
//                data?.get(0)?.image = "https://cdn.britannica.com/34/235834-050-C5843610/two-different-breeds-of-cats-side-by-side-outdoors-in-the-garden.jpg"

                catAdopter = CatAdapter(data?: arrayListOf())
                binding.catRV.setAdapter(catAdopter)
                binding.catRV.layoutManager =
                    LinearLayoutManager(this@CatsActivity, RecyclerView.VERTICAL, false)

                catAdopter?.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<List<CatFactModel>?>?, t: Throwable?) {
                call?.cancel()
            }

        })


    }
}