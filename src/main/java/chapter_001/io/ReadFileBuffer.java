package chapter_001.io;

import java.io.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ReadFileBuffer {
    public static void main(String[] args) {
        try (BufferedReader in = new BufferedReader(new FileReader("res.txt"))) {
            List<String> lines = new ArrayList<String>();
            in.lines().forEach(lines::add);
            /*for (String line : lines) {
                System.out.println(line);
            }*/
            System.out.println(lines.get(0));
            System.out.println(lines.get(1));


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
