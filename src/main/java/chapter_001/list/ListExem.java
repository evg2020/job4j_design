package chapter_001.list;

import org.w3c.dom.ls.LSOutput;

import java.lang.reflect.Array;
import java.util.*;

public class ListExem {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");

    /*    System.out.println(list);
        ListIterator<String> iter = list.listIterator(1);
        while (iter.hasNext()) {
            System.out.printLn(iter.next());*/
List<String> res = Arrays.asList("ten", "elleven");
list.addAll(list.size(), res);
        list.replaceAll(s -> s.toUpperCase());
        list.replaceAll(String::toLowerCase);
//        List<String> delList = Arrays.asList("one", "two");
//        list.removeAll(delList);
//        list.remove(2);
//        list.remove("one");
//        System.out.println(list);
//        list.removeIf(s -> s.length() <= 3);
        System.out.println(list);

        System.out.println(list.contains("one"));
        System.out.println(list.indexOf("two"));
        List<String> res01 = new ArrayList<>();
        res01 = list.subList(1, 3);
        list.sort(Comparator.naturalOrder());
        System.out.println(list);
    }
}


