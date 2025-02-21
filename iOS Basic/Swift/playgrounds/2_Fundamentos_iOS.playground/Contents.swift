import UIKit

// Bucles
print("--------------- FOR ---------------")

// For
let friends = ["David", "Carlos", "Sara", "Ángel", "Óliver", "Lucía"]

for friend in friends {
    print(friend)
}

for count in 1...10 {
    print(count)
}

for _ in 1...10 {
    print("Hola")
}

for count in 0..<friends.count {
    print(count)
}

for (index, data) in friends.enumerated() where index > 3 && data.count > 5 {
    print(index)
    print(data)
}

for index in stride(from: 0, to: 10, by: 2) {
    print(index)
}


// While
print("--------------- WHILE ---------------")
var whileCount = 0
while whileCount < 10 {
    print(whileCount)
    whileCount += 1
}

var whileIndex = 0
while whileIndex < friends.count {
    print(friends[whileIndex])
    whileIndex += 1
}

// Repeat
print("--------------- REPEAT ---------------")
var repeatIndex = 0
repeat {
    print(friends[repeatIndex])
    repeatIndex += 1
} while repeatIndex < friends.count


// Break
print("--------------- BREAK ---------------")
for item in friends {
    print(item)
    break
}

// Continue
print("--------------- CONTINUE ---------------")
for (index, item) in friends.enumerated() {
    print(index)
    continue
    print(item)
}

// Opcionales
print("--------------- OPCIONALES ---------------")
var opcional: String? = ""
// Forzar unwrapped NUNCA HACER ESTO
opcional!.count
opcional = nil
// Unwrapped seguro del valor de la variable
opcional?.count

var tupla: (String, String?) = ("", nil)
var listadoOpcional: [Int?] = [nil, 5, 8, nil, 10, nil, 7]

// Valor por defecto para opcional
let resultNoOpcional: Int = opcional?.count ?? 0
if(resultNoOpcional > 5) {
    
}

var opcionalInt: Int? = nil
if let count = opcional?.count, opcionalInt != nil && count > 5 {
    print(count)
} else if let index = opcionalInt {
    print(index)
} else {
    print("No tienen valor")
}

func opcionalesFuncion() {
    var opcionalInt: Int? = 0
    guard let index = opcionalInt,
          index > 5 else {
        print("No tiene valor")
        return
    }
    
    print(index)
}

// Typealias
print("--------------- TYPEALIAS ---------------")
typealias Age = Int

typealias Students = [Student]
var students: Students

// Classes
print("--------------- CLASES ---------------")

// Clase para estudiante
class Student {
    // Propiedades de la clase Student
    var name: String = ""
    var lastname: String = ""
    private var age: Age?
    
    convenience init(name: String = "", lastname: String = "", age: Int = 0) {
        self.init()
        
        self.name = name
        self.lastname = lastname
    }
}

// Crear instancia de Student
var student = Student(name: "Carlos", age: 10)
student
var student2 = Student(name: "Sara", lastname: "Olmo")
student2 = student
student2.name = "Sara"

print(student.fullName)
print(student2.name)


// Structs
print("--------------- STRUCTS ---------------")
struct Teacher {
    var name: String
    var lastname: String
    var age: Int
}

var teacher = Teacher(name: "David",
                      lastname: "Jardón",
                      age: 35)

var teacher2 = teacher
teacher2.age = 25


// Funciones
print("--------------- FUNCIONES ---------------")
func multiplica(_ num: Int, por multi: Int = 2) -> Int {
    return num * multi
}

multiplica(10, por: 4)
multiplica(20)


func printString(text: String) {
    print(text)
}

// Variables computadas
print("--------------- VAR COMPUTADAS ---------------")
class Subject {
    var name: String = ""
    var students: Students = []
    var teachers: [Teacher] = []
    
    var numStudents: Int {
        return students.count
    }
    
    var numTeachers: Int {
        return teachers.count
    }
}

var subject = Subject()
subject.numStudents
subject.numTeachers

enum Salary {
    case junior(amount: Float)
    case profesional(amount: Float)
    case senior(amount: Float)
    
    var amount: Float {
        var levelAmount: Float = 0.0
        
        switch self {
        case .junior(amount: let amount):
            levelAmount = amount
        case .profesional(amount: let amount):
            levelAmount = amount
        case .senior(amount: let amount):
            levelAmount = amount
        }
        
        return levelAmount
    }
}

var salary = Salary.senior(amount: 60_000)
salary.amount



// Extensiones
print("--------------- EXTENSIONS ---------------")

extension Student {
    var fullName: String {
        return "\(name) \(lastname)"
    }
}

extension Int {
    var double: Int {
        return self * self
    }
}

2.double
