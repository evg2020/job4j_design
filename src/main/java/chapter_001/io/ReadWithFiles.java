package chapter_001.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
// чтение файла
public class ReadWithFiles {
    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        try {
            List<String> lines = Files.readAllLines(Paths.get("C:\\Users\\adm\\Desktop\\pom.txt"));
            for (String n : lines) {
                builder.append(n + "\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(builder.toString());
    }

}
