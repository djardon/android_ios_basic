package models

fun main() {
    Student.executeTestData()
}

typealias Students = List<Student>

data class Student(
    val name: String,
    var lastname: String? = null,
    var age: Int? = null,
    var phone: String? = null,
    var address: String? = null
) {
    companion object {
        private val studentsSampleData: Students = listOf(
            Student("David", age = 38),
            Student("Óliver", age = 4),
            Student("Sara", age = 39),
            Student("Paula", age = 1),
            Student("Ángel", age = 10),
            Student("Miguel", age = 40),
            Student("María", age = 65),
            Student("Eduardo", age = 50),
            Student("Luis", age = 45),
            Student("Marta", age = 90),
            Student("Lucía", age = 18),
            Student("Juan", age = 20)
        )

        fun testData() = studentsSampleData

        fun executeTestData() {
            println()
            println("--------------- Students Tests ---------------")
            println(studentsSampleData.joinToString { it.name })

            val studentsNameAge = studentsSampleData.mapNotNull {
                when {
                    (it.age ?: 0) >= 18 -> "Nombre: ${it.name}, Edad: ${it.age}"
                    else -> null
                }
            }
            println(studentsNameAge)

            println("Número estudiantes mayores de 18: ${studentsSampleData.count { (it.age ?: 0) >= 18 }}")

            // studentsSampleData.filter { it.name.contains("a", true) }.map { it.name }
            val studentsNameWithA = studentsSampleData.mapNotNull {
                when (it.name.contains("a", true) || it.name.contains("á", true)) {
                    true -> it.name
                    false -> null
                }
            }
            println(studentsNameWithA)
        }
    }
}