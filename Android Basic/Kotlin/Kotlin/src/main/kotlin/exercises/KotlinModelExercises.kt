package exercises

import models.Student
import models.Subject
import models.Teacher

fun main() {
    exercise1()
    exercise2()
    exercise3()
    exercise4()
    exercise5()
    exercise6()
    exercise7()
    exercise8()
    exercise9()
}

// 1
// Print:
// Student Name
// Student subjects count
// Student subjects name

/* Ejemplo output:
Student name: David
Student total subjects: 3
Student subjects: [iOS, Java, Bases de datos]
 */
private fun exercise1() {
    println()
    println("--------------- Ejercicio 1 ---------------")

    Student.testData().forEach { student ->
        println()
        println("Student name: ${student.name}")

        Subject.testData().mapNotNull {
            if (it.students.contains(student)) it.name else null
        }.apply {
            println("Student subjects count: ${count()}")
            println("Student subjects: $this")
        }
    }
}

// 2
// Print:
// Teacher Name
// Teacher subjects count
// Teacher subjects name

/* Ejemplo output:
Teacher name: David
Teacher total subjects: 3
Teacher subjects: [iOS, Java, Bases de datos]
 */
private fun exercise2() {
    println()
    println("--------------- Ejercicio 2 ---------------")

    Teacher.testData().forEach { teacher ->
        println()
        println("Teacher name: ${teacher.name}")

        Subject.testData().mapNotNull {
            if (it.teachers.contains(teacher)) it.name else null
        }.apply {
            println("Teacher subjects count: ${count()}")
            println("Teacher subjects: $this")
        }
    }
}

// 3
// Print:
// Subject Name
// Subject students count
// Subject students name

/* Ejemplo Output:
Subject name: iOS
Subject total students: 6
Subject students: [David, Sara, María, Juan, Marta, Lucia]
 */
private fun exercise3() {
    println()
    println("--------------- Ejercicio 3 ---------------")

    Subject.testData().forEach { subject ->
        println()
        println("Subject name: ${subject.name}")
        println("Subject total students: ${subject.students.count()}")
        println("Subject students: ${subject.students.map { it.name }}")
    }
}

// 4
// Print:
// Subject Name
// Subject teachers count
// Subject teachers name

/* Ejemplo Output:
Subject name: iOS
Subject total teachers: 6
Subject teachers: [David, Sara, María, Juan, Marta, Lucia]
 */
private fun exercise4() {
    println()
    println("--------------- Ejercicio 4 ---------------")

    Subject.testData().forEach { subject ->
        println()
        println("Subject name: ${subject.name}")
        println("Subject total teachers: ${subject.teachers.count()}")
        println("Subject teachers: ${subject.teachers.map { it.name }}")
    }
}

// 5
// Print:
// Teacher Name
// Teacher students count
// Teacher students name
/* Output ejemplo:
Teacher name: David
Teacher total students: 5
Teacher students: [David, Óliver, Miguel, Luis, Lucia]
 */
private fun exercise5() {
    println()
    println("--------------- Ejercicio 5 ---------------")

    val subjects = Subject.testData()
    Teacher.testData().forEach { teacher ->
        println()
        println("Teacher name. ${teacher.name}")

        subjects.mapNotNull {
            if (it.teachers.contains(teacher)) it.students else null
        }
        .flatMap { it.map { student -> student.name } }
        .toSet()
        .also {
            println("Teacher students count: ${it.count()}")
            println("Teacher students: $it")
        }
    }
}

// 6
// Print:
// Subjects with same number of Students
/* Output ejemplo:
Subjects with same number of Students: [Bases de datos, Java]
 */
private fun exercise6() {
    println()
    println("--------------- Ejercicio 6 ---------------")

    val subjects = Subject.testData()

    subjects.mapNotNull { subject ->
        subjects.filter { (subject.name != it.name) && (it.students.count() == subject.students.count()) }
            .let { if (it.isNotEmpty()) Pair(subject.name, it) else null }
    }.forEach {
        println("Subject ${it.first}, subjects with same number of students: ${it.second.joinToString { it.name }}")
    }
}

// 7
// Print:
// Students in more than two Subject
/* Output ejemplo:
Students in more than two Subject: [David, Óliver, Miguel, Luis, Juan, Lucia]
 */
private fun exercise7() {
    println()
    println("--------------- Ejercicio 7 ---------------")

    val subjects = Subject.testData()
    Student.testData().mapNotNull { student ->
        subjects.filter { it.students.contains(student) }
            .let { if (it.count() > 2) student.name else null }
    }.also {
        println("Students in more than two subject: $it")
    }
}

// 8
// Print:
// Teachers in more than two Subject
/* Output ejemplo:
Teachers in more than two subject: [David, Óliver, Miguel, Luis, Juan, Lucia]
 */
private fun exercise8() {
    println()
    println("--------------- Ejercicio 8 ---------------")

    val subjects = Subject.testData()
    Teacher.testData().mapNotNull { teacher ->
        subjects.filter { it.teachers.contains(teacher) }
            .let { if (it.count() > 2) teacher.name else null }
    }.also {
        println("Teachers in more than two subject: $it")
    }
}

// 9
// Print:
// Students with same Teacher in different Subjects
/* Output ejemplo:
Students with same teacher: [David, Sara, María, Juan, Marta, Lucia, Óliver, Miguel, Luis, Ángel]
 */
private fun exercise9() {
    println()
    println("--------------- Ejercicio 9 ---------------")

    val subjects = Subject.testData()
    Teacher.testData().mapNotNull { teacher ->
        subjects.filter { it.teachers.contains(teacher) }
            .let {
                when {
                    it.count() > 1 ->
                        it.flatMap { it.students.map { it.name } }
                            .groupingBy { it }
                            .eachCount()
                            .filter { it.value > 1 }
                            .keys
                            .let { Pair(teacher.name, it) }

                    else -> null
                }
            }
    }.forEach {
        println("Teacher ${it.first} students different subjects: ${it.second}")
    }
}

