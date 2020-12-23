package chapter_001.io;

import java.io.File;

public class Dir {
    public static void main(String[] args) {
        File file = new File("C:\\projects");
        if (!file.exists()) {
            throw new IllegalArgumentException(String.format("Not exist %s", file.getAbsoluteFile()));
        }
        if (!file.isDirectory()) {
            throw new IllegalArgumentException(String.format("Not directory %s", file.getAbsoluteFile()));
        }
        long size = file.getTotalSpace();
        System.out.println(String.format("size : %s MB", size));
        System.out.println(file.getName());
    }
    }

