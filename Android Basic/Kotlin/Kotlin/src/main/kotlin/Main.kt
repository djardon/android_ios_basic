fun main(args: Array<String>) {
    println("Hello World!")

    variablesStrings()
    variablesCast()
    stringInterpolation()
    controlFlow()
}

private fun variablesStrings() {
    var str = "Hola"
    str = "$str, Kotlin"
    println(str)

    val strConstants = "Hello"
    println(strConstants)
}

private fun variablesCast() {
    val numCast = 50
    val numDouble = 20.3

    println(numCast.toString())
    println(numDouble.toInt())

    val stringCast = "David".toIntOrNull()
}

private fun stringInterpolation() {
    val amount = 4_000_000f
    val currency = "€"

    println("Mi cuenta bancaria en $currency tiene $amount $currency")

    // Formateo de valores en String
    // %d - int Value
    // %f - float value
    // %ld - long value
    // %s - string value
    println(String.format(
        "Mi cuenta bancaria en %s tiene %.2f %s",
        currency,
        amount,
        currency
    ))
}

private fun controlFlow() {
    var conditionTernary = true
    val ternaryKotlin = if (conditionTernary) "Se cumple la condición" else "No se cumple"

    val amount = 70_000
    if (amount > 120_000) {
        println("Cliente VIP")
    } else if (amount < 10_000) {
        println("Cliente sin interes")
    } else {
        println("Cliente Medio")
    }

    when {
        amount > 120_000 -> println("Cliente VIP")
        amount < 10_000 -> println("Cliente sin interes")
        else -> println("Cliente Medio")
    }


    when (amount) {
        in 20 .. 100 -> println("Cliente VIP")
        in 5..20 -> println("Cliente sin interes")
        else -> println("Cliente Medio")
    }
}