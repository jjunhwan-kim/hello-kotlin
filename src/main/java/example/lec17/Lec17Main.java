package example.lec17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Lec17Main {

    public static void main(String[] args) {

        Lec17Main main = new Lec17Main();

        List<Fruit> fruits = Arrays.asList(
                new Fruit("사과", 1_000),
                new Fruit("사과", 1_200),
                new Fruit("사과", 1_200),
                new Fruit("사과", 1_500),
                new Fruit("바나나", 3_000),
                new Fruit("바나나", 3_200),
                new Fruit("바나나", 2_500),
                new Fruit("수박", 10_000)
        );

        List<Fruit> apples = main.findApples(fruits);
        for (Fruit apple : apples) {
            System.out.println(apple);
        }

        System.out.println("===");

        List<Fruit> bananas = main.findBananas(fruits);
        for (Fruit banana : bananas) {
            System.out.println(banana);
        }

        System.out.println("===");

        // JDK8 Lambda & Functional Interface
        List<Fruit> filteredFruits = main.filterFruits(fruits, fruit -> fruit.getPrice() > 3000);
        for (Fruit filteredFruit : filteredFruits) {
            System.out.println(filteredFruit);
        }

        // Method Reference
        // Java에서 함수는 변수에 할당되거나 파라미터로 전달할 수 없음(2급 시민)
        apples = main.filterFruits(fruits, Fruit::isApple);


        String targetFruitName = "바나나";
        /**
         * Varibale used in lambda expression should be final or effectively final
         *   - Java에서는 람다를 쓸 때 사용할 수 있는 변수에 제약이 있음
         *   - 즉, 람다 밖에 있는 변수를 사용하는 경우 제약이 있음
         *   - final인 변수 혹은 실질적으로 final인 변수만 사용할 수 있음!!
         */
        //targetFruitName = "수박";
        List<Fruit> filteredFruits2 = main.filterFruits(fruits, fruit -> targetFruitName.equals(fruit.getName()));

    }

    private List<Fruit> findApples(List<Fruit> fruits) {

        List<Fruit> apples = new ArrayList<>();

        for (Fruit fruit : fruits) {
            if (fruit.getName().equals("사과")) {
                apples.add(fruit);
            }
        }

        return apples;
    }

    private List<Fruit> findBananas(List<Fruit> fruits) {

        List<Fruit> bananas = new ArrayList<>();

        for (Fruit fruit : fruits) {
            if (fruit.getName().equals("바나나")) {
                bananas.add(fruit);
            }
        }

        return bananas;
    }

    private List<Fruit> filterFruits(List<Fruit> fruits, Predicate<Fruit> fruitFilter) {
        /*
        List<Fruit> filteredFruits = new ArrayList<>();

        for (Fruit fruit : fruits) {
            if (fruitFilter.test(fruit)) {
                filteredFruits.add(fruit);
            }
        }
        return filteredFruits;
        */

        // Stream
        return fruits.stream()
                .filter(fruitFilter)
                .collect(Collectors.toList());
    }
}
