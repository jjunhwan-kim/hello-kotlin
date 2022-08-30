package example.lec16

fun main(args: Array<String>) {
    println("Lec 16")

    var str = "ABC"
    println(str.lastChar())

    val person = Person("A", "B", 100)
    println(person.nextYearAge())

    println("===")

    /**
     * 확장함수가 오버라이드 된다면 해당 인스턴스의 실제 타입에 관계없이 현재 타입에 의해 어떤 확장함수가 호출될지 결정됨
     */
    val train: Train = Train()
    train.isExpensive() // Train의 확장함수 호출됨

    val srt: Train = Srt()
    srt.isExpensive()   // Train의 확장함수 호출됨

    val srt2: Srt = Srt()
    srt2.isExpensive()  // Srt의 확장함수 호출됨

    println("===")

    println(3.add(4))
    println(3.add2(4))
    println(3 add2 4)

}

/**
 * 1. 확장함수
 *   - Java로 만들어진 라이브러리를 유지보수, 확장할 때 Kotlin 코드를 덧붙일 때
 *     어떤 클래스안에 있는 메서드처럼 호출할 수 있지만, 함수는 클래스 밖에 만들 수 있게 하자라는 개념으로 나옴
 *   - 즉, 함수 코드 자체는 클래스 밖에 있는데 클래스 안에 있는 멤버함수처럼 호출하여 쓸 수 있음
 *   ex)
 *   fun 확장하려는클래스.함수이름(파라미터): 리턴타입 {
 *     // this를 이용해 실제 클래스 안의 값에 접근
 *     // 이 때 this를 수신객체라고 부름
 *   }
 *
 *   - 확장함수는 클래스에 있는 private 또는 protected 멤버를 가져올 수 없음
 *   - 확장함수와 멤버함수의 시그니쳐가 동일하면 멤버함수가 우선적으로 호출됨
 *   - 확장함수를 만들었지만, 다른 기능의 똑같은 멤버함수가 나중에 생긴다면? 오류가 발생할 수 있음!
 *   - 확장함수가 오버라이드 된다면?
 *     - 해당 인스턴스의 실제 타입에 관계없이 현재 타입에 의해 어떤 확장함수가 호출될지 결정됨
 *     - 해당 변수의 현재 타입, 정적인 타입에 의해 어떤 확장함수가 호출될지 결정됨
 *
 *   - Java에서 Kotlin의 확장함수를 사용하려면?
 *     - Java에서 Kotlin의 확장함수를 정적 메서드를 호출하는 것 처럼 사용가능함
 *
 *   - 확장함수는 확장프로퍼티와도 연결됨
 *     - 확장프로퍼티는 확장함수 + custom getter와 동일함
 *
 */


/**
 * String Class 확장함수
 * 함수 안에서는 this를 통해 인스턴스에 접근 가
 * 원래 String에 있는 멤버함수처럼 사용할 수 있음
 */
fun String.lastChar(): Char {
    return this[this.length - 1]
}

/**
 * String Class 확장프로퍼티
 * 확장함수 + custom getter와 동일함
 */
val String.lastChar: Char
    get() = this[this.length - 1]

fun Person.nextYearAge(): Int {
    println("확장 함수")
    return this.age + 1
}

/**
 * 2. 중위함수
 *   - 함수를 호출하는 새로운 방법임
 *   - downTo, step도 함수임
 *   - 변수.함수이름(argument) 대신, 변수 함수이름 argument
 *   - 변수, argument가 각각 1개일 경우에 사용
 *   - infix 키워드를 사용
 *   - infix는 멤버함수에도 붙일 수 있음
 */

inline fun Int.add(other: Int): Int {
    return this + other
}

infix fun Int.add2(other: Int): Int {
    return this + other
}

/**
 * 3. inline 함수
 *   - 함수가 호출되는 대신, 함수를 호출한 지점에 함수 본문을 그대로 복사&붙여넣기 하고 싶은 경우에 사용
 *   - 함수를 파라미터로 전달할 때 오버헤드를 줄일 수 있음
 *     - 함수를 중첩해서 부르는 경우 오버헤드
 *   - 하지만 inline 함수는 성능 측정과 함께 신중하게 사용되어야 함!
 */

/**
 * 4. 지역함수
 *   - 함수 안에 함수를 선언할 수 있음
 *   - 함수로 추출하면 좋을 것 같은데, 이 함수를 지금 함수 내에서만 사용하고 싶을 때 사용
 *   - 하지만 depth가 깊어지기도 하고, 코드가 그렇게 깔끔하지는 않음
 */

fun createPerson(firstName: String, lastName: String): Person {
    /*
    if (firstName.isEmpty()) {
        throw IllegalArgumentException("firstName은 비어있을 수 없습니다! 현재 값 : $firstName")
    }

    if (lastName.isEmpty()) {
        throw IllegalArgumentException("lastName은 비어있을 수 없습니다! 현재 값 : $lastName")
    }
    */

    fun validateName(name: String, fieldName: String) {
        if (name.isEmpty()) {
            throw IllegalArgumentException("${fieldName}은 비어있을 수 없습니다! 현재 값: $name")
        }
        validateName(fieldName, "firstName")
        validateName(lastName, "lastName")
    }

    return Person(firstName, lastName, 1)
}