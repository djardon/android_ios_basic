fun main(args: Array<String>) {
    forLoop()
    whileLoop()
}

private fun forLoop () {
    val friends = arrayOf("David", "Sara", "Ángel", "Óliver", "Paula")

    for (friend in friends) {
        println(friend)
    }

    friends.forEach { item ->
        println("EL elemento $item pertenece a $friends")
    }

    friends.forEachIndexed { index, item ->
        println("EL elemento $item posición $index")
    }

    for (i in 5..15 step 2) {
        println(i)
    }
}

private fun whileLoop() {
    var isNetworkConnected = true

    while (isNetworkConnected) {
        println("La conexión es estable")
        isNetworkConnected = false
    }

    do {
        println("La conexión a internet parece estable")
    } while (isNetworkConnected)
}
