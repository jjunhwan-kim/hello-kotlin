package example.lec09

fun main(args: Array<String>) {
    println("Lec 09")

    // ".필드"를 통해 getter와 setter를 호출
    val person = Person("최태현", 100)
    println(person.name) // getter
    println(person.age) // getter

    person.age = 10 // setter
    println("===")

    // Java 클래스에 대해서도 ".필드"로 getter, setter 사용
    val person2 = JavaPerson("최태현", 100)
    println(person2.name)
    println(person2.age)

    println("===")
    val person3 = Person("최태현")
    println(person3.name)
    println(person3.age)

    println("===")
    val person4 = Person()
}

