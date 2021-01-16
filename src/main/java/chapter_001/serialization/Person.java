package chapter_001.serialization;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;

public class Person {
    private final boolean sex;
    private final int age;
    private final Contact contact;
    private final String[] statuses;

    public Person(boolean sex, int age, Contact contact, String... statuses) {
        this.sex = sex;
        this.age = age;
        this.contact = contact;
        this.statuses = statuses;
    }

    @Override
    public String toString() {
        return "Person{"
                + "sex=" + sex
                + ", age=" + age
                + ", contact=" + contact
                + ", statuses=" + Arrays.toString(statuses)
                + '}';
    }

   /* представление в формате JSON:

    {

        "sex" : false, // пара «ключ: значение» с логическим типом

            "age" : 30, // пара «ключ: значение» с числовым типом



            " contact" : { // объект

        " phone " : " 11-111" // пара «ключ: значение» со строкой
        , " phone1 " : " 22-222" // пара «ключ: значение» со строкой

    },

        "statuses":["Worker","Married"] // массив строк

    }*/
   public static void main(String[] args) {
       final Person person = new Person(false, 30, new Contact(222, "11-111"), "Worker", "Married", "New");

       /* Преобразуем объект person в json-строку. */
       final Gson gson = new GsonBuilder().create();
       String json = gson.toJson(person);
//       System.out.println(gson.toJson(person));
       System.out.println(json);

       /* Модифицируем json-строку */
       final String personJson = "{"
                       + "\"sex\":false,"
                       + "\"age\":35,"
                       + "\"contact\":"
                       + "{" + "\"phone\":\"+7(924)111-111-11-11\""
                       + "},"
                       + "\"statuses\":" + "[\"Student\",\"Free\"]"
                       + "}";
//       final Person personMod = gson.fromJson(personJson, Person.class);
       final Person personMod = gson.fromJson(json, Person.class);

       System.out.println(personMod);

   }
}