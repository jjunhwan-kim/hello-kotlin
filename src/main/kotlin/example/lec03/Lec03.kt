package example.lec03

fun main(args: Array<String>) {
    println("Lec 03")

    /**
     * 1. 기본 타입
     * 타입을 변환하기위해 명시적으로 to변환타입() 메서드를 호출해야함
     */
    val number1 = 3 // Int
    val number2 = 3L // Long
    val number3 = 3.0f // Float
    val number4 = 3.0 // Double


    val number5 = 4 // Int
    //val number6: Long = number5 // Type mismatch 암시적 타입 변경 불가능
    val number6: Long = number5.toLong()

    val number7 = 4
    val number8 = 5
    val result = number7 / number8.toDouble()

    println(result)

    val number9: Int? = 3
    val number10: Long = number9?.toLong() ?: 0L // 변수가 nullable이라면 Safe Call과 Elvis연산자를 이용해 적절한 처리 필요


    printAgeIfPerson1(Person("", 100))
    printAgeIfPerson2(null)
    printAgeIfPerson2(Person("", 100))
    printAgeIfPerson2(10)
    print(Person("최태현", 100))
}

/**
 * 2. 타입 캐스팅
 * is - instanceof
 * !is - instanceof 의 반대
 * as - (Type)
 */

fun printAgeIfPerson1(obj: Any) {
    if (obj is Person) {
        val person = obj as Person
        //println(person.age)
        println(obj.age) // 가능
    }

    if (obj !is Person) { // if (!(obj instanceof example.lec03.Person))

    }
}

fun printAgeIfPerson2(obj: Any?) {
    // as?를 사용하면 obj가 null일 경우 person은 null이 됨
    // as?를 사용하면 obj가 example.lec03.Person 타입이 아닐경우 null이 됨
    val person = obj as? Person
    println(person?.age) // person이 null이 될 수 있으므로 Safe Call 사용
}

/**
 * 3. Kotlin의 특이한 타입 3가지
 * Any - Java의 Object 역할(모든 객체의 최상위 타입)
 * 모든 Primitive 타입의 최상위 타입도 Any
 * Any는 null을 포함할 수 없으므로 null을 포함하고 싶다면 Any?로 표현
 * Any에 equals, hashCode, toString 존재
 *
 * Unit - Java의 void와 동일한 역할
 * void와 다르게 Unit은 그 자체로 타입 인자로 사용 가능
 *
 * Nothing - 함수가 정상적으로 끝나지 않았다는 사실을 표현하는 역할
 * 무조건 예외를 반환하는 함수, 무한 루프 함수 등
 */

/**
 * 4. String interpolation, String indexing
 *
 * Java
 * String.format("%s %d", person.getName(), person.getAge());
 * StringBuilder sb = new StringBuilder();
 * sb.append(person.getName());
 * sb.append(" ");
 * sb.append(person.getAge());
 *
 * Kotlin
 * "${변수}" 를 사용
 * 중괄호를 생략할 수 있으나 권장하지 않음
 * 여러 줄은 """ """를 사용
 */

fun print(person: Person) {

    System.out.println(String.format("사람의 이름은 %s 이고 나이는 %d 세 입니다", person.name, person.age));

    val log = "사람의 이름은 ${person.name} 이고 나이는 ${person.age} 세 입니다"

    val name = person.name
    val age = person.age
    val log2 = "사람의 이름은 $name 이고 나이는 $age 세 입니다"

    println(log)
    println(log2)


    // 여러 줄
    val str = """
        ABC
        DEF
        ${name}
    """.trimIndent() // trimIndent()는 indentation 삭제
    println(str)

    // index
    val str2 = "ABC"
    println(str[0])
    println(str[2])
}