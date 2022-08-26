package example.lec07;

import org.jetbrains.annotations.NotNull;

import java.io.*;


public class Lec07Main {

    public static void main(String[] args) {

        try {
            new Lec07Main().readFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int parseIntOrThrow(@NotNull String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(String.format("주어진 %s는 숫자가 아닙니다", str));
        }
    }

    private Integer parseIntOrThrowV2(@NotNull String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private void readFile() throws IOException {
        File currentFile = new File(".");
        File file = new File(currentFile.getAbsolutePath() + "/a.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        System.out.println(reader.readLine());
        reader.close();
    }

    private void readFile(String path) throws IOException {
        /**
         * try 괄호 안에 외부 자원을 만들어주고
         * try가 끝나면 자동으로 외부 자원을 닫아주는 try with resources 구문
         */
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            System.out.println(reader.readLine());
        }
    }
}
