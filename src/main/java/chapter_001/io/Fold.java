package chapter_001.io;

import java.io.File;

public class Fold {
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

        File dir = new File("C:\\projects");
        System.out.println(dir.getName());
        long size = getFolderSize(dir);
        System.out.println(String.format("size - %s Bytes", size));
    }
}
