/**
 * 1. 클래스와 프로퍼티
 *  constructor 지시어 생략 가능
 *  Kotlin에서는 필드 만들면 자동으로 getter, setter를 만들어 줌
 *  생성자에서 프로퍼티를 만들 수 있음
 *   - 프로퍼티 선언(필드 + getter + setter)과 생성자를 동시에 할 수 있음
 */

class KotlinPerson1 constructor(name: String, age: Int) {
    val name: String = name
    var age: Int = age
}

class KotlinPerson2(name: String, age: Int) {
    val name = name
    var age = age
}


/**
 * 2. 생성자와 init
 * init은 클래스가 초기화되는 시점에 한 번 호출되는 블록
 * 클래스가 생성되는 시점에 검증로직을 실행하고 싶다면 init 블록에 작성
 * 위에있는 생성자는 주 생성자(primary constructor)라고 부르고 반드시 존재해야 함
 *   단, 주 생성자의 파라미터가 없다면 생략 가능
 */
class KotlinPerson3(
    name: String,
    var age: Int
) {
    init {
        if (age <= 0) {
            throw IllegalArgumentException("나이는 ${age}일 수 없습니다")
        }
        println("초기화 블록")
    }

    /**
     * field를 사용하는 이유
     * val name: String = name
     *   get() = name.uppercase()
     * 1. 클래스 밖에서 name을 호출하면 getter가 호출됨
     * 2. get()이 불리게되고, name을 호출하는데 name은 다시 getter를 호출함
     * 3. 무한루프에 빠짐
     * 무한루프를 막기 위해 자기 자신을 가리키는 field 예약어를 사용
     * => backing field
     */

    // custom setter를 사요하기 보다는 업데이트 메서드를 따로 만드는 것을 권장
    var name = name
      set(value) {
          field = value.uppercase() // backing field
      }

    // backing field를 사용하여 custom getter를 만들 일이 거의 없음
    //val name = name
        //get() = field.uppercase()

    // 함수로 처리
    fun getUppercaseName(): String = this.name.uppercase()

    // custom getter
    //val uppercaseName: String
        //get() = this.name.uppercase()



    /**
     * constructor 키워드를 사용하여 추가적인 생성자를 정의
     * 부 생성자(secondary constructor)는 있을수도 있고 없을수도 있음
     * 부 생성자는 최종적으로 주 생성자를 this로 호출해야 함
     * 호출 순서는 init -> 주 생성자 -> 첫 번째 부 생성자 -> 두 번째 부 생성자
     * 하지만 Kotlin에서는 부 생성자보다 default parameter를 권장
     * Converting과 같은 경우 부생성자보다 정적 팩토리 메소드를 추천
     */
    constructor(name: String): this(name, 1) {
        println("첫 번째 부생성자")
    }

    constructor(): this("홍길동") {
        println("두 번째 부생성자")
    }

    /**
     * 3. 커스텀 getter, setter
     * 그렇다면 함수 vs Custom getter,setter 중 어떤걸 사용?
     * 함수 인 것 처럼 접근하는지, 프로퍼티처럼 접근하는지가 관건
     * => 객체의 속성이라면 custom getter
     * => 그렇지 않다면 함수를 권장
     */

    // 일반 함수 추가
/*
    fun isAdult(): Boolean {
        return this.age >= 20
    }
*/

    // custom getter
    val isAdult: Boolean
        //get() = this.age >= 20 // Expression
        get() {
            return this.age >= 20
        }




}