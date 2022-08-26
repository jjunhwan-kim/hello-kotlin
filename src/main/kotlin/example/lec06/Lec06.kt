package example.lec06

fun main(args: Array<String>) {
    println("Lec 06")

    /**
     * 1. for-each
     */
    val numbers = listOf(1L, 2L, 3L)
    for (number in numbers) {
        println(number)
    }
    println("===")

    /**
     * 2. 전통적인 for문
     */
    for (i in 1..3) {
        println(i)
    }
    println("===")
    for (i in 3 downTo 1) {
        println(i)
    }
    println("===")
    for (i in 1..5 step 2) {
        println(i)
    }
    println("===")


    /**
     * 3. Progression과 Range
     * ..연산자 - 범위를 만들어 내는 연산자
     * 1..3 - 1부터 3의 범위
     *
     * downTo, step은 함수! (중위함수)
     */

    for (i in 1..3) {
        // 1..3 은 범위를 만들어냄
        // 범위는 IntRange 클래스가 존재
        // IntRange는 IntProgression을 상속받음
        // Progression은 등차수열을 나타내는 클래스
        // 등차수열은 시작값, 끝값, 공차로 이루어짐
    }

    /**
     * 3 downTo 1 - 시작값 3, 끝값 1, 공차가 -1인 등차수열
     * 1..5 step 2 - 시작값 1, 끝값 5 공차가 2인 등차수열
     * stop, downTo는 함수
     * 중위 호출 함수로 사용
     * "변수.함수이름(argument)" 대신, "변수 함수이름 argument" 으로 호출하는 방법
     */
    for (i in 1..5 step 2) {
        println(i)
    }

    /**
     * 1..5 step 2
     *  1) 1..5 -> 1부터 5까지 공차가 1인 등차수열 생성
     *  2) 등차수열에 대해 step 함수 호출, 즉 등차수열.step(2)
     *  3) 1부터 5까지 공차가 2인 등차수열 생성, 즉 1, 3, 5
     */

    /**
     * 4. while문
     */
    println("===")

    var i = 1
    while (i <= 3) {
        println(i)
        i++
    }
}

