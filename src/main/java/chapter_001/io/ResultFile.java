package chapter_001.io;

import java.io.FileOutputStream;
import java.io.PrintWriter;

//Класс java.io.FileOutputStream позволяет записать данные в файл.
// Запись в файл result001.txt

public class ResultFile {
       public static void main(String[] args) {

        try (FileOutputStream out = new FileOutputStream("result.txt")) {
            for (int i = 0; i < 5; i++) {
                out.write("Hello word ++".getBytes());
                out.write(System.lineSeparator().getBytes());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
