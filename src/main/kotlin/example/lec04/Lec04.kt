package example.lec04

fun main(args: Array<String>) {
    println("Lec 04")

    /**
     * 1. 단항 연산자 / 산술 연산자
     * 단항 연산자 ++, --
     * 산술 연산자 +, -, *, /, %
     * 산술대입 연산자 +=, -=, *=, /=, %=
     * 비교 연산자 >, <, <=, >=
     * Kotlin에서 객체를 비교할 때 비교 연산자를 사용하면 compareTo를 자동으로 호출
     */

    val money1 = JavaMoney(2_000L)
    val money2 = JavaMoney(1_000L)

    if (money1 > money2) {
        println("Money1이 Money2보다 금액이 큽니다")
    }

    /**
     * 2. 비교 연산자와 동등성, 동일성
     * Java 에서는 동일성에 == 사용, 동등성에 equals 호출
     * Kotlin 에서는 동일성에 === 사용, 동등성에 == 사용(==를 사용하면 간접적으로 equals 호출)
     */

    val money4 = JavaMoney(1_000L)
    val money5 = money4
    val money6 = JavaMoney(1_000L)

    println(money4 === money5) // 동일성
    println(money4 === money6) // 동일성
    println(money4 == money6) // 동등성

    /**
     * 3. 논리 연산자와 코틀린에 있는 특이한 연산자
     * &&, ||, ! - Java와 완전히 동일, Java와 같이 Lazy 연산 수행
     * in, !in - 컬렉션이나 범위에 포함되어 있다, 포함되어 있지 않다 수행
     * a..b - a부터 b까지의 범위 객체 생성
     * a[i] - a에서 특정 index i로 값을 가져옴
     * a[i] = b - a의 특정 index i에 b를 할당
     */
    if (fun1() || fun2()) { // Lazy 연산 수행, example.lec04.fun1()이 true이므로 example.lec04.fun2()는 실행되지 않음
        println("본문")
    }

    /**
     * 4. 연산자 오버로딩
     * Kotlin에서는 객체마다 연산자를 직접 정의할 수 있음
     */
    val money7 = Money(1_000L)
    val money8 = Money(2_000L)
    print(money7 + money8)
}


fun fun1(): Boolean {
    println("fun 1")
    return true
}

fun fun2(): Boolean {
    println("fun 2")
    return false
}


