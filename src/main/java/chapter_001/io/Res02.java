package chapter_001.io;

import java.io.FileOutputStream;

public class Res02 {
    public static void main(String[] args) {
        try (FileOutputStream out = new FileOutputStream("res.txt")) {
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    out.write((" " + (i + 1) * (j + 1)).getBytes());
                }
                out.write(System.lineSeparator().getBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
