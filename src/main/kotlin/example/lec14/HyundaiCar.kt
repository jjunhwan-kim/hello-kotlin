package example.lec14

/**
 * 3. Sealed Class, Sealed Interface
 *  - 라이브러리 내부에서 상속가능하고, 라이브러리 외부에서 상속받지 못하도록 봉인
 *  - 컴파일 타임 때 하위 클래스의 타입을 모두 기억하여, 런타임 때 클래스 타입이 추가될 수 없음
 *  - 하위 클래스는 Sealed Class와 같은 패키지에 있어야 함
 *  - Enum과 다른 점
 *    - 클래스를 상속받을 수 있음
 *    - 하위 클래스는 멀티 인스턴스가 가능
 */
sealed class HyundaiCar(
    val name: String,
    val price: Long
)

class Avante : HyundaiCar("아반떼", 1_000L)

class Sonata : HyundaiCar("소나타", 2_000L)

class Grandeur : HyundaiCar("그렌저", 3_000L)
