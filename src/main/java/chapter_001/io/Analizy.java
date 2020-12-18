package chapter_001.io;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
//преобразования одного файла в другой.

public class Analizy {
    //1. Реализуйте метод unavailable.
    //source - имя файла лога
    //target - имя файла после анализа.
    //2. Метод anavailable должен находить диапазоны, когда сервер не работал.
    //Сервер не работал. если status = 400 или 500.
    public void unavailable(String source, String target) {
        List<String> res = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(source))) {
            StringBuilder stringBuilder = new StringBuilder();
            in.lines().forEach(e -> {
                        String[] data = e.split(" ");
                        if ("400".equals(data[0]) || "500".equals(data[0])) {
                            if (stringBuilder.length() == 0) {
                                stringBuilder.append(data[1]);
                            }
                        } else if ("200".equals(data[0]) || "300".equals(data[0])) {
                            if (stringBuilder.length() != 0) {
                                stringBuilder.append(";").append(data[1]);
                                res.add(stringBuilder.toString());
                                stringBuilder.setLength(0);
                            }
                        }
                    }
            );
            if (stringBuilder.length() != 0) {
                res.add(stringBuilder.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        writeToFile(target, res);
    }

    public void writeToFile(String file, List<String> list) {
        try (PrintWriter out = new PrintWriter(new FileOutputStream(file))) {
            list.forEach(e -> out.write(e + System.lineSeparator()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}