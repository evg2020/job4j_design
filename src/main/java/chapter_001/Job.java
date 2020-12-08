package chapter_001;


import java.lang.reflect.Array;
import java.util.*;
import java.util.Comparator;

public class Job implements Comparable<Job> {
    private String name;
    private int prior;

    @Override
    public String toString() {
        return "Job{"
                +
                "name='" + name + '\''
                +
                ", prior=" + prior
                +
                '}';
    }

    public Job(String name, int prior) {
        this.name = name;
        this.prior = prior;
    }

    public int getPrior() {
        return prior;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Job o) {
        return (this.getPrior() - o.getPrior());
        //        return (this.prior - o.prior);

    }


    public static void main(String[] args) {

        int[] array = {1, 3, 2, 4, 5, 2, 3};
        List<Job> job = Arrays.asList(new Job("Ivan", 4),
                new Job("Vany", 1),
                new Job("Oleg", 10
                ));
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
        Collections.sort(job);
        System.out.println(job);
        Collections.sort(job, new JobByName());
        System.out.println(job);

        //лямбда
        Comparator<Job> byName = (left, right) -> left.getName().compareTo(right.name);
        Collections.sort(job, byName);
        System.out.println(job);




    }
}

