package coroutines

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.ContinuationInterceptor

/* Tipos de Dispatchers:
Default: Usado por defecto por los constructores estándar como launch y async.
IO: Para tareas de larga duración, por ejemplo acceder a una base de datos o escribir/leer un archivo.
Main: Necesario para invocar al hilo principal. Modificación de la interfaz de usuario.
Unconfined: Para ejecutar una coroutine inmediatamente después de haber sido creada para evitar
efectos no deseados. En tareas que no consumen muchos recursos computacionales y
cuando no se accede a datos compartidos con otros hilos.
 */

fun main() {
    println()
    println("--------------- Dispatchers - Default ---------------")
    dispatcherDefault()

    println()
    println("--------------- Dispatchers - Child ---------------")
    dispatcherChildren()
}

private fun dispatcherDefault() {
    println("Start dispatcherDefault")

    val repetitions = 100

    runBlocking {
        launch(Dispatchers.IO) {
            repeat(repetitions) {
                println("Inside launch 1 repeat: $it")
            }
        }

        launch(Dispatchers.Default) {
            repeat(repetitions) {
                println("Inside launch 2 repeat: $it")
            }
        }
    }

    println("End dispatcherDefault")
}

private fun dispatcherChildren() {
    println("Start dispatcherChildren")

    runBlocking {
        launch(Dispatchers.IO) {
            println("Inside launch parent before child: $coroutineContext ${threadName()}")

            launch(Dispatchers.Default) {
                println("Inside launch child: $coroutineContext ${threadName()}")
            }

            println("Inside launch parent after child: $coroutineContext ${threadName()}")
        }
    }

    println("End dispatcherChildren")
}