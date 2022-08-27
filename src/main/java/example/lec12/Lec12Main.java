package example.lec12;

public class Lec12Main {

    public static void main(String[] args) {
        //Person.Companion.newBaby("ABC");
        //Person.newBaby("ABC");
        //Person.Factory.newBaby("ABC");

        moveSomething(new Movable() {
            @Override
            public void move() {
                System.out.println("움직인다~~");
            }

            @Override
            public void fly() {
                System.out.println("날아간다~~");
            }
        });
    }

    private static void moveSomething(Movable movable) {
        movable.move();
        movable.fly();
    }
}
