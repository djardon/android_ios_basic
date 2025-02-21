package models

fun main() {
    Teacher.executeTestData()
}


typealias Teachers = List<Teacher>

enum class TeacherType {
    INTERN, EXTERN
}

fun TeacherType.salary() = when (this) {
    TeacherType.INTERN -> 1_800
    TeacherType.EXTERN -> 2_000
}

data class Teacher(
    val name: String,
    val surname: String? = null,
    var email: String? = null,
    var type: TeacherType = TeacherType.EXTERN
) {
    companion object {
        private val teachersSampleData = listOf(
            Teacher(
                "David",
                "Jardón",
                "d.jardon@gmail.com",
                TeacherType.EXTERN
            ),
            Teacher(
                "Jaime",
                type = TeacherType.INTERN
            ),
            Teacher(
                "Pedro",
                type = TeacherType.INTERN
            ),
            Teacher(
                "Dani",
                type = TeacherType.INTERN
            ),
            Teacher(
                "Sergio",
                type = TeacherType.EXTERN
            ),
            Teacher(
                "Carlos",
                type = TeacherType.EXTERN
            )
        )

        fun testData() = teachersSampleData

        fun executeTestData() {
            println()
            println("--------------- Teachers Tests ---------------")
            // Print de los teacher con 2.000 € o más de salario
            println(
                teachersSampleData.mapNotNull {
                    if (it.type.salary() >= 2_000) it.name else null
                }
            )
        }
    }
}

