package example.lec08

fun main(args: Array<String>) {
    println("Lec 08")

    repeat("Hello World", 1, true)
    repeat("Hello World!")

    /**
     * 3. named argument(parameter)
     * 매개변수 이름을 통해 직접 지정
     * 지정되지 않은 매개변수는 기본값 사용
     * builder를 직접 만들지 않고 builder의 장점을 가지게 됨
     * Java 함수를 가져다 사용할 때는 named argument를 사용할 수 없음
     */
    repeat("Hello World!!", useNewLine = false)

    printNameAndGender(name = "최태현", gender = "MALE")

    printAll("A", "B", "C")

    val array = arrayOf("A", "B", "C")
    printAll(*array) // spread 연산자
}

/**
 * 1. 함수 선언 문법
 * - 접근 지시어 public은 생략 가능
 * - fun은 함수를 의미하는 키워드
 * - 반환 타입에서 Java void처럼 Kotlin의 Unit은 생략가능
 */
fun max(a: Int, b: Int) = if (a > b) a else b
/**
 * if~else가 Expression이므로 return 구문 전체가 하나의 Expression이 될 수 있음
 * 따라서 함수의 중괄호를 없애고 = 으로 바로 Expression을 리턴하도록 바꿀 수 있음
 * 중괄호 대신 =을 썼을 때 반환타입 추론이 가능하므로 함수의 반환타입 생략가능
 */


/**
 * 2. default parameter
 * Java의 메서드 오버로딩대신 default parameter를 사용할 수 있음
 * Kotlin에도 Java와 동일하게 오버로드 기능은 있음
 */

fun repeat(str: String, num: Int = 3, useNewLine: Boolean = true) {
    for (i in 1..num) {
        if (useNewLine) {
            println(str)
        } else {
            print(str)
        }
    }
}

fun printNameAndGender(name: String, gender: String) {
    println(name)
    println(gender)
}

/**
 * 4. 같은 타입의 여러 파라미터 받기(가변인자)
 * ...을 타입 뒤에 쓰는 대신 제일 앞에 vararg를 붙여주어야 함
 * 배열을 바로 넣는대신 spread 연산자(*)를 붙여줘야 함
 */

fun printAll(vararg strings: String) {
    for (str in strings) {
        println(str)
    }
}