package lec10

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
 * 상위 클래스에서, 하위 클래스가 override 하고 있는 프로퍼티를
 * 상위 클래스 생성자 블락이나 init 블락에서 사용하면 이상 한 값이 나올 수 있음
 */
open class Base(
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
    }
}

