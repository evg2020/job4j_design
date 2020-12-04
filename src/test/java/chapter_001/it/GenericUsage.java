package chapter_001.it;
//<Person> записывается конструкция <? extends Person>

import java.util.*;

public class GenericUsage {
    //WildCard (обозначает <?>).
    // В этом случае ограничений в использовании не будет (т.е. он имеет соответствие с любым типом).
    public void printRsl(Collection<?> col) {
        for (Iterator<?> iter = col.iterator(); iter.hasNext(); ) {
            Object next = iter.next();
            System.out.println(next);
        }
    }

    //<Person> записывается конструкция <? extends Person>
    public void printInfo(Collection<? extends Person> col) {
        for (Iterator<? extends Person> it = col.iterator(); it.hasNext(); ) {
            Person next = it.next();
            System.out.println(next);
        }
    }

    public void addAll(List<? super Integer> list) {
        for (int i = 1; i <= 5; i++) {
            list.add(i);
        }
        for (Object o : list) {
            System.out.println("Текущий элемент: " + o);
        }
    }


    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("first");
        list.add("second");
        list.add("third");
        list.add(new Person("name", 21, new Date(913716000000L)));
        new GenericUsage().printRsl(list);
        System.out.println("----------");
        //<Person> записывается конструкция <? extends Person>
        List<Person> per = List.of(new Person("name", 21, new Date(913716000000L)));
        new GenericUsage().printRsl(per);

        List<Programmer> pro = List.of(new Programmer("name123", 23, new Date(913716000000L)));
        new GenericUsage().printRsl(pro);

        System.out.println("----------");


        List list1 = new ArrayList();
        new GenericUsage().addAll(list);
    }
}



