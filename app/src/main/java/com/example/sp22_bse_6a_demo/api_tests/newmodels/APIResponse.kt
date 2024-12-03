package com.example.sp22_bse_6a_demo.api_tests.newmodels

data class APIResponse(
    val bpi: Bpi,
    val chartName: String,
    val disclaimer: String,
    val time: Time
)

data class Bpi(
    val EUR: Currency,
    val GBP: Currency,
    val USD: Currency
)

data class Time(
    val updated: String,
    val updatedISO: String,
    val updateduk: String
)

data class Currency(
    val code: String,
    val description: String,
    val rate: String,
    val rate_float: Double,
    val symbol: String
)