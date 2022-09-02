package example.lec20

fun main(args: Array<String>) {
    println("Lec 20")

    val person = Person("kim", 30)
    printPerson(person)



    /**
     * 2. scope function의 분류
     *   - let
     *     - 확장함수
     *     - 람다의 결과를 반환
     *     - 람다 안에서 it 사용
     *   - run
     *     - 확장함수
     *     - 람다의 결과를 반환
     *     - 람다 안에서 this 사용
     *   - also
     *     - 확장함수
     *     - 객체 그 자체를 반환
     *     - 람다 안에서 it 사용
     *   - apply
     *     - 확장함수
     *     - 객체 그 자체를 반환
     *     - 람다 안에서 this 사용
     *   - with
     *     - 확장함수 아님
     *     - run, apply와 동일하게 this를 사용해 접근, this 생략 가능
     *     - with(파라미터, 람다)로 사용
     *   - this: 생략이 가능한 대신, 다른 이름을 붙일 수 없음
     *   - it: 생략이 불가능한 대신, 다른 이름을 붙일 수 있음
     */

    /**
     * value1, value2는 람다의 결과가 반환되므로 age가 들어감
     * value3, value4는 객체 그 자체가 반환되므로 person이 들어감
     */
    println("===")
    val value1 = person.let {
        //it.age    // 람다에서 가장 마지막 줄의 expression이 반환됨
        p -> p.age  // it 대신 다른 이름 사용 가능
    }

    val value2 = person.run {
        //this.age
        age // this 대신 다른 이름은 사용 불가능하지만, this 생략 가능
    }

    val value3 = person.also {
        it.age
    }

    val value4 = person.apply {
        this.age
    }

    /**
     * - let은 일반 함수를 파라미터로 받음, 따라서 파라미터에 대한 이름을 직접 설정 가능
     * - run은 확장 함수를 파라미터로 받음, 즉 타입 T에 대한 확장 함수를 받음
     *   - 확장 함수에서는 본인 자신을 this로 호출하고, 생략가능함
     */
    /*
    // let은 일반 함수를 받음
    public inline fun <T, R> T.let(block: (T) -> R): R {
        contract {
            callsInPlace(block, InvocationKind.EXACTLY_ONCE)
        }
        return block(this)
    }

    public inline fun <T, R> T.run(block: T.() -> R): R {
        contract {
            callsInPlace(block, InvocationKind.EXACTLY_ONCE)
        }
        return block()
    }

    public inline fun <T> T.also(block: (T) -> Unit): T {
        contract {
            callsInPlace(block, InvocationKind.EXACTLY_ONCE)
        }
        block(this)
        return this
    }

    public inline fun <T> T.apply(block: T.() -> Unit): T {
        contract {
            callsInPlace(block, InvocationKind.EXACTLY_ONCE)
        }
        block()
        return this
    }
    */

    /*
    public inline fun <T, R> with(receiver: T, block: T.() -> R): R {
        contract {
            callsInPlace(block, InvocationKind.EXACTLY_ONCE)
        }
        return receiver.block()
    }
    */
    val person2 = Person("최태현", 100)
    with(person2) {
        println(name)
        println(this.name)
    }

    /**
     * 3. 언제 어떤 scope function을 사용해야 할까?
     *   - let
     *     - 하나 이상의 함수를 call chain 결과로 호출할 떄 사용
     *     - non-null 값에 대해서만 code block을 실행시킬 때 사용
     *     - 일회성으로 제한된 영역에 지역 변수를 만들 때 사용
     *   - run
     *     - 객체 초기화와 반환 값에 계산을 동시에 해야 할 때 사용
     *   - apply
     *     - 객체 그 자체가 반환
     *     - 객체 설정을 할 때에 객체를 수정하는 로직이 call chain 중간에 필요할 때 사용
     *   - also
     *     - 객체 그 자체가 반환
     *     - 객체를 수정하는 로직이 call chain 중간에 필요할 때 사용
     *   - with
     *     - 특정 객체를 다른 객체로 변환해야 하는데, 모듈 간의 의존성에 의해 정적 팩토리 혹은 toClass 함수를 만들기 어려울 때 사용
     */

    println("===")
    val strings = listOf("APPLE", "CAR", "CAKE")
    strings.map { it.length }
        .filter { it > 3 }
        .let(::println)
        //.let { lengths -> println(lengths) }

    println("===")
    val str: String? = "test"
    val length = str?.let {
        println(it.uppercase())
        it.length
    }
    println(length)

    /**
     * - 일회성으로 특정 변수를 만들 때 변수를 만드는 과정에서 추가적인 변수를 넣고 싶지 않을 때 let을 사용
     * - 하지만 실제로 private function 같은 것으로 처리하는 것을 권장
     */
    println("===")
    val numbers = listOf("one", "two", "three", "four")
    val modifiedFirstItem = numbers.first()
        .let { firstItem ->
            if (firstItem.length >= 5) firstItem else "!$firstItem!"
        }.uppercase()
    println(modifiedFirstItem)

    /**
     * - 객체를 만들어 DB에 저장하고, 그 인스턴스를 활용할 때
     * - run을 통해서 저장된 person이 밖으로 반환
     * - 하지만 추천하지는 않음!
     * - 반복되는 생성 후처리는 생성자, 프로퍼티, init block으로 넣는 것을 권장!
     * - 생성자가 너무 길어지는 경우에는, 빌더 패턴을 쓰거나 run을 쓰면 깔끔해지기는 함
     */
    println("===")
    val personRepository = PersonRepository()
    val person3 = Person("최태현", 100).run(personRepository::save)
    val person4 = Person("최태현", 100).let(personRepository::save)
    val person5 = Person("최태현", 100).run {
        hobby = "독서"
        personRepository.save(this)
    }

    // 아래의 코드를 권장
    val person6 = personRepository.save(Person("최태현", 100))


    /**
     * call chain 중간에 값을 수정하는 경우에 apply 사용
     */
    println("===")
    val person7 = Person("최태현", 100)
    person7.apply { this.growOld() }
        .let { println(it) }


    /**
     * also를 method call chain 중간에 사용
     */
    println("===")
    mutableListOf("one", "two", "three")
        .also { println("The list elements before adding new one: $it") }
        .add("four")

    val numbers2 = mutableListOf("one", "two", "three")
    println(numbers2)
    numbers2.add("four")

    /**
     * 4. scope function과 가독성
     *  - 1번 코드는 숙련자가 아니라도 알아보기 쉬움
     *  - 2번 코드는 숙련된 코틀린 개발자만 알아보기 쉬움
     *  - 2번 코드에서 view::showPerson이 null을 반환한다면, 추가적으로 elvis연산자가 실행되어 결과적으로,
     *    showPerson도 실행되고 showError도 실행되는 버그 발생여지가 있음
     */

    println("===")
    val person8: Person? = Person("최태현", 100)
    val view = View()

    // 1번 코드
    if (person8 != null && person.isAdult) {
        view.showPerson(person8)
    } else {
        view.showError()
    }

    // 2번 코드
    person8?.takeIf { it.isAdult }
        ?.let(view::showPerson)
        ?: view.showError()
}

