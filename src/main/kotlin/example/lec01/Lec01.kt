package example.lec01

fun main(args: Array<String>) {
    println("Lec 01")

    /**
     * 1. 변수 선언 키워드 - var과 val의 차이점
     * JAVA에서 long과 final long의 차이
     * var 가변
     * val 불변
     * 모든 변수는 우선 val로 만들고 꼭 필요한 경우 var로 변경을 권장
     * 초기 값 지정 없이 사용시 컴파일 에러 발생
     * val 변수는 불변이지만, val 컬렉션에는 element 추가 가능
     */

    var number1 = 10L
    number1 = 20L

    // val
    val number2 = 10L
    //number2 = 20L  // val은 불변

    var number3: Long
    //var number3  // 타입 추론 불가능
    //println(number3)  // 미 할당된 변수

    val number4: Long
    number4 = 10  // val 최초 1번 할당 가능
    println(number4)

    val a: Int
    var b: Int
    //println(a)
    //println(b)
    val list = mutableListOf(1, 2, 3)
    list.add(4)
    println(list)


    /**
     * 2. Kotlin에서의 Primitive Type
     * 숫자, 문자, 불리언과 같은 몇몇 타입은 코드에서는 Reference Type으로 표현되지만
     * 내부적으로 Kotlin이 적절하게 처리함
     * JAVA 코드로 디컴파일을 해보면 연산시에는 Primitive Type으로 적절하게 변환되서 사용됨
     */

    println("===")
    var number5 = 10L
    number5 *= 20L
    var number6 = 1_000L

    /**
     * 3. Kotlin에서의 nullable 변수
     * Kotlin에서 null이 변수에 들어갈 수 있다면 "타입?"를 사용해야 함
     */
    println("===")

    var number7 = 1_000L
    //number7 = null  // 기본적으로 null 할당 불가능

    var number8: Long? = 1_000L
    number8 = null

    /**
     * 4. Kotlin에서의 객체 인스턴스화
     * Kotlin에서 객체 인스턴스화를 할 때에는 new를 붙이지 않아야 함
     */

    //var person = Person("최태현")
}