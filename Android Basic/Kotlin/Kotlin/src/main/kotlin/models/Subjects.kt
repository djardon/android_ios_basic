package models

fun main() {
    Subject.executeTestData()
}

typealias Subjects = List<Subject>

data class Subject(
    val name: String,
    var year: String,
    var teachers: Teachers,
    var students: Students
) {
    companion object {
        private val subjectsSampleData = listOf(
            Subject(
                "iOS",
                "2012",
                listOf(Teacher.testData().random()),
                Student.testData().asSequence().shuffled().take((0..Student.testData().count()).random()).toList()
            ),
            Subject(
                "Android",
                "2022",
                listOf(Teacher.testData().random()),
                Student.testData().asSequence().shuffled().take((0..Student.testData().count()).random()).toList()
            ),
            Subject(
                "Kotlin",
                "2023",
                listOf(Teacher.testData().random()),
                Student.testData().asSequence().shuffled().take((0..Student.testData().count()).random()).toList()
            ),
            Subject(
                "Swift",
                "2019",
                listOf(Teacher.testData().random()),
                Student.testData().asSequence().shuffled().take((0..Student.testData().count()).random()).toList()
            ),
            Subject(
                "Java",
                "1990",
                listOf(Teacher.testData().random()),
                Student.testData().asSequence().shuffled().take((0..Student.testData().count()).random()).toList()
            )
        )

        fun testData() = subjectsSampleData

        fun executeTestData() {
            println()
            println("--------------- Subjects Tests ---------------")
            // Print las subject con más de 2 alumnos
            println(
                subjectsSampleData.mapNotNull {
                    when {
                        it.students.count() > 2 -> "Subject ${it.name}; students ${it.students.count()}"
                        else -> null
                    }
                }
            )
        }
    }
}