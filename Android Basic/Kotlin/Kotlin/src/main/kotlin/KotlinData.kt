fun main() {
    enumData(BankType.CAIXABANK)
    sealedClassData(BankOperationType.WireTransfer(BankType.ING, "", 150.0))
    sealedClassData(BankOperationType.WireTransfer(BankType.BBVA, "", 100.0))
    pairData()
    interfaces()
}

enum class BankType {
    ING, BBVA, SANTANDER, CAIXABANK
}

private fun enumData(bank: BankType) {
    val result = when (bank) {
        BankType.ING -> "Banco: $bank"
        BankType.BBVA -> "Banco: $bank"
        BankType.SANTANDER -> "Banco: $bank"
        else -> "Banco: $bank"
    }

    println(result)

    when {
        bank == BankType.ING -> println("Mi banco es $bank y cada día el de más gente")
        bank != BankType.BBVA -> println("Mi banco es $bank")
    }
}

sealed class BankOperationType {
    class WireTransfer(val bank: BankType, val account: String, val amount: Double = 0.0) : BankOperationType()
    class CashWithdrawal(val amount: Double) : BankOperationType()
}

private fun sealedClassData(bankOperationType: BankOperationType) {
    val result = when (bankOperationType) {
        is BankOperationType.CashWithdrawal -> "Retirada de efectivo por valor ${bankOperationType.amount}"
        is BankOperationType.WireTransfer -> "Transferencia al banco ${bankOperationType.bank} desde la cuenta ${bankOperationType.account} por importe de ${bankOperationType.amount}"
    }

    println(result)
}

typealias BankTypeAmount = Pair<BankType, Double>
typealias ApiCallback = (BankOperationType) -> Unit

fun fetchUserData(callback: ApiCallback) {
    callback(BankOperationType.CashWithdrawal(50.0))
}

fun initData() {
    fetchUserData {
        sealedClassData(it)
    }
}

private fun pairData() {
    val pairValues: BankTypeAmount = Pair(BankType.ING, 120.5)
    println(pairValues.first)
    println(pairValues.second)

    val tripleValues = Triple("", 12, BankOperationType.CashWithdrawal(120.0))
    println(tripleValues.first)
    println(tripleValues.second)
    println(tripleValues.third)
}

open class Padre(val name: String) {
    open fun printName() {
        print(name)
    }
}

interface NameInterface {
    fun printNameInterface() { println("NameInterface") }
    fun printFullName(name: String, lastname: String) { println("$name $lastname") }
}

interface LastnameInterface {
    fun printNameInterface() { println("LastnameInterface") }
}

class Hija(
    fullname: String,
    private val lastname: String
): Padre(fullname), NameInterface, LastnameInterface {

    override fun printName() {
        super.printName()
        printNameInterface()
        printFullName(name, lastname)
    }

    override fun printNameInterface() {
        super<LastnameInterface>.printNameInterface()
        println(lastname)
    }
}


interface InterfazA {
    fun funInterfazA() { println("Dentro de la función de la interfaz A" )}
}

interface InterfazB {
    fun funInterfazB() { println("Dentro de la función de la interfaz B" )}
}

class ClaseInterfaces(a: InterfazA, b: InterfazB): InterfazA by a, InterfazB by b {
    fun funcion() {
        funInterfazA()
        funInterfazB()
        println("Se ha llamado a la función de la interfaz" )
    }
}


class ClaseInterfazA: InterfazA {
    override fun funInterfazA() {
        super.funInterfazA()
        println("ClaseInterfazA")
    }
}

class ClaseInterfazB: InterfazB {

}

fun interfaces() {
    val interfaz = ClaseInterfaces(ClaseInterfazA(), ClaseInterfazB())

    interfaz.funInterfazA()
}