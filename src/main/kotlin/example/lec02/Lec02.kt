package example.lec02

fun main(args: Array<String>) {
    println("Lec 02")

    /**
     * 2. Safe Call과 Elvis 연산자
     * Safe Call "?." - null이 아닐경우에 실행되고, null일 경우 실행하지 않고 null로 평가
     * Elvis 연산자 "?:" - 앞의 연산 결과가 null이면 뒤의 값을 사용
     */
    println("===")
    var str: String? = "ABC"
    println(str?.length) // "?."은 str이 null이 아닐 경우에만 실행되고, null일 경우 실행하지 않고 null로 평가됨

    str = null
    println(str?.length ?: 0) // "?:"는 str?.length가 null이 아닐 경우 해당 값을 사용하고, null일 경우 뒤의 값을 사용

    println("===")
    calculate(null)
    calculate(123)

    // null아님 단언에 null전달시 NPE발생
    println("===")
    //println(startsWith(null))

    println("===")
    //val person = Person("공부하는 개발자") // Java Class
    val person = Person(null) // Java Class
    /**
     * Java Class의 @Nullable 어노테이션을 Kotlin이 분석하여 startsWithA 메서드를 호출할 수 없도록 컴파일 에러 발생
     */
    startsWithA(person.name)
}

/**
 * 4. 플랫폼 타입
 * Java 코드에 @NotNull, @Nullable 등의 어노테이션이 없을 때 Kotlin이 null 관련 정보를 알 수 없으므로 플랫폼 타입이라고 함
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
    /*
    if (str == null) {
        throw IllegalArgumentException("null이 들어왔습니다")
    }

    return startsWith("A")
    */

    // ? => Safe Call, null이 아니면 실행하고, null이면 null반환
    // ?: => Elvis 앞의 값이 null이면 뒤의 값 사용
    return str?.startsWith("A")
        ?: throw IllegalArgumentException("null이 들어왔습니다")
}

fun startWithA2(str: String?): Boolean? {
    /*
    if (str == null) {
        return null
    }

    return str.startsWith("A")
    */

    return str?.startsWith("A")
}

fun startWithA3(str: String?): Boolean {
    /*
    if (str == null) {
        return false
    }

    return str.startsWith("A")
    */

    return str?.startsWith("A") ?: false
}

fun calculate(number: Long?): Long {

    // Elvis 연산자를 early return에 사용
    // number가 null일 경우 바로 0 리턴
    number ?: return 0

    // 정상 로직
    println(number)
    return number
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