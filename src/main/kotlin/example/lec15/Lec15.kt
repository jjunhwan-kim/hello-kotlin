package example.lec15

fun main(args: Array<String>) {
    println("Lec 15")


    /**
     * 1. 배열
     *   - 프로덕션에서 잘 쓰지 않음
     *   - 배열보다 리스트 사용을 권장
     *   - array.indicessms 0부터 마지막 index까지의 Range임
     *   - withIndex()를 사용하면 인덱스와 값을 한 번에 가져올 수 있음
     */
    var array = arrayOf(100, 200)
    array = array.plus(300)

    for (i in array.indices) {
        println("$i ${array[i]}")
    }

    for ((index, value) in array.withIndex()) {
        println("$index $value")
    }

    /**
     * 2. Kotlin에서 Collection
     *   - 컬렉션을 만들어줄 때 불변인지, 가변인지 설정해야 함
     *   - 가변(Mutable) 컬렉션: 컬렉션에 element를 추가, 삭제할 수 있음
     *   - 불변 컬렉션: 컬렉션에 element를 추가, 삭제할 수 없음
     *     - 컬렉션을 만들고 Collections.unmodifiableList(), unmodifiableMap() 등을 붙여준 게 불변이라고 생각하면됨
     *     - 불변 컬렉션이어도 컬렉션 안의 Reference Type인 Element의 필드는 바꿀 수 있음
     *   - 우선 불변 리스트를 만들고, 꼭 필요한 경우 가변 리스트로 바꾸는 것을 권장!
     */
    // 불변 리스트
    val numbers = listOf(100, 200)    // 타입추론이 가능하므로 타입을 생략할 수 있음
    val emptyList = emptyList<Int>()  // 타입추론이 불가능하므로 타입을 명시적으로 적어줘야함

    printNumbers(emptyList())         // 타입추론이 가능하므로 타입을 생략할 수 있음

    println("===")

    // List에서 한 Element 가져오기
    println(numbers[0])

    // For Each
    for (number in numbers) {
        println(number)
    }

    // 전통적인 For문
    for ((index, value) in numbers.withIndex()) {
        println("${index} ${value}")
    }

    // 가변 리스트(기본 구현체는 ArrayList)
    val mutableNumbers = mutableListOf(100, 200)
    mutableNumbers.add(300)

    /**
     * 3. Kotlin에서 Set
     *   - 집합은 List와 다르게 순서가 없고 같은 element는 하나만 존재할 수 있음
     */

    println("===")
    val numbersSet = setOf(100, 200)               // 불변 Set
    val mutableNumbersSet = mutableSetOf(100, 200) // 가변 Set, 기본 구현체는 LinkedHashSet

    for (number in numbersSet) {
        println(number)
    }

    for ((index, value) in numbersSet.withIndex()) {
        println("${index} ${value}")
    }

    /**
     * 4. Kotlin에서 Map
     *   - Java처럼 put을 사용할 수 있고, map[key] = value를 쓸수도 있음
     */

    val oldMap = mutableMapOf<Int, String>()          // 타입 추론이 불가능 하므로 타입을 명시적으로 지정
    oldMap[1] = "MONDAY"
    oldMap[2] = "TUESDAY"

    val map = mapOf(1 to "MONDAY", 2 to "TUESDAY")    // mapOf를 사용해 불변 map 생성

    for (key in oldMap.keys) {
        println(key)
        println(oldMap[key])
    }

    for ((key, value) in oldMap.entries) {
        println(key)
        println(value)
    }

    /**
     * 5. 컬렉션의 null 가능성, Java와 함께 사용하기
     *   - List<Int?> : 리스트에 null이 들어갈 수 있지만, 리스트는 절대 null이 아님
     *   - List<Int>? : 리스트에 null이 들어갈 수 없지만, 리스트는 null일 수 있음
     *   - List<Int?>? : 리스트에 null이 들어갈 수도 있고, 리스트가 null일 수도 있음
     *
     *   - Java는 읽기 전용 컬렉션과 변경 가능 컬렉션을 구분하지 않음
     *     1. Kotlin의 불변 리스트(lisfOf)를 Java에서 가져옴
     *     2. Java에서 읽기 전용과 불변을 구분하지 않으므로 ELement를 추가할 수 있음
     *     3. Kotlin에서 다시 List를 받으면 불변인데 Element가 추가된 상황
     *
     *   - Java는 nullable type과 non-nullable 타입을 구분하지 않음
     *     1. Kotlin에 null이 들어갈 수 없는 리스트 선언
     *     2. Java에서 해당 Kotlin 리스트를 가져옴
     *     3. Java에서는 nullable type과 non-nullable 타입을 구분하지 않으므로 리스트에 null을 넣을 수 있음
     *     4. Kotlin에서 다시 List를 받으면 non-nullable 리스트인데 null이 들어있을 수 있음
     *
     *   - Kotlin 쪽의 컬렉션이 Java에서 호출되면 컬렉션 내용이 변할 수 있음을 감안해야 함!
     *     - Kotlin 리스트가 Java 코드에 전달되었다가 돌아올 때 방어로직 등의 처리 필요
     *     - Kotlin 쪽에서 Collections.unmodifiableXXX()를 활용하여 변경 자체를 막는 방법
     *
     *   - Kotlin에서 Java컬렉션을 가져와 사용할 때 플랫폼 타입을 신경써야 함
     *     - Java에서 List<Integer>를 Kotlin으로 전달했을 때 아래 3개중 어떤 타입인지 알 수가 없음
     *       1. List<Int?>
     *       2. List<Int>?
     *       3. List<Int?>?
     *     - 따라서 Java코드를 보고 맥락을 확인하고 Java코드를 가져오는 지점을 Wrapping해야 함
     */
}

private fun printNumbers(number: List<Int>) {

}
