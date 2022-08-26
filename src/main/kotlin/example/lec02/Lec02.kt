package example.lec02

fun main(args: Array<String>) {
    println("Lec 02")

    /**
     * 2. Safe Call과 Elvis 연산자
     * Safe Call "?." - null이 아닐경우에 실행되고, null일 경우 실행하지 않고 null로 평가
     * Elvis 연산자 "?:" - 앞의 연산 결과가 null이면 뒤의 값을 사용
     */

    var str: String? = "ABC"
    println(str?.length) // "?."은 str이 null이 아닐 경우에만 실행되고, null일 경우 실행하지 않고 null로 평가됨

    str = null
    println(str?.length ?: 0) // "?:"는 str?.length가 null이 아닐 경우 해당 값을 사용하고, null일 경우 뒤의 값을 사용

    //println(example.lec02.startsWith(null))
}

/**
 * 4. 플랫폼 타입
 */
fun startsWithA(str: String): Boolean {
    return str.startsWith("A")
}

/**
 * 1. Kotlin에서의 null 체크
 * Kotlin에서는 null이 가능한 타입은 다르게 취급
 * 즉, null이 가능한 타입은 "타입?" 의 타입으로 선언
 */
fun startWithA1(str: String?): Boolean {

    return str?.startsWith("A")
        ?: throw IllegalArgumentException("null이 들어왔습니다")

    /*
    if (str == null) {
        throw IllegalArgumentException("null이 들어왔습니다")
    }

    return str.example.lec02.startsWith("A")

    */
}

fun startWithA2(str: String?): Boolean? {

    return str?.startsWith("A")

    /*
    if (str == null) {
        return null
    }

    return str.example.lec02.startsWith("A")
    */
}

fun startWithA3(str: String?): Boolean {

    return str?.startsWith("A") ?: false

    /*
    if (str == null) {
        return false
    }

    return str.example.lec02.startsWith("A")
    */
}

fun calculate(number: Long?): Long {

    // number가 null일 경우 바로 0 리턴
    return number ?: 0

    // 다음 로직...
}

fun startsWith(str: String?): Boolean {

    /**
     * 3. null 아님 단언
     * "!!" 으로 사용
     * 절대 null이 아닐 경우에만 사용
     * 실제로 null이 들어올 경우 NPE 발생
     */

    return str!!.startsWith(str) // str은 절대 null이 될 수 없는 경우 사용
}