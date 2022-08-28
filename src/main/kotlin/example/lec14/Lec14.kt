package example.lec14

fun main(args: Array<String>) {
    println("Lec 14")

    val dto1 = PersonDto("최태현", 100)
    val dto2 = PersonDto("최태현", 100)

    println(dto1 == dto2) // equals, 동일성 비교
    println(dto1) // toString

    // Data Class와 named argument를 활용하면 builder pattern을 쓰는 효과까지 더해줌
    // builder, equals, hashCode, toString을 모두 사용할 수 있음
    val dto3 = PersonDto(name = "test", age = 10)
}

/**
 * Sealed Class를 when과 같이 사용시 가독성 있는 코드를 작성할 수 있음
 *   - is를 사용하여 타입으로 분기
 *   - else에 대한 코드를 추가적으로 작성하지 않아도 됨
 *   - Sealed Class의 하위 구현체가 추가되거나 제거되었을 때 쉽게 알 수 있음
 *
 *   - 추상화가 필요한 Entity or DTO에 Sealed Class를 활용!
 *   - JDK17 에서도 Sealed Class가 추가되었다고 함
 */
fun handleCar(car: HyundaiCar) {
    when (car) {
        is Avante -> TODO()
        is Grandeur -> TODO()
        is Sonata -> TODO()
    }
}


