package chapter_001.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;

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
    public static void main(String[] args) {

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
    }
}

