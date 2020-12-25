package chapter_001.io;

import java.io.File;

public class Dir {
    public static void main(String[] args) {
        File file = new File(args[0]);
        if (!file.exists()) {
            throw new IllegalArgumentException(String.format("Not exist %s", file.getAbsoluteFile()));
        }
        if (!file.isDirectory()) {
            throw new IllegalArgumentException(String.format("Not directory %s", file.getAbsoluteFile()));
        }
        if (args.length == 0) {
            throw new IllegalArgumentException(String.format("Root folder is null. Usage java -jar dir.jar ROOT_FOLDER."));
        }
        long size = file.getTotalSpace() / (1024 * 1024);
        System.out.println(String.format("size : %s MB", size));

        System.out.println(file.getName());
    }
}

