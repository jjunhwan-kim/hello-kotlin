package example.lec12;

public class JavaSingleton {

    /**
     * 동시성 처리를 더 할 수 있음!(Lazy Initialization, Double-Checked Locking Singleton)
     * enum class를 활용하는 방법도 있음!
     */
    private static final JavaSingleton INSTANCE = new JavaSingleton(); // Early Initialization

    private JavaSingleton() {
    }

    public static JavaSingleton getInstance() {
        return INSTANCE;
    }
}
