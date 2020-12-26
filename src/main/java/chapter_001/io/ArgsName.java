package chapter_001.io;

import java.util.HashMap;
import java.util.Map;
//В этом задании вам нужно будет написать программу,
// которая принимает массив параметров и разбивает их на пары: ключ, значение.
//java -Xmx=514 -encoding=UTF-8

public class ArgsName {
    private final Map<String, String> values = new HashMap<>();

    public String get(String key) {
        return values.get(key);
    }

    private void parse(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("Incorrect number of arguments");
        }
        for (String arg : args) {

            String[] data = arg.split("=");
            values.put(data[0].substring(1), data[1]);
        }
    }

    public static ArgsName of(String[] args) {
        ArgsName names = new ArgsName();
        names.parse(args);
        return names;
    }

    public static void main(String[] args) {
        ArgsName jvm = ArgsName.of(new String[]{"-Xmx=512", "-encoding=UTF-8"});
        System.out.println(jvm.get("Xmx"));

        ArgsName zip = ArgsName.of(new String[]{"-out=project.zip", "-encoding=UTF-8"});
        System.out.println(zip.get("out"));
    }
}
