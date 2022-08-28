package example.lec13;

public class Lec13Main {
    public static void main(String[] args) {

        JavaHouse house = new JavaHouse("제주도");
        System.out.println(house.getLivingRoom().getAddress());
    }
}
