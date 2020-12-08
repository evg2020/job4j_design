package chapter_001.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ListUsage {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("");
        list.add("two");
        list.add("three");
        /*list.addAll(3, list);*/
        list.add("");
        System.out.println(list.remove("Nulls"));
        //2. boolean remove(E e) – удаляет элемент е
        // типа E из коллекции при его ПЕРВОМ вхождении в список, если он есть в коллекции
        list.removeIf(s -> s.length() < 5);
        for (String s : list) {
            System.out.println(s);
        }
        System.out.println();

        list.set(0, "Null");
        list.replaceAll(String::toUpperCase);
        ListIterator<String> iter = list.listIterator(0);
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
        System.out.println();

        list.removeIf(s -> s.equals("one"));
        boolean b = list.contains("TWO");
        System.out.println(b);

        int index = list.indexOf("TWO");
        System.out.println(index);

        index = list.lastIndexOf("TWO");
        System.out.println(index);


    }
}
