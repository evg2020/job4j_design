package chapter_001.io;
 import java.io.FileOutputStream;
 // Запись в файл result001.txt

public class ResultFile {
    public static void main(String[] args) {
        try (FileOutputStream out = new FileOutputStream("result001.txt")) {
            for (int i = 0; i < 3; i++) {
                out.write(("Hello, world! " + i).getBytes());
                out.write(System.lineSeparator().getBytes());
            }

            out.write("Hello".getBytes());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
