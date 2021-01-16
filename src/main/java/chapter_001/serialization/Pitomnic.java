package chapter_001.serialization;

/*Придумайте Java объект, объект должен иметь поля булево,
        какой-нибудь числовой тип, строковый тип,
        вложенный объект и массив.*/

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;

public class Pitomnic {
    private final int age;
    private final String name;
    private Dog dog;
    private String[] statues;

    Pitomnic(int age, String name, Dog dog, String...statuces){
        this.age = age;
        this.name = name;
        this.dog = dog;
        this.statues = statuces;
    }

    @Override
    public String toString() {
        return "Pitomnic{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", dog=" + dog +
                ", statues=" + Arrays.toString(statues) +
                '}';
    }
    public static void main(String[] args){
        final Pitomnic pitomnic = new Pitomnic(12, "Mery", new Dog("dog", 0023), "red", "biting");
        final Gson gson = new GsonBuilder().create();
        String json = gson.toJson(pitomnic);
        System.out.println(json);

        final Pitomnic pitBack = gson.fromJson(json, Pitomnic.class );
        System.out.println(pitBack);
    }
}