class View {
    fun showPerson(person: Person) {
        println(person)
    }

    fun showError() {
        println("error")
    }
}

class PersonRepository {
    fun save(person: Person): Person {
        println("save!")
        return person
    }
}

fun createPerson(name: String, age: Int, hobby: String): Person {
    /**
     * Test Fixture를 만들 때 사용할 수 있음
     * Person이 최초 생성되는 시점에는 name과 age만 받고(생성자에서 name, age만 받음)
     * 생성 이후 hobby를 추가적으로 설정해줄 때 사용
     */
    return Person(
        name = name,
        age = age
    ).apply {
        this.hobby = hobby
    }
}

fun toPersonDto(person: Person) {
    /**
     * with를 사용하지 않으면 person.name, person.age로 명시해야 함
     * with를 사용하면 this를 생략하여 name, age를 바로 대입할 수 있음
     */
    return with(person) {
        PersonDto(
            name = name,
            age = age
        )
    }
}

/**
 *
 * 1. scope function
 *   - scope: 영역
 *   - function: 함수
 *   - scope function: 일시적인 영역을 형성하는 함수
 *   - 람다를 사용해 일시적인 영역을 만들고 코드를 더 간결하게 만들거나,
 *     method chaining에 활용하는 함수를 scope function 이라고 함
 */

data class Person(
    val name: String,
    var age: Int,
    var hobby: String = ""
) {
    fun growOld() {
        age++
    }

    val isAdult: Boolean
        get() = age >= 20
}

fun printPerson(person: Person?) {
    // Safe Call
    person?.let { // let은 scope function, 확장 함수
        p ->
        println(p.name)
        println(p.age)

        //println(it.name)
        //println(it.age)
    }
    /*
    if (person != null) {
        println(person.name)
        println(person.age)
    }
    */
}
