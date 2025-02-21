package coroutines

import kotlinx.coroutines.*
import java.math.BigInteger
import java.util.*
import kotlin.system.measureTimeMillis
import kotlin.time.ExperimentalTime
import kotlin.time.measureTimedValue

fun main() {
    println()
    println("--------------- Suspend concurrent ---------------")
    callSuspendFunctions()

    println()
    println("--------------- Suspend call function ---------------")
    callToSuspendFunction()

    println()
    println("--------------- Suspend call function 2 ---------------")
    callToGenerateNumberSuspend()

    println()
    println("--------------- Suspend call big calculations ---------------")
    callConcurrentParallel()
}

private fun callSuspendFunctions() {
    println("Start callSuspendFunctions")

    runBlocking {
        launch {
            testCoroutine1()
        }

        launch {
            testCoroutine2()
        }
    }

    println("End callSuspendFunctions")
}

suspend fun testCoroutine1() {
    println("Start testCoroutine1: ${threadName()}")
    delay(1500)
    println("End testCoroutine1: ${threadName()}")
}

suspend fun testCoroutine2() {
    println("Start testCoroutine2: ${threadName()}")
    delay(1000)
    println("End testCoroutine2: ${threadName()}")
}


private fun callToSuspendFunction() {
    println("Start callToSuspendFunction")
    println()

    runBlocking {
        println("RunBlocking before call suspendFunction")
        suspendFunctionLoadData()
        println("RunBlocking after call suspendFunction")
    }

    println()
    println("End callToSuspendFunction")
}

suspend fun suspendFunctionLoadData() {
    println("Start suspendFunctionLoadData")

    withContext(Dispatchers.IO) {
        println("Inside withContext before delay")
        delay(500)
        println("Inside withContext after delay")
    }

    println("End suspendFunctionLoadData")
}


private fun callToGenerateNumberSuspend() {
    println("Start callToGenerateNumberSuspend")

    runBlocking {
        println("Inside runBlocking before generateRandomNumber")
        val randomNumber = generateRandomNumber()
        println("Inside runBlocking after generateRandomNumber, result: $randomNumber")
    }

    println("End callToGenerateNumberSuspend")
}

private suspend fun generateRandomNumber(): Int = withContext(Dispatchers.IO) {
    println("Generating random number...")
    delay(2000)
    val random = (0..1_000_000).random()
    println("Random number generated: $random")
    random
}


fun callConcurrentParallel() {
    println("Start callConcurrentParallel")
    println()

    runBlocking {
        measureTimeMillis {
            val prime = async { calculatePrime() }
            val integer = async { calculateInt() }

            println("Result integer: ${integer.await()}, prime: ${prime.await()}")
        }.also {
            println("CallConcurrentLogic completed in $it ms")
        }
    }

    println()
    println("End callConcurrentParallel")
}


@OptIn(ExperimentalTime::class)
suspend fun calculatePrime(): BigInteger = withContext(Dispatchers.IO) {
    measureTimedValue {
        println("Calculating prime...")
        BigInteger(1500, Random()).nextProbablePrime()
    }.also {
        println("Prime calculation took ${it.duration} ms")
        println("Prime calculation finished")
    }.value
}

suspend fun calculateInt(): Int {
    println("Start calculateInt")
    delay(1000)
    println("End calculateInt")
    return 38
}