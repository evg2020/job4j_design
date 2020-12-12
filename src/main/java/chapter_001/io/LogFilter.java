package chapter_001.io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.FileOutputStream;

public class LogFilter {

    public static List<String> filter(String file) {
        String eq = "404";
        List<String> findEq = new ArrayList<>();
        try (FileInputStream in = new FileInputStream("log.txt")) {
            StringBuilder text = new StringBuilder();
            int read;
            while ((read = in.read()) != -1) {
                text.append((char) read);
            }
            String[] lines = text.toString().split(System.lineSeparator());
            for (String line : lines) {
                if (eq.equals(line.split(" ")[8])) {
                    findEq.add(line);
                }
            }
        } catch (
                Exception e) {
            e.printStackTrace();
        }
        return findEq;
    }

    public static void main(String[] args) {
        List<String> log = filter("log.txt");
        for (String res : log) {
            System.out.println(res);
        }
    }
}
