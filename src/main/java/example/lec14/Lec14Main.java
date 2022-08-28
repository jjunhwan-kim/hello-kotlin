package example.lec14;

public class Lec14Main {

    public static void main(String[] args) {


    }

    /**
     * country 종류가 많아질수록 if~else if 로직이 길어짐
     * else 로직 처리가 애매함, JavaCountry 타입이므로 다른 값이 들어올리는 없기 때문
     */
    private static void handleCountry(JavaCountry country) {
        if (country == JavaCountry.KOREA) {
            // 로직 처리
        }

        if (country == JavaCountry.AMERICA) {
            // 로직 처리
        }
    }
}
