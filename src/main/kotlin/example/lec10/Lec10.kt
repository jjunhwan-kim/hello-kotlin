package example.lec10

/**
 * 4. 상속 관련 키워드 4가지 정리
 *   1. final: override를 할 수 없게 함. 기본으로 보이지 않게 존재함
 *   2. open: override를 할 수 있게 열어줌
 *   3. abstract: 반드시 override 해야 함
 *   4. override: 상위 타입을 오버라이드 함
 */

/**
 * 정리
 * 1. 상속 또는 구현을 할 때 : 를 사용
 * 2. 상위 클래스 상속을 구현할 때 반드시 생성자를 호출해야 함
 * 3. override를 필수로 붙여야 함
 * 4. 추상 멤버가 아니면 기본적으로 오버라이드가 불가능
 *   - open을 사용
 * 5. 상위 클래스의 생성자 또는 초기화 블록에서 open 프로퍼티를 사용하면 버그가 발생할 수 있음
 */

fun main(args: Array<String>) {
    println("Lec 10")

    val penguin = Penguin("test")

    Derived(300)

}

/**
 * 3. 클래스를 상속받을 때 주의할 점
 * 상위 클래스에서, 하위 클래스가 override 하고 있는 프로퍼티를 상위 클래스 생성자 블락이나 init 블락에서 사용하면 이상 한 값이 나올 수 있음
 * 단, final 프로퍼티는 상관 없음
 */
open class Base( // 상속을 받을 수 있게 하기 위해서 open 키워드를 붙여줌
    open val number: Int = 100
) {
    init {
        println("Base Class")
        println(number)
    }
}

class Derived(
    override val number: Int
) : Base(number) {

    init {
        println("Derived Class")
        println(number)
    }
}

