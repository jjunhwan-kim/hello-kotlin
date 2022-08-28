package example.lec13

/**
 * 1. 중첩 클래스의 종류
 *   - 중첩 클래스(Nested Class)는 Inner Class와 Static Nested Class로 나뉨
 *
 *   - Java
 *     - static을 사용하는 중첩 클래스
 *       - 클래스 안에 static을 붙인 클래스는 밖의 클래스 직접 참조 불가
 *
 *     - static을 사용하지 않는 중첩 클래스
 *       - 내부 클래스(Inner Class)
 *         - 밖의 클래스를 직접 참조 가능한 클래스
 *       - 지역 클래스(Local Class)
 *         - 메서드 내부에 클래스 정의
 *       - 익명 클래스(Anonymous Class)
 *
 *   - Kotlin
 *     - Java에서 중첩 클래스를 사용할 때 외부 참조를 가진 Inner Class 대신 외부 참조를 가지지 않는 Static Nested Class를 권장함
 *     - Kotlin에서는 이를 따라 Static Nested Class를 작성하는 것을 권장
 *     - 권장되는 내부 클래스(Java의 Static Nested Class)
 *       - static 키워드가 없으므로 class 내부에 class를 정의하면 됨
 *     - 권장되지 않는 내부 클래스(Java의 Inner Class)
 *       - 내부 클래스에 inner 키워드를 명시적으로 선언
 */

fun main(args: Array<String>) {
    println("Lec 13")

}

class House(
    private val address: String,
    private val livingRoom: LivingRoom
) {
    //class LivingRoom(       // 권장되는 내부 클래스(Java의 Static Nested Class)
    inner class LivingRoom(   // 권장되지 않는 내부 클래스(Java의 Inner Class)
        private val area: Double
    ) {
        val address: String
            get() = this@House.address // 외부 클래스 참조를 위해 "this@외부클래스"를 사용
    }
}
