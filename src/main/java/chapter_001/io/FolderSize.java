package chapter_001.io;

import java.io.File;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class FolderSize {
    public static long getFolderSize(File folder) {
        long length = 0;
        File[] files = folder.listFiles();
//        System.out.println(Arrays.toString(files));
        int count = files.length;

        for (int i = 0; i < count; i++) {
            if (files[i].isFile()) {
                length += files[i].length();
            } else {
                length += getFolderSize(files[i]);
            }
        }
        return length;
    }

    public static void main(String[] args) {
        System.out.println("Way to Dir");
        String way = new Scanner(System.in).nextLine();
        File dir = new File(way);

        System.out.println(getFolderSize(dir));

        Path folder = Paths.get("C:\\projects");
        try {
            long size = Files.walk(folder)
                    .filter(p -> p.toFile().isFile())
                    .mapToLong(p -> p.toFile().length())
                    .sum();
            System.out.println(size);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

