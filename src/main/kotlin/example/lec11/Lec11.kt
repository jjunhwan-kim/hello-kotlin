package example.lec11


/**
 * 1. Java와 Kotlin의 가시성 제어
 * Java
 *   public - 모든 곳에서 접근 가능
 *   protected - 같은 패키지 또는 하위 클래스에서만 접근 가능
 *   default - 같은 패키지에서만 접근 가능
 *   private - 선언된 클래스 내에서만 접근 가능
 *
 * Kotlin
 *   public - 모든 곳에서 접근 가능
 *   protected - 선언된 클래스 또는 하위 클래스에서만 접근 가능
 *   internal - 같은 모듈에서만 접근 가능
 *   private - 선언된 클래스 내에서만 접근 가능
 *
 * Java 대비 Kotlin에서 바뀐점
 * Kotlin에서는 패키지라는 개념을 접근 제어에 사용하지 않기 때문에(클래스의 namespace를 관리하기 위한 용도) protected에서는 패키지가 빠짐
 * default는 사라고 모듈을 접근 제어하는 기능이 생김
 *
 * Java의 기본 접근 지시어는 default
 * Kotlin의 기본 접근 지시어는 public
 */

/**
 * 2. Kotlin 파일의 접근 제어
 * Kotlin은 .kt파일에 변수, 함수, 클래스 여러개를 바로 만들 수 있음
 * Kotlin 파일의 접근 제어 지시어
 *   public - 기본 값으로 어디서든 접근할 수 있음
 *   protected - 파일(파일의 최상단)에는 사용 불가능, 왜냐하면 선언된 클래스 또는 하위 클래스에서만 접근 가능한데 파일은 클래스가 아님
 *   internal - 같은 모듈에서만 접근 가능
 *   private - 같은 파일 내에서만 접근 가능
 */

val a = 3
// protected val b = 3
private val NUM = 3

fun add(a: Int, b: Int): Int {
    println(NUM)
    return a + b
}

/**
 * 3. 다양한 구성요소의 접근 제어
 * Kotlin 클래스 멤버(함수 등)의 접근 지시어
 *   public - 모든 곳에서 접근 가능
 *   protected - 선언된 클래스 또는 하위 클래스에서만 접근 가능
 *   internal - 같은 모듈에서만 접근 가능
 *   private - 선언된 클래스 내에서만 접근 가능
 *
 * Kotlin 클래스의 생성자의 접근 지시어
 *   가시성 범위는 동일
 *   단, 생성자에 접근 지시어를 붙이려면, constructor를 직접 써줘야 함
 *
 *   Java에서 유틸성 코드를 만들 때 abstract class + private constructor를 사용하여 인스턴스화도 막고 상속도 막는 사용법이 있음
 *   Kotlin에서는 파일 최상단에 바로 유틸 함수를 작성하면 됨
 *
 * Kotlin 프로퍼티의 접근제어
 *   val, var 앞에 접근 지시어를 사용하여 getter, setter에 한 번에 접근 지시어를 정하는 방법
 *   custom setter에 추가로 접근 지시어를 붙여 setter에만 다른 가시성을 설정하는 방법
 */

open class Cat protected constructor(

)

class Car(
    internal val name: String,  // 프로퍼티, getter internal
    private var owner: String,  // 프로퍼티, getter private, setter private
    _price: Int                 // 생성자의 파라미터
) {

    var price = _price          // 프로퍼티, getter는 public
        private set             // setter는 private
}

/**
 * 4. Java와 Kotlin을 함께 사용할 때 주의할 점
 * internal은 바이트 코드 상 public이 됨, 따라서 Java 코드에서는 Kotlin 모듈의 internal 코드를 가져올 수 있음
 * 예를 들어, 상위 모듈은 Java, 하위 모듈은 Kotlin으로 이루어져 있으면,
 * 하위 모듈의 internal 필드나 함수 등을 상위 모듈인 Javd에서 바로 가져올 수 있음
 * 왜냐하면 Kotlin의 internal이 결국 바이트 코드로 바뀌어서 Java의 바이트 코드와 합쳐지는데
 * Java에서는 internal의 바이트 코드가 public이므로 접근 할 수 있음
 * 따라서 Java 코드에서는 Kotlin 모듈의 internal 코드를 가져올 수 있음
 *
 * Kotlin의 protected와 Java의 protected는 다름
 * Java의 protected는 같은 패키지라면 접근 가능
 * Koltlin의 protected는 같은 패키지라도 접근 불가능
 * Java는 같은 패키지안에 있는 Koltin 코드의 protected에 접근 가능함!
 */

fun main(args: Array<String>) {
    println("Lec 11")

}
