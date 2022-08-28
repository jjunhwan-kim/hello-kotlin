package example.lec14

/**
 * 2. Enum Class
 *   - 추가적인 클래스를 상송받을 수 없고, 인터페이스는 구현할 수 있음
 *   - 각 Enum 객체는 싱글톤임
 */
enum class Country(
    private val code: String
) {

    KOREA("KO"),
    AMERICA("US"),
    TEST("TE")
    ;
}

/**
 * when은 Enum Class 혹은 Sealed CLass와 함께 사용할 경우 더욱더 진가를 발휘
 * Enum에 대한 분기 처리를 할 때 when을 사용하여 가독성 있는 코드 작성 가능
 * 컴파일러가 Country의 모든 타입을 알고있기 때문에 else를 작성할 필요가 없음
 * Enum에 타입이 추가되거나 제거되면 IDE에서 알림을 줌
 */
fun handleCountry(country: Country) {
    when (country) {
        Country.KOREA -> TODO()
        Country.AMERICA -> TODO()
    }
}
