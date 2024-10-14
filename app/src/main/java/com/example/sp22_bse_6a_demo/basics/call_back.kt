package com.example.sp22_bse_6a_demo.basics

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


val tag = "test"

fun main() {
    makeCalculations(a = 2, b = 4, messageCallBack = { message ->
        println(message)
    })

    runBlocking {
        delay(20000000)
    }
}


enum class State {
    STARTED,
    COMPUTED,
    FINISHED
}

fun makeCalculations(a: Int, b: Int, messageCallBack: (String) -> Unit) {
    calculateSum(a = a, b = b, callBack = { data ->
        println(tag + "   makeCalculations: data = ${data}")
    }, messageCallBack = { message, state ->
        messageCallBack.invoke(message + state.toString())
    })

    calculateDiv(a = a, b = b, callBack = { data ->
        println(tag + "  makeCalculations: data = ${data}")
    }, messageCallBack = { message, state ->
        messageCallBack.invoke(message + state.toString())
    })

    calculateSub(a = a, b = b, callBack = { data ->
        println(tag + "  makeCalculations: data = ${data}")
    }, messageCallBack = { message, state ->
        messageCallBack.invoke(message + state.toString())
    })

}

fun calculateSum(
    a: Int,
    b: Int,
    callBack: (Int) -> Unit,
    messageCallBack: (String, State) -> Unit
) {

    GlobalScope.launch(Dispatchers.IO) {
        messageCallBack.invoke("Computation for SUM is ", State.STARTED)
        delay(2000)
        messageCallBack.invoke("Computation for SUM is ", State.COMPUTED)
        callBack.invoke(a + b)
        messageCallBack.invoke("Computation for SUM is ", State.FINISHED)

    }
}

fun calculateDiv(
    a: Int,
    b: Int,
    callBack: (Int) -> Unit,
    messageCallBack: (String, State) -> Unit
) {
    GlobalScope.launch(Dispatchers.IO) {
        messageCallBack.invoke("Computation for DIV is ", State.STARTED)
        delay(5000)
        messageCallBack.invoke("Computation for DIV is ", State.COMPUTED)
        callBack.invoke(a / b)
        messageCallBack.invoke("Computation for DIV is ", State.FINISHED)
    }
}

fun calculateSub(
    a: Int,
    b: Int,
    callBack: (Int) -> Unit,
    messageCallBack: (String, State) -> Unit
) {
    GlobalScope.launch(Dispatchers.IO) {
        messageCallBack.invoke("Computation for SUB is ", State.STARTED)
        delay(10000)
        messageCallBack.invoke("Computation for SUB is ", State.COMPUTED)
        callBack.invoke(a - b)
        messageCallBack.invoke("Computation for SUB is ", State.FINISHED)
    }
}