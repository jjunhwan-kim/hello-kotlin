import java.util.*

fun main(args: Array<String>) {
    println("Lec 05")

    //validateScoreIsNotNegative(-10)
    println(getPassOrFail(40))
    println(getGrade(80))
}

/**
 * 1. if문
 * Java와 동일
 */
fun validateScoreIsNotNegative(score: Int) {
    if (score < 0) {
        throw IllegalArgumentException("${score}는 0보다 작을 수 없습니다.")
    }
}

/**
 * 2. Expression & Statement
 * Java에서 if-else는 Statement이지만 Kotlin에서는 Expression
 * Statement: 프로그램의 문장, 하나의 값으로 도출되지 않음
 * Expression: 하나의 값으로 도출되는 문장
 * Statement가 Expression을 포함하는 관계
 *
 * Kotlin에서는 if~else 코드가 하나의 값으로 도출되는 Expression이므로 return 다음에 if~else를 사용할 수 있음
 * Java에서는 3항 연산자가 Expression
 */
fun getPassOrFail(score: Int): String {
    return if (score >= 50) {
        "P"
    } else {
        "F"
    }
}

fun getGrade(score: Int): String {
    return if (score >= 90) {
        "A"
    } else if (score >= 80) {
        "B"
    } else if (score >= 70) {
        "C"
    } else {
        "D"
    }
}

/**
 * 범위 연산자
 */
fun validateScore(score: Int) {
    if (score !in 0..100) {
        // score < 0 || score > 100
        throw IllegalArgumentException("score의 범위는 0부터 100입니다")
    }

    if (score in 0..100) {
        // score >= 0 && score <= 100
    }
}

/**
 * switch, when
 * Kotlin에서 switch~case문 삭제, when추가 됨
 * when은 if문과 동일하게 Expression임
 * when은 switch보다 훨씬 더 유연함
 */
fun getGradeWithSwitch(score: Int): String {
    // switch대신 when
    /*
    return when (score / 10) {
        9 -> "A"
        8 -> "B"
        7 -> "C"
        else -> "D"
    }
    */
    return when (score) {
        in 90..99 -> "A" // case
        in 80..89 -> "B" // case
        in 70..79 -> "C" // case
        else -> "D" // default
    }
}

fun startsWithA(obj: Any): Boolean {

    //return (obj as? String)?.startsWith("A") ?: false

    return when (obj) {
        is String -> obj.startsWith("A")
        else -> false
    }
}

fun judgeNumber(number: Int) {
    return when (number) {
        1, 0, -1 -> println("어디서 많이 본 숫자입니다")
        else -> println("1, 0, - 1이 아닙니다")
    }
}

fun judgeNumber2(number: Int) {
    return when {
        number == 0 -> println("주어진 숫자는 0입니다")
        number % 2 == 0 -> println("주어진 숫자는 짝수입니다")
        else -> println("주어진 숫자는 짝수입니다")
    }
}
