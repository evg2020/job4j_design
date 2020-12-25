package chapter_001.steam;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Steam {
    private final String name;
    private final int spend;

    Steam(String name, int spend) {
        this.name = name;
        this.spend = spend;
    }

    public String getName() {
        return name;
    }


    public int getSpend() {
        return spend;
    }

    @Override
    public String toString() {
        return "Steam{" +
                "name='" + name + '\'' +
                ", spend=" + spend +
                '}';
    }

    public static void main(String[] args) {
        List<Steam> list01 = List.of(
                new Steam("vova", 12),
                new Steam("evg", 22)
        );
        List<Steam> bud = list01.stream()
                .filter(e -> e.name.contains("evg"))
                .collect(Collectors.toList());
        bud.forEach(System.out::println);

        //Метод contains() — это метод Java, позволяющий проверить, содержит ли String другую подстроку или нет. Возвращает логическое значение,
        // поэтому его можно использовать непосредственно внутри операторов if.

        String[] array = {"Java", "Ruuuuussshhh"};
        Stream<String> streamOfArray = Arrays.stream(array);
        streamOfArray.map(s -> s.split(""))
//Преобразование слова в массив букв

                .flatMap(Arrays::stream).distinct()
//выравнивает каждый сгенерированный поток в один поток

                .collect(Collectors.toList()).forEach(System.out::println);
    }


}
