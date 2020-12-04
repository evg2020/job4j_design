package chapter_001.it;

import java.util.*;

public class GenericUsage {
    //WildCard (обозначает <?>).
    public void printRsl(Collection<?> col) {
        for (Iterator<?> it = col.iterator(); it.hasNext();) {
            Object next = it.next();
            System.out.println("Текущий элемент: " + next);
        }
    }

    //2. Bounded Wildcard-граничение типа сверху.
    public void printInfo(Collection<? extends Person> col) {
        for (Iterator<? extends Person> it = col.iterator(); it.hasNext();) {
            Person next = it.next();
            System.out.println(next);
        }
    }
//граничение типа снизу List<? super Integer>

    public void addAll(List<? super Integer> list) {
        for (int i = 1; i <= 5; i++) {
            list.add(i);
        }
        for (Object o : list) {
            System.out.println("Текущий элемент: " + o);
        }
    }

    public static void main(String[] args) {
        List list = new ArrayList<>();
        list.add("first");
        list.add("second");
        list.add("third");
        list.get(1);
        list.add(new Person("name", 21, new Date(913716000000L)));
        Object o = list.get(1);
        String n = (String) list.get(0);
       /* for (int i = 0; i < list.size(); i++) {
            String s = (String) list.get(i);
            System.out.println("Текущий элемент: " + s);*/

        List<Integer> l = List.of(1, 2, 3, 4, 5);
        new GenericUsage().printRsl(l);

        List<Person> per = List.of(new Person("Person", 21, new Date(913716000000L)));
        new GenericUsage().printInfo(per);

        List<Programmer> pro = List.of(new Programmer("Programmer", 23, new Date(913716000000L)));
        new GenericUsage().printInfo(pro);

        List<? super Integer> list02 = new ArrayList<>();
        new GenericUsage().addAll(list02);

    }
}




