package example.lec12

fun main(args: Array<String>) {
    println("Lec 12")

    // Singleton
    println("===")
    println(Singleton.a)
    Singleton.a += 10
    println(Singleton.a)

    // 익명 클래스
    println("===")
    moveSomething(object : Movable {
        override fun move() {
            println("무브 무브")
        }

        override fun fly() {
            println("날다 날다")
        }
    })
}

/**
 * 1. static 함수와 변수
 *   - static 대신 companion object 사용
 *   - static 이라는 키워드 자체가 없어짐
 *   - companion object 블록 안에 넣어둔 변수와 함수가 Java의 static 변수, 함수 인 것 처럼 사용됨
 *
 *   - static: 클래스가 인스턴스화 될 때 새로운 값이 복제되는게 아니라 정적으로 인스턴스끼리의 값을 공유
 *   - companion object: 클래스와 동행하는 유일한 오브젝트
 *   - const 키워드: 해당 키워드를 붙이지 않으면 런타임시에 값이 할당, 해당 키워드를 붙이면 컴파일시에 할당
 *                 진짜 상수에 붙이기 위한 용도, 기본 타입과 String에 붙일 수 있음
 *
 *   - companion object도 하나의 객체로 간주되어 이름을 붙일 수도 있고, interface를 구현할 수도 있음
 *   - companion object에 유틸성 함수들을 넣어도 되지만 최상단 파일을 활요하는 것을 권장
 *
 *   - Java에서 Kotlin의 static field나 함수를 사용 할 경우
 *     - 이름이 없는 경우
 *       - Companion 명시
 *         - Person.Companion.newBaby("ABC")
 *       - 함수에 @JvmStatic 어노테이션을 붙였을 경우
 *         - Person.newBaby("ABC)
 *     - 이름이 있는 경우
 *       - 이름 명시
 *         - Person.Factory.newBaby("ABC");
 *       - 함수에 @JvmStatic 어노테이션을 붙였을 경우
 *         - Person.newBaby("ABC)
 */

class Person private constructor(
    var name: String,
    var age: Int
) {

    companion object Factory : Log {
        private const val MIN_AGE = 1

        @JvmStatic
        fun newBaby(name: String): Person {
            return Person(name, MIN_AGE)
        }

        override fun log() {
            println("나는 Person 클래스의 동행객체 Factory에요")
        }
    }
}

/**
 * 2. 싱글톤
 *   - Java
 *     - private 생성자, Early Initialization 또는 Lazy Initialization
 *     - 동시성 처리(Double-Checked Locking Singleton)
 *     - enum class 활용
 *   - Kotlin
 *     - object 키워드를 붙여주면 끝
 */

object Singleton {
    var a: Int = 0
}

/**
 * 3. 익명 클래스
 *   - 특정 인터페이스나 클래스를 상속받은 구현체를 일회성으로 사용할 때 쓰는 클래스
 *   - Java에서는 new 키워드와 중괄호를 사용하여 익명 클래스 사용
 *   - Kotlin에서는 "object : 타입" 그리고 중괄호로 익명 클래스 사용
 */

private fun moveSomething(movable: Movable) {
    movable.move()
    movable.fly()
}
