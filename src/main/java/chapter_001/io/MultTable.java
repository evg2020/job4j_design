package chapter_001.io;

import java.io.FileOutputStream;
import java.util.Arrays;

public class MultTable {
    public static void main(String[] args) {
        /*String multTabl = "";
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                multTabl = Integer.toString((i + 1) * (j + 1));
                System.out.println( multTabl);
            }*/
        String multTabl = "1*1 =1, 1*2=2, 1*3=3, 1*4=4, 1*5=5, 1*6=6, 1*7=7";
        try (FileOutputStream out = new FileOutputStream("MultTable.txt")) {
            out.write(multTabl.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

