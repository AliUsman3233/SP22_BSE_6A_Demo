package com.example.sp22_bse_6a_demo.remote_configuration

import com.example.sp22_bse_6a_demo.api_tests.models.CatFactModel
import retrofit2.Call
import retrofit2.http.GET



interface ApiInterface {

    @GET("/api/v1/cats")
    fun getCatsData(): Call<List<CatFactModel>?>?
}