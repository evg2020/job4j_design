package chapter_001.io;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.nio.charset.StandardCharsets.UTF_8;

public class ReadFile {
    /*public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream("input.txt")) {
            StringBuilder text = new StringBuilder();
            int read;
            while ((read = in.read()) != -1) {
                text.append((char) read);
            }
            System.out.println(text);
            *//*String[] lines = text.toString().split(" ");
            for (String line : lines) {
                System.out.println(line);
            }*//*
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
    public static void main(String[] args) throws IOException {
        // способ 1
        try (FileInputStream in = new FileInputStream("input.txt")) {
            StringBuilder text = new StringBuilder();
            int read;
            while ((read = in.read()) != -1) {
                text.append((char) read);
            }
            String[] lines = text.toString().split(System.lineSeparator());
            for (String line : lines) {
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //способ 2
        List<String> lines = Files.readAllLines(Paths.get("input.txt"));
        for (String s : lines) {
            System.out.println();
        }
//        System.out.println(lines.toString());


        //способ 3
        List<String> lines02 = new ArrayList<>();
        Stream<String> stream = Files.lines(Paths.get("input.txt"));
        lines02 = stream
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        // вывод содержимого папки
        File files = new File("C:\\projects");
        String[] array = files.list();
        System.out.println(Arrays.toString(array));
        }
    }



