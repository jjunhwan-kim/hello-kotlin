package lec10

class Penguin(
    species: String
) : Animal(species, 2), Swimable, Flyable {

    private val wingCount: Int = 2

    override fun move() {
        println("펭귄이 움직입니다~ 꿱꿱")
    }

    /**
     * 추상클래스에서 자등으로 만들어진 getter를 새로 정의하기 위해
     * override 키워드와 custom getter를 사용하여 만듬
     */
    override val legCount: Int
        get() = super.legCount + this.wingCount

    override fun act() {
        // 중복되는 인터페이스를 특정할 때는 super<타입>.함수 사용
        super<Swimable>.act()
        super<Flyable>.act()
    }

    /**
     * custom getter
     */
    override val swimAbility: Int
        get() = 3
}