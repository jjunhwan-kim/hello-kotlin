package lec10

/**
 * 1. 추상 클래스
 *
 * 상속시 extends 대신 ":" 사용
 * 한 클래스가 상속을 받을 때 상위 클래스의 생성자를 바로 호출
 * 메서드 오버라이드시 override 키워드를 붙여줘야 함
 */

class Cat(
    species: String
) : Animal(species, 4) {

    override fun move() {
        println("고양이가 사뿐 사뿐 걸어가~~")
    }
}