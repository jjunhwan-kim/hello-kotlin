package example.lec10

interface Swimable {

    /**
     * 이 프로퍼티는 Swimable에 필드가 있는 것이 아님
     * 구현 클래스에서 getter를 구현하기 기대하는 것임(getter에 대한 추상 메서드)
     * 또는 getter에 대한 default 메서드를 정의하기도 함
     */
    val swimAbility: Int
        get() = 3

    // default method
    fun act() {
        println(swimAbility)
        println("어푸 어푸")
    }
}