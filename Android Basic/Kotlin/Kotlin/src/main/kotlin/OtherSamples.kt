fun main() {
}

sealed interface DinnerMenu
sealed interface LunchMenu

sealed class Menu {
    data class PIZZA(val name: String, val size: String, val quantity: Int): Menu(), DinnerMenu
    data class BURGER(val quantity: Int, val size: String): Menu(), LunchMenu
    data class CHICKEN(val quantity: Int, val pieces: String): Menu(), LunchMenu
}

fun logMenu(menu: Menu) {
    when (menu) {
        is Menu.PIZZA -> print("pizza")
        is Menu.BURGER -> print("burger")
        is Menu.CHICKEN -> print("chicken")
    }
}

fun logLunchMenu(menu: LunchMenu) {
    when (menu) {
        is Menu.BURGER -> print("burger")
        is Menu.CHICKEN -> print("chicken")
    }
}

fun logDinnerMenu(menu: DinnerMenu) {
    when (menu) {
        is Menu.PIZZA -> print("pizza")
    }
}


sealed class ResultState {
    object LOADING: ResultState()
    data class SUCCESS(val viewData: Array<Any>): ResultState()

    sealed class ERROR: ResultState() {
        class InternalError(val errorMessage: java.lang.InternalError): ERROR()
        class ServerError( val errorMessage: java.rmi.ServerError?): ERROR()
        class UnknownError(val errorMessage: java.lang.UnknownError): ERROR()
    }
}

fun uiResult(resultState: ResultState) = when(resultState) {
    ResultState.LOADING -> println("The Data is loading...Please wait")
    is ResultState.SUCCESS -> println("Data has been loaded successfully ${resultState.viewData}")
    is ResultState.ERROR.InternalError -> println("Internet error occurred")
    is ResultState.ERROR.UnknownError -> println("Query occurred ${resultState.errorMessage}")
    is ResultState.ERROR.ServerError -> println("Server occurred")
}

interface ICardLimit {
    fun getCreditLimit(): Int
}

enum class CardType: ICardLimit {
    SILVER {
        override fun calculateCashbackPercent(fee: Float) = fee * 0.25f
        override fun getCreditLimit(): Int = 50
    },
    GOLD {
        override fun calculateCashbackPercent(fee: Float) = fee * 0.5f
        override fun getCreditLimit(): Int = 5_000
    },
    PLATINUM {
        override fun calculateCashbackPercent(fee: Float) = fee * 0.75f
        override fun getCreditLimit(): Int = 10_000
    };

    abstract fun calculateCashbackPercent(fee: Float): Float

    companion object {
        fun getCardTypeByName(name: String) = valueOf(name.uppercase())
    }
}

fun enumAbstract() {
    CardType.GOLD.calculateCashbackPercent(0.01f)
    CardType.getCardTypeByName("GOLD")
    CardType.SILVER.getCreditLimit()
}




class Outer {
    val a = "Outside Nested class."

    inner class Nested {
        val b = "Inside Nested class."
        fun callMe() = "Function call from inside Nested class of $a."
    }
}




enum class ZodiacSign {
    ARIES, TAURUS, GEMINI, CANCER, LEO, VIRGO, LIBRA, SCORPIO, SAGITTARIUS, CAPRICORN, AQUARIUS, PISCES
}

enum class Saint {
    MU, ALDEBARAN, SAGA, KANON, DEATHMASK, AIORIA, SHAKA, DOHKO, MILO, AIOROS, SHURA, CAMUS, AFRODITA

    infix fun of(zodiacSign: ZodiacSign) = GoldenSaint(this, zodiacSign)
}

data class GoldenSaint(val saint: Saint, val zodiacSign: ZodiacSign)


fun infixData() {
    val enumData = Saint.AFRODITA of ZodiacSign.AQUARIUS
}