package example.lec18

fun main(args: Array<String>) {
    println("Lec 18")

    val fruits = listOf<Fruit>(

    )

    /**
     * 1. 필터와 맵
     */
    // 필터
    val apples = fruits.filter { fruit -> fruit.name == "사과" }

    // 필터에서 인덱스가 필요한 경우
    val apples2 = fruits.filterIndexed { index, fruit ->
        println(index)
        fruit.name == "사과"
    }

    // 맵
    val applePrices = fruits.filter { fruit -> fruit.name == "사과" }
        .map { fruit -> fruit.currentPrice }

    for (applePrice in applePrices) {
        println(applePrice)
    }

    // 맵에서 인덱스가 필요한 경우
    val applePrices2 = fruits.filter { fruit -> fruit.name == "사과" }
        .mapIndexed { index, fruit ->
            println(index)
            fruit.currentPrice
        }

    // 맵의 결과가 null이 아닌 것만 가져오고 싶을 때
    /*
    fruits.filter { fruit -> fruit.name == "사과" }
        .mapNotNull { fruit -> fruit.nullOrValue() }
    */


    /**
     * 2. 다양한 컬렉션 처리 기능
     */

    // 모든 과일이 사과인지?
    /**
     * all - 조건을 모두 만족하면 true, 그렇지 않으면 false
     *   - ex) 모든 과일이 사과인지?
     * none - 조건을 모두 불만족하면 true, 그렇지 않으면 false
     * any - 조건을 하나라도 만족하면 true, 그렇지 않으면 false
     *   - ex) 출고가 10,000 이상의 과일이 하나라도 있는지?
     */
    val isAllApple = fruits.all { fruit -> fruit.name == "사과" }
    val isNoApple = fruits.none { fruit -> fruit.name == "사과" }
    val isAnyFactoryPriceGreaterOrEqual = fruits.any { fruit -> fruit.factoryPrice >= 10_000 }


    /**
     * count - 개수 카운트
     * sortedBy - 오름차순 정렬
     * sortedByDescending - 내림차순 정렬
     * distinctBy - 변형된 값을 기준으로 중복을 제거
     */

    val fruitCount = fruits.count()
    val sortedFruits = fruits.sortedBy { fruit -> fruit.currentPrice }
    val descendingSortedFruits = fruits.sortedByDescending { fruit -> fruit.currentPrice }
    val distinctFruitNames = fruits.distinctBy { fruit -> fruit.name }
        .map { fruit -> fruit.name }

    /**
     * first - 첫 번째 값을 가져옴(무조건 null이 아니어야함)
     * firstOrNull - 첫 번째 값 또는 null을 가져옴
     * last - 마지막 값을 가져옴(무조건 null이 아니어야함)
     * lastOrNull - 마지막 값 또는 null을 가져옴
     */
    val first = fruits.first()             // 첫 번째 값을 가져오려는데 빈 리스트이면 Exception 발생
    val firstOrNull = fruits.firstOrNull() // 첫 번째 값을 가져오려는데 빈 리스트이면 null 반환
    val last = fruits.last()
    val lastOrNull = fruits.lastOrNull()

    /**
     * 3. List를 Map으로
     *
     */

    /**
     * - 과일 이름이 Key이고, List<Fruit>가 Value인 경우
     *   - groupBy 사용
     *   -  과일이름 -> List<Fruit> Map
     */
    val map: Map<String, List<Fruit>> = fruits.groupBy { fruit -> fruit.name }

    /**
     * - 과일 id가 Key이고, Fruit가 Value인 경우
     *   - associateBy 사용
     *     - id를 통해서 매핑할 때, 즉 중복되지 않는 키로 map을 만들 때 사용
     *   -  과일이름 -> Fruit Map
     */
    val map2: Map<Long, Fruit> = fruits.associateBy { fruit -> fruit.id }

    /**
     * - 과일 이름이 Key이고, List<출고가>가 Value인 경우
     */
    val map3 = fruits.groupBy({ fruit -> fruit.name }, { fruit -> fruit.factoryPrice })

    /**
     * - 과일 id가 Key이고, List<출고가>가 Value인 경우
     */
    val map4 = fruits.groupBy({ fruit -> fruit.id }, { fruit -> fruit.factoryPrice })

    /**
     * 람다를 하나 쓸 때는 마지막 람다 중괄호를 소괄호 밖으로 뺄 수 있음
     * 함수형 파라미터를 두 개 이상 받는 경우 소괄호 안에 같이 넣어주는 게 convention
     */

    /**
     * Map에 대해서도 filter, any, none등 모두 사용할 수 있음
     */
    val map5 = fruits.groupBy { fruit -> fruit.name }
        .filter { (key, value) -> key == "사과" }

    /**
     * 4. 중첩된 컬렉션 처리
     */

    val fruitsInList: List<List<Fruit>> = listOf(
        listOf(
            Fruit(1L, "사과", 1_000, 1_500),
            Fruit(2L, "사과", 1_200, 1_500),
            Fruit(3L, "사과", 1_200, 1_500),
            Fruit(4L, "사과", 1_500, 1_500),
        ),
        listOf(
            Fruit(5L, "바나나", 3_000, 3_200),
            Fruit(6L, "바나나", 3_200, 3_200),
            Fruit(7L, "바나나", 2_500, 3_200),
        ),
        listOf(
            Fruit(8L, "수박", 10_000, 10_000)
        )
    )

    /**
     * 출고가와 현재가가 동일한 과일
     */
    val samePriceFruits = fruitsInList.flatMap { list ->
        list.filter { fruit -> fruit.factoryPrice == fruit.currentPrice }
    }

    val samePriceFruits2 = fruitsInList.flatMap { list -> list.samePriceFilter }

    /**
     * List<List<Fruit>>을 List<Fruit>으로 변환
     */
    val flatten: List<Fruit> = fruitsInList.flatten()
}

val List<Fruit>.samePriceFilter: List<Fruit>
    get() = this.filter(Fruit::isSamePrice)


private fun filterFruits(
    fruits: List<Fruit>,
    filter: (Fruit) -> Boolean
): List<Fruit> {
    return fruits.filter(filter)
}
