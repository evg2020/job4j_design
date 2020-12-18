package chapter_001.io;

import java.io.File;

public class Fold {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\adm\\Desktop");
        File[] folders = file.listFiles();
        for (File fold : folders) {
            System.out.println(fold);
        }
    }
}
