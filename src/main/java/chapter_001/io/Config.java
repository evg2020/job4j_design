package chapter_001.io;

import java.util.HashMap;
import java.util.Map;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringJoiner;
import java.util.Properties;

public class Config {
    private final String path;
    private final Map<String, String> values = new HashMap<String, String>();


    public Config(final String path) {
        this.path = path;
    }

    //Реализуйте метод load по аналогии с методом toString.
    // Метод load должен загружать пару ключ-значение в Map values
    public void load() {
        try (BufferedReader in = new BufferedReader(new FileReader(this.path))) {
            in.lines().forEach(e -> {
                if (!e.isEmpty()) {
                    String[] prop = e.split("=");
                    values.put(prop[0], prop[1]);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//Реализуйте метод value(String key) он должен возвращать значение ключа.

    public String value(String key) {
        return this.values.get(key);
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out.toString();
    }

    public static void main(String[] args) {
        Config conf = new Config("./data/pair_without_comment.properties");
        conf.load();
        System.out.println(conf.toString());
        System.out.println(conf.value("name"));
    }
}
