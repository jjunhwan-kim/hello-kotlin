import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import kotlin.NumberFormatException

fun main(args: Array<String>) {
    println("Lec 07")
    readFile()
}

/**
 * 1. try catch finally 구문
 */
fun parseIntOrThrow(str: String): Int {
    try {
        return str.toInt() // 기본 타입간의 형변환은 toType() 사용
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException("주어진 ${str}는 숫자가 아닙니다")
    }
}

fun parseIntOrThrowV2(str: String): Int? {
    /**
     * Kotlin에서는 try catch 구문도 Exspression임
     */
    return try {
        str.toInt()
    } catch (e: NumberFormatException) {
        null
    }
}

/**
 * 2. Checked Exception과 Unchecked Exception
 * Kotlin에서는 Checked Exception과 Unchecked Exception을 구분하지 않음
 * 모두 Unchecked Exception임
 */
fun readFile() {
    val currentFile = File(".")
    val file = File(currentFile.absolutePath + "/a.txt")
    val reader = BufferedReader(FileReader(file))
    println(reader.readLine())
    reader.close()
}

/**
 * 3. try with resources
 * Kotlin에서는 try with resources가 사라지고 use라는 inline 확장함수를 사용
 */

fun readFile(path: String) {
    BufferedReader(FileReader(path)).use { reader ->
        println(reader.readLine())
    }
}