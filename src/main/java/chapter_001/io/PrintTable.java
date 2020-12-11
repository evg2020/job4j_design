package chapter_001.io;
import java.io.FileOutputStream;
public class PrintTable {

    public static void main(String[] args) {
        printTable(multiple(10));
    }
    public static void printTable(int[][] table) {
        try (FileOutputStream out = new FileOutputStream("result.txt")) {
            for (int[] array : table) {
                for (int value : array) {
                    String space = value < 10 ? "  " : " ";
                    String elem = space + value;
                    out.write(elem.getBytes());
                }
                out.write(System.lineSeparator().getBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int[][] multiple(int size) {
        int[][] table = new int[size][size];
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                table[i][j] = (i + 1) * (j + 1);
            }
        }
        return table;
    }
}


