import com.google.gson.Gson
import com.google.gson.annotations.SerializedName

fun main() {
    val course = Gson().fromJson("{'firstname': 'David', 'year': '2023' }", Course::class.java)
    println(course)
}

data class Course(
    @SerializedName("firstname") val name: String,
    val year: String
)