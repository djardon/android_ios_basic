import UIKit

// Cadenas de texto String
var str = "Hello, playground"
str = "Hola, playground"

let constante: String = "Hola"

// Valores enteros positivos y negativos NO decimales
var numero: Int = 10
numero = -100

// Valores enteros positivos NO decimales
var numerosPositivos: UInt = 10

// Valores decimales positivos y negativos
var numeroDecimal: Float = 2.01234567891011121314
var numeroDecimalGrande: Double = 2.01234567891011121314

// Valor de verdadero (true) o falso (false)
var boolean: Bool = false

// Operadores
numero * 12
numero / 10
numero + 100
numero - 100
numero % 3

numero > 12
numero < 10
numero >= 12
numero <= 10


// Convertir un Float a un Int
numero * Int(numeroDecimal)

// Convertir un Int a un Float
Float(numero) / numeroDecimal


// Operadores lógicos
var boolean2 = false

// AND && solo devuelve True cuando los dos operadores son True
boolean && boolean2

// OR || solo devuelve True cuando al menos uno de los dos operadores es True
boolean || boolean2

// Igualdad == solo devuelve True cuando los dos operadores son iguales
boolean == boolean2

// Distintos != solo devuelve True cuando los dos operadores son distintos
boolean != boolean2

// Strings operaciones
str = "Mi cuenta bancaria tiene \(numeroDecimal) €"

// %d - int Value
// %f - float value
// %ld - long value
// %@ - string value
str = String(format: "Mi cuenta bancaria tiene %f %@",
             numeroDecimal,
             "€")

str = String(format: "Mi cuenta bancaria tiene %.2f %@",
             numeroDecimal,
             "€")

// Tupla
var doblesValores: (text: String, age: Int) = ("Tengo %d años", 35)
doblesValores.text
doblesValores.age

String(format: doblesValores.0,
       doblesValores.1)


// Enums
enum Developers: Int {
    case android
    case iOS
    case web
    case backend
}

var enumerado: Developers = .iOS
enumerado = .web
enumerado == .iOS
enumerado != .iOS
enumerado.rawValue

// Enum con valores asociados
enum Salary {
    case junior(amount: Float)
    case medium(amount: Double, age: Int)
    case senior(amount: String)
}

var enumeradoSalary = Salary.junior(amount: 18_000)
var enum2 = Salary.junior(amount: 40_000)


// Colecciones de datos

// Array
var arrayList = [13, 14, 14, 23, 42]
arrayList.count
arrayList.first
arrayList.last
arrayList.append(99)
arrayList.append(contentsOf: [55, 66, 77])
arrayList.remove(at: 0)
arrayList[arrayList.count - 1]
arrayList.removeAll()


// Dictionary
var dicctionary: [Float:String] = [2.5 : "Pequeño",
                                   5.0 : "Mediano",
                                   10.0 : "Grande"]
dicctionary[5.0]
dicctionary[5.0] = "Extraño"
dicctionary[5.0]
dicctionary[7.5] = "Casi Grande"
dicctionary.keys
dicctionary.values
dicctionary.isEmpty
dicctionary.updateValue("Turbio", forKey: 5.2)
dicctionary.values

// Set
var setList: Set<Int> = []
setList.insert(0)
setList.insert(1)

var setInserted = setList.insert(1)
setInserted.inserted

setList
setList.count
setList.update(with: 5)
setList.update(with: 5)
setList


// Sentencia Control

if setList.count > 5 {
    print("Tenemos más de 5 elementos")
} else if setList.count == 5 {
    print("Tenemos 5 elementos")
} else {
    print("Tenemos menos de 5 elementos")
}

switch setList.count {
case let x where x > 5: print("Tenemos más de 5 elementos")
case let x where x == 5: print("Tenemos 5 elementos")
default: print("Tenemos menos de 5 elementos")
}


if enumerado == .android {
    print("Estudiando Android")
} else if enumerado == .iOS {
    print("Estudiando iOS")
} else {
    print("Pringado")
}

switch enumerado {
case .android, .iOS: print("Estudiando Mobile")
default: print("Pringado")
}


switch enumeradoSalary {
case .junior(let amount):
    print("\(amount)")
case .medium(_, let age):
    print("\(age)")
case .senior(let amount):
    print("\(amount)")
}


// Operador ternario

// (CONDICIÓN LÓGICA) ? CÓDIGO TRUE : CÓDIGO FALSE
(enumerado == .android) ? print("Estudiando Android") : print("Estudiando otra cosa")
var androidMessage = (enumerado == .android) ? "Estudiando Android" : "Estudiando otra cosa"
print(androidMessage)
