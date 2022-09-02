package example.lec20

/**
 * 1. Data Class
 *
 *   - DTO(Data Transfer Object)
 *     - 계층간의 데이터를 전달하기 위한 객체
 *       - 보통 아래의 요소들로 구성
 *       - 데이터(필드)
 *       - 생성자와 getter
 *       - equals, hashCode
 *       - toString
 *   - Java에서는 IDE의 도움을 받거나 lombok을 사용하여 생성자, getter, equals, hashCode, toString 등을 빠르게 구현
 *   - Kotlin에서는 Data Class를 이용하면 자동으로 equals, hashCode, toString을 만들어줌
 *   - JDK 16에서 Kotlin의 Data Class와 같은 Record Class 도입됨
 */
data class PersonDto(
    val name: String,
    val age: Int
)
