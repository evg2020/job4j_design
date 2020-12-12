package chapter_001.io;
 import java.io.FileOutputStream;
 import java.io.PrintWriter;
// Запись в файл result001.txt

public class ResultFile {
    public static void main(String[] args) {
        try (FileOutputStream out = new FileOutputStream("result.txt")) {
            for (int i = 0; i < 4; i++) {
                out.write(("hello" + i).getBytes());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
