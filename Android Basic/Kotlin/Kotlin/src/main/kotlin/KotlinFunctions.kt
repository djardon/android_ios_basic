fun main() {
    calculateAmount(255.90, tax = 0.5)
    println("David count es: ${"123456".countNumber()}")
    filterCollection()
    letFunction()
    withFunction()
    runFunction()
    alsoFunction()
    applyFunction()
}

private fun calculateAmount(amount: Double, fee: Double = 0.0, tax: Double = 0.0) {
    println("Para el importe $amount los impuestos son ${(amount - fee) * tax} y la comisión $fee")
}

fun String.countNumber(): Int {
    /*
    return  fold(0) { acc, element ->
        if (element.isDigit()) {
            acc + 1
        } else {
            acc
        }
    }
     */

    var count = 0
    forEach {
        if (it.isDigit()) count++
    }
    return count
}

fun <T>Collection<T>.countCharacters(): Int {
    return sumOf {
        if (it is String) {
           it.length
        } else {
            0
        }
    }
}

private fun filterCollection() {
    val colors = mutableListOf("Rojo", "Azul", "Verde", "Naranja", "Amarillo")

    val colorForFiltered = arrayListOf<String>()
    for (color in colors) {
        if (color.length > 4) {
            colorForFiltered.add(color)
        }
    }

    val colorsFiltered = colors.asSequence().filter { it.length > 4 }
}

private fun letFunction() {
    val optionalValue: String? = "null"
    val resultLet = optionalValue?.let {
        println("Dentro del Let")
        "Valor length let ${it.length}"
    } ?: "Valor null"

    print(resultLet)
}

private fun withFunction() {
    var num = 5

    with(num) {
        toString()
    }
}

private fun runFunction() {
    val value = "Ing"

    val newValue = value.run {
        println("Dentro del run")
        "$this Bank"
    }

    println(newValue)
}

private fun alsoFunction() {
    val numbers = mutableListOf("uno", "dos", "tres")
    numbers
        .also {
            println("La lista en also es $it")
        }
        .add("cuatro")
}

private fun applyFunction() {
    val numbers = mutableListOf("uno", "dos", "tres")
    numbers
        .apply {
            println("La lista en also es $this")
        }
        .add("cuatro")
}










