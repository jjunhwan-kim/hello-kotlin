import java.util.Arrays;
import java.util.List;

public class Lec08Main {

    public static void main(String[] args) {

        String[] array = {"A", "B", "C"};
        Lec08Main lec08Main = new Lec08Main();
        lec08Main.printAll(array);
        lec08Main.printAll("D", "E", "F");

    }

    public int max(int a, int b) {
        if (a > b) {
            return a;
        }
        return b;
    }

    public void repeat(String str, int num, boolean useNewLine) {
        for (int i = 1; i <= num; i++) {
            if (useNewLine) {
                System.out.println(str);
            } else {
                System.out.print(str);
            }
        }
    }

    public void repeat(String str, int num) { // Method Overloading
        repeat(str, num, true);
    }

    public void repeat(String str) {
        repeat(str, 3, true);
    }

    public void printAll(String... strings) {
        for (String str : strings) {
            System.out.println(str);
        }
    }
}
