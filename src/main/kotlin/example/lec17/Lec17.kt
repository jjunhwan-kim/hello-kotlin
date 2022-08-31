package example.lec17

import java.io.BufferedReader
import java.io.FileReader

fun main(args: Array<String>) {
    println("Lec 17")

    val fruits = listOf(
        Fruit("사과", 1_000),
        Fruit("사과", 1_200),
        Fruit("사과", 1_200),
        Fruit("사과", 1_500),
        Fruit("바나나", 3_000),
        Fruit("바나나", 3_200),
        Fruit("바나나", 2_500),
        Fruit("수박", 10_000)
    )

    /**
     * 2. Kotlin에서 람다
     *   - Kotlin에서는 Java와 다르게 함수가 그 자체로 값이 될 수 있음
     *   - 함수를 변수에 할당하거나 파라미터로 넘길 수 있음
     *   - Java에서는 함수를 넘겨주는 것 처럼 보여지지만 근본적으로 함수를 넘길 수 없음(2급 시민). Functional Interface
     *   - Kotlin에서는 함수 자체를 1급 시민으로 간주하여 변수에 넣을 수도 있고 파라미터에 넣을 수도 있음
     *   - 마지막 파라미터가 함수인 경우, 소괄호 밖에 람다 사용 가능
     *   - 람다를 작성할 때, 람다의 파라미터를 it으로 직접 참조할 수 있음
     *   - 람다를 여러 줄 작성할 수 있고, 마지막 줄의 결과가 람다의 반환 값이 됨. return을 사용하지 않아도 됨
     */

    // 람다를 만드는 방법 1
    // 함수의 타입은 "(파라미터 타입) -> 반환 타입" 으로 나타냄
    val isApple: (Fruit) -> Boolean = fun(fruit: Fruit): Boolean {
        return fruit.name == "사과"
    }

    // 람다를 만드는 방법 2
    // 함수의 타입은 "(파라미터 타입) -> 반환 타입" 으로 나타냄
    val isApple2: (Fruit) -> Boolean = { fruit: Fruit -> fruit.name == "사과" }

    // 람다를 직접 호출하는 방법 1
    println(isApple(fruits[0]))

    // 람다를 직접 호출하는 방법 2
    println(isApple.invoke(fruits[0]))

    val apples1 = filterFruits(fruits, isApple)

    println("===")
    for (apple in apples1) {
        println(apple)
    }

    val apples2 = filterFruits(fruits, isApple2)

    println("===")
    for (apple in apples2) {
        println(apple)
    }

    val bananas = filterFruits(fruits, fun(fruit: Fruit): Boolean {
        return fruit.name == "바나나"
    })

    println("===")
    for (banana in bananas) {
        println(banana)
    }

    val bananas2 = filterFruits(fruits, { fruit: Fruit -> fruit.name == "바나나" })
    println("===")
    for (banana in bananas2) {
        println(banana)
    }

    /**
     * 함수에서 받는 함수 파라미터가 마지막에 위치해 있으면 람다 중괄호를 소괄호 밖으로 뺄 수 있음
     */

    val bananas3 = filterFruits(fruits) { fruit -> fruit.name == "바나나" }
    println("===")
    for (banana in bananas3) {
        println(banana)
    }
    /**
     * 익명 함수를 만들 때 파라미터가 한 개인 경우 파라미터를 it으로 사용할 수 있음
     */
    val bananas4 = filterFruits(fruits) { it.name == "바나나" }
    println("===")
    for (banana in bananas4) {
        println(banana)
    }

    /**
     * 3. Closure
     *   - Java에서는 람다를 쓸 때, 람다 밖의 변수를 사용하는 경우 final 혹은 실질적으로 final인 변수만 사용할 수 있음
     *   - 하지만 Kotlin에서는 이러한 제약 조건이 없음
     *   - Kotlind에서는 람다가 시작하는 지점에 참조하고 있는 변수들을 모두 포획하여 그 정보를 가지고 있음
     *   - 람다가 사용되는 그 시점에 람다가 쓰고 있는 다른 변수들을 모두 가지고 있어야먄 1급 시민으로 쓸 수 있기 때문임
     *   - 이러한 데이터 구조를 Closure라고 함
     *     - 즉, 람다가 실행되는 시점에 쓰고 있는 변수들을 모두 포획한 데이터 구조를 Closure라고 부름
     */

    var targetFruitName = "바나나"
    targetFruitName = "수박"
    val filteredFruits = filterFruits(fruits) { it.name == targetFruitName }

    println("===")
    for (filteredFruit in filteredFruits) {
        println(filteredFruits)
    }



}

private fun filterFruits(
    fruits: List<Fruit>,
    filter: (Fruit) -> Boolean
): List<Fruit> {

    val filteredFruits = mutableListOf<Fruit>()

    for (fruit in fruits) {
        /*
        if (filter(fruit)) {
            filteredFruits.add(fruit)
        }
        */
        if (filter.invoke(fruit)) {
            filteredFruits.add(fruit)
        }
    }

    return filteredFruits
}

/**
 * 4. try with resources
 *   - use 함수는 Closeable 구현체에 대한 확장 함수
 *     - 확장함수는 "타입.함수이름" 으로써 함수를 확장함
 *   - use 함수는 파라미터로 람다를 받음
 */

fun readFile(path: String) {
    BufferedReader(FileReader(path)).use { reader ->
        println(reader.readLine())
    }
}