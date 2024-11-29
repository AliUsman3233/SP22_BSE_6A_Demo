package com.example.sp22_bse_6a_demo.basics

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


fun main()  = runBlocking {
    counter()

    while(true){}
}



suspend fun counter() {
    var count1: Int = 0
    var count2: Int = 1000000
    val firstCortine: Job = GlobalScope.launch(Dispatchers.IO) {
        while(count1<10) {
            println("current count value = $count1")
            count1 = count1 + 1
            delay(500)
        }
    }
    firstCortine.join()
    val secondCorotine:Job = GlobalScope.launch(Dispatchers.IO) {
        while(true) {
            println("current count value = $count2")
            count2 = count2 - 1
            delay(2000)
        }
    }
    val a = 20;
    val b = 30

    println("sum  = ${a+b}")
    secondCorotine.join()
}