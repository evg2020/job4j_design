package chapter_001.io;

import java.io.FileInputStream;
import java.util.Arrays;

public class IvenNumberFile {
    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream("even.txt")) {
            StringBuilder text = new StringBuilder();
            int read;
            while ((read = in.read()) != -1) {
                text.append((char) read);
            }
            //System.out.println(text);
            String[] lines = text.toString().split(System.lineSeparator());
            for (String line : lines) {
                int intLine = Integer.parseInt(line);
                if (intLine % 2 == 0) {
                    System.out.println(line + " --even");
                } else {
                    System.out.println(line + " ---not even");
                }
            }
            System.out.println(Arrays.toString(lines));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
