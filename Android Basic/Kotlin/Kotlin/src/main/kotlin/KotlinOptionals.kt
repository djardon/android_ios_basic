fun main() {
    nullAccess()
    unwrapOptional()
    unwrapOptionalForce()
}

private fun nullAccess() {
    val nullable: String? = null
    println(nullable?.length ?: "La variable es null")
}

private fun unwrapOptional() {
    var nullable: String? = "Puede contener un String"

    if (nullable != null) {
        println(nullable.isBlank())
    } else {
        println("La variable es null")
    }

    nullable?.let {
        println(it.isBlank())
    } ?: println("La variable es null")
}

private fun unwrapOptionalForce() {
    var nullable: String? = "Puede contener un String"

    if (!nullable.isNullOrBlank()) {
        println(nullable.length)
    } else {
        println("La variable es null")
    }

    when (nullable.isNullOrBlank()) {
        true -> println("La variable es null")
        false -> println(nullable.length)
    }
}