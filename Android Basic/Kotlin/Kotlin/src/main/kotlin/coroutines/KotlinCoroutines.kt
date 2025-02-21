package coroutines

import kotlinx.coroutines.*
import kotlin.concurrent.thread

fun threadName(): String = Thread.currentThread().name

fun main() {
    // Add Library org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4
    println()
    println("--------------- Thread ---------------")
    threadSample()

    println()
    println("--------------- Coroutines - Global Scope ---------------")
    globalScopeSample()

    println()
    println("--------------- Coroutines - Run Blocking ---------------")
    runBlockingSample()

    println()
    println("--------------- Coroutines - Launch ---------------")
    launchSample()

    println()
    println("--------------- Coroutines - Async ---------------")
    asyncSample()

    println()
    println("--------------- Coroutines - Job ---------------")
    coroutineJobSample()

    println()
    println("--------------- Coroutines - Job Cancel ---------------")
    coroutineJobCancelSample()


    println()
    println("--------------- Coroutines - Deferred Cancel ---------------")
    coroutineDeferredCancelSample()
}

private fun threadSample() {
    println("Start threadSample")

    thread {
        println("Inside thread before Thread.sleep")
        // Bloquea el hilo de ejecución
        Thread.sleep(500)
        println("Inside thread after Thread.sleep")
    }

    Thread.sleep(1000)
    println("End threadSample")
}

private fun globalScopeSample() {
    println("Start globalScopeSample")

    GlobalScope.launch {
        println("Inside GlobalScope.launch before delay")
        delay(500)
        println("Inside GlobalScope.launch after delay")
    }

    Thread.sleep(1000)
    println("End globalScopeSample")
}

private fun runBlockingSample() {
    println("Start runBlockingSample")

    runBlocking {
        println("Inside runBlocking before delay")
        delay(500)
        println("Inside runBlocking after delay")
    }

    println("End runBlockingSample")
}

private fun launchSample() {
    println("Start launchSample")

    runBlocking {
        println("Inside runBlocking before launch")

        launch {
            println("Inside launch before delay")
            delay(500)
            println("Inside launch after delay")
        }

        println("Inside runBlocking after launch")
    }

    println("End launchSample")
}

private fun asyncSample() {
    println("Start asyncSample")

    runBlocking {
        println("Inside runBlocking before async")

        val randomNumber = async {
            println("Inside async before delay")
            delay(1000)
            println("Inside async after delay")
            (1..10_000_000).random()
        }

        val randomNegativeNumber = async {
            println("Inside async randomNegativeNumber before delay")
            delay(500)
            println("Inside async randomNegativeNumber after delay")
            (-10_000_000..-1).random()
        }

        println("Inside runBlocking after async")
        println("AsyncSample runBlocking, async result: ${randomNumber.await()}, ${randomNegativeNumber.await()}")
        println("Inside runBlocking after async result printed")
    }

    println("End asyncSample")
}

/* Job
Posibles estados de un Job:
NEW: Al crear una coroutine.
ACTIVE: Después de que una coroutine ha sido creada.
CANCELLING: Cancelará todos los Job asociados a las coroutines “hijas”.
CANCELLED: Después de cancelar todas las coroutines asociadas a su Scope.
COMPLETING: Al finalizar la ejecución de la coroutine, el Job esperará a que finalice las coroutine pertenecientes a su Scope.
COMPLETED: Tras finalizar su ejecución, y después finalizar todas las coroutines de su Scope.

Propiedades del Job:
- isActive
- isCompleted
- isCancelled
 */
private fun coroutineJobSample() {
    print("Start coroutineJobSample")

    runBlocking {
        println("Inside runBlocking before launch")
        val job = launch {
            repeat(3) {
                println("Inside launch repeat $it: Active")
                delay(500)
            }
            println("Inside launch after repeat finishing")
        }
        println("Inside runBlocking after launch")

        /*
        while (job.isActive) {
            println("Inside runBlocking: Job still active")
            delay(1000)
        }
         */

        println("Inside runBlocking before job join")
        job.join()

        if (job.isCancelled) {
            println("Inside runBlocking: Job isCancelled")
        }

        if (job.isCompleted) {
            println("Inside runBlocking: Job isCompleted")
        }

        println("Inside runBlocking after job join")
    }

    println("End coroutineJobSample")
}

private fun coroutineJobCancelSample() {
    print("Start coroutineJobCancelSample")

    runBlocking {
        println("Inside runBlocking before launch")
        val job = launch {
            repeat(3) {
                println("Inside launch repeat $it: Active")
                delay(500)
            }
            println("Inside launch after repeat finishing")
        }
        println("Inside runBlocking after launch")

        launch {
            delay(700)
            println("Inside launch before cancelling job")
            job.cancel()
        }

        println("Inside runBlocking before job join")
        job.join()
        println("Inside runBlocking after job join")

        if (job.isCancelled) {
            println("Inside runBlocking: Job isCancelled")
        }

        if (job.isCompleted) {
            println("Inside runBlocking: Job isCompleted")
        }
    }

    println("End coroutineJobCancelSample")
}

private fun coroutineDeferredCancelSample() {
    println("Start coroutineDeferredCancelSample")

    runBlocking {
        println("Inside runBlocking before async")
        val deferred = async {
            repeat(3) {
                println("Inside async repeat $it: Active")
                delay(500)
            }
            println("Inside async after repeat finishing")
            (1..10_000).random()
        }
        println("Inside runBlocking after async")

        launch {
            delay(700)
            println("Inside launch before cancelling deferred")
            deferred.cancel()
        }

        runCatching {
            println("Inside runBlocking after async finished result ${deferred.await()}")
        }.onFailure {
            println("Inside runBlocking after async finished deferred canceled exception: ${it.message}")
        }

        if (deferred.isCancelled) {
            println("Inside runBlocking: Deferred isCancelled")
        }

        if (deferred.isCompleted) {
            println("Inside runBlocking: Deferred isCompleted")
        }
    }

    println("End coroutineDeferredCancelSample")
}