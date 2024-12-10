package com.example.sp22_bse_6a_demo.api_tests.models

import com.google.gson.annotations.SerializedName

data class CatFactModel(
    @SerializedName("id") var id: Int? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("origin") var origin: String? = null,
    @SerializedName("temperament") var temperament: String? = null,
    @SerializedName("colors") var colors: ArrayList<String> = arrayListOf(),
    @SerializedName("description") var description: String? = null,
    @SerializedName("image") var image: String? = null
)