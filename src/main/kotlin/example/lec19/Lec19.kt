package example.lec19
import example.lec19.a.printHelloWorld as printHelloWorldA
import example.lec19.b.printHelloWorld as printHelloWorldB

fun main(args: Array<String>) {
    println("Lec 19")


    /**
     * 2. as import
     *   - 어떤 클래스나 함수를 임포트 할 때 이름을 바꾸는 기능
     *   - 다른 패키지의 같은 이름의 함수를 동시에 가져오고 싶을 때 사용할 수 있음
     */

    printHelloWorldA()
    printHelloWorldB()

    /**
     * 3. 구조 분해
     *   - 복합적인 값을 분해하여 여러 변수를 한 번에 초기화하는 것
     *   - Data Class는 conponentN이라는 함수도 자동으로 만들어 줌
     *   - Data Class는 기본적으로 자기가 가지고 있는 필드에 대해서 componentN이라는 함수를 만들어 줌
     *     - N은 1부터 증가하는 숫자
     *     - component1은 첫 번째 프로퍼티를 가져오는 함수
     *     - component2는 두 번째 프로퍼티를 가져오는 함수
     *   - 구조분해 문법을 쓴다는 것은 componentN 함수를 호출한다는 뜻
     *   - Data Class가 아닌데 구조분해를 사용하고 싶다면, componentN 함수를 직접 구현해 줄 수 있음
     *     - 단, operator 키워드를 함수앞에 붙여줘야 함
     *     - operator fun component1()
     *
     */

    val person = Person("최태현", 100)
    /*
    val name = person.component1()
    val age = person.component2()
    */
    // 구조분해 문법은 위 두 문장을 실행해 주는 것, 즉 componentN함수를 호출함
    val (name, age) = person

    /**
     * age와 name순서를 바꾸면 age에 이름이 대입되고 name에 나이가 대입 됨
     * 즉 age, name을 인식해서 가져오는 것이 아니라 단순히 첫 번째 프로퍼티를 첫 번째 변수에 대입하고,
     * 두 번째 프로퍼티를 두 번째 변수에 대입함!
     */
    //val (age, name) = person
    println("===")
    println("이름: ${name}, 나이: ${age}")

    /**
     *
     */

    val person2 = Person2("test", 123)
    val (name2, age2) = person2

    println("===")
    println("이름: ${name2}, 나이: ${age2}")


    val map = mapOf(1 to "A", 2 to "B")
    // (key, value)도 구조분해 문법
    for ((key, value) in map.entries) {

    }

    /**
     * 4. Jump와 Label
     *   - 코드의 흐름을 제어할 때 return, break, continue
     *     - return
     *       - 기본적으로 가장 가까운 enclosing function 또는 익명함수로 값이 반환
     *     - break
     *       - 가장 가까운 루프가 제거
     *     - continue
     *       - 가장 가까운 루프를 다음 step으로 보냄
     *   - for문 및 while문에서 break, continue의 기능은 동일함
     *   - forEach에서 continue 또는 break를 쓸 수 없음!!
     *     - 쓸 수 있는 기법이 있음
     *       - run {} 으로 감싸고 return@run, return@forEach
     *     - 하지만 break, continue를 사용할 때에는 가급적 for문 사용 권장!!
     *
     *   - Kotlin에 Label이라는 기능이존재
     *     - 특정 expression에 라벨이름@를 붙여 하나의 라벨로 간주하고 break, continue, return등을 사용하는 기능
     *     - Kotlin에는 Label을 달 수 있는 기능과 return, continue, break에 대해서 특정 라벨에 대해 동작할 수 있게끔 함
     *     - Label을 사용한 Jump는 사용하지 않는 것을 강력 추천!!
     *
     */


    println("===")
    val numbers = listOf(1, 2, 3)

    for (number in numbers) {
        println(number)
    }

    println("===")
    numbers.map { number -> number + 1 }
        .forEach { number ->
            if (number == 1) {
                // continue // error 발생!
            } else {
                println(number)
            }
        }

    println("===")

    run {
        numbers.forEach { number ->
            if (number == 2) {
                return@run // break의 기능
            }
            println(number)
        }
    }

    println("===")

    numbers.forEach { number ->
        if (number == 2) {
            return@forEach // continue의 기능
        }
        println(number)
    }

    println("===")

    loop@ for (i in 1..100) {
        for (j in 1..100) {
            if (j == 2) {
                break@loop // 바깥 for문을 중지시킴
            }
            print("${i} ${j}")
        }
    }
    println("")

    /**
     * 5. TakeIf와 TakeUnless
     *   - Kotlin에서는 method chaining을 위한 특이한 함수를 제공
     *   - takeIf는 주어진 조건을 만족하면 그 값이 반환됨, 그렇지 않으면 null이 반환됨
     *   - takeUnless는 주어진 조건을 만족하지 않으면 그 값이 반환됨, 만족하면 null이 반환됨
     */
    println("===")
    val number0 = Number(0)
    println(number0.getNumberOrNull())
    val number1 = Number(1)
    println(number1.getNumberOrNull2())
    val number2 = Number(0)
    println(number2.getNumberOrNull3())

}

/**
 * 1. Type Alias
 *  - 긴 이름의 클래스 혹은 함수 타입이 있을 때 축약하거나 더 좋은 이름을 쓰고싶을 때 사용
 */
typealias FruitFilter = (Fruit) -> Boolean

/**
 * 복잡한 함수 타입을 typealias로 축약하여 사용할 수 있음
 */
//fun filterFruits(fruits: List<Fruit>, filter: (Fruit) -> Boolean) {
fun filterFruits(fruits: List<Fruit>, filter: FruitFilter) {

}


/**
 * 이름이 긴 클래스를 컬렉션에 사용할 때도 간단히 줄일 수 있음
 */
data class UtralSuperGuardianTribe(
    val name: String
)

typealias USGTMap = Map<String, UtralSuperGuardianTribe>
