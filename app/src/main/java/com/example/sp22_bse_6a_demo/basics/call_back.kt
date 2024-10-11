package com.example.sp22_bse_6a_demo.basics

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


val tag = "test"

fun main() {
    makeCalculations(a = 2, b = 4)

    runBlocking {
        delay(20000000)
    }
}

fun makeCalculations(a: Int, b: Int) {
    calculateSum(a = a, b = b, callBack = { data ->
        println(tag + "   makeCalculations: data = ${data}")
    })

    calculateDiv(a = a, b = b, callBack = { data ->
        println(tag + "  makeCalculations: data = ${data}")
    })

    calculateSub(a = a, b = b, callBack = { data ->
        println(tag + "  makeCalculations: data = ${data}")
    })

}

fun calculateSum(a: Int, b: Int, callBack: (Int) -> Unit) {

    GlobalScope.launch(Dispatchers.IO) {
        delay(2000)
        callBack.invoke(a + b)
    }
}

fun calculateDiv(a: Int, b: Int, callBack: (Int) -> Unit) {
    GlobalScope.launch(Dispatchers.IO) {
        delay(3000)
        callBack.invoke(a / b)
    }
}

fun calculateSub(a: Int, b: Int, callBack: (Int) -> Unit) {
    GlobalScope.launch(Dispatchers.IO) {
        delay(5000)
        callBack.invoke(a - b)
    }
}