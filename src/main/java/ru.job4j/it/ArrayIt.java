package ru.job4j.it;


import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayIt implements Iterator<Integer> {
    private final int[] data;
    private int point = 0;
    private int pointBack;

    public ArrayIt(int[] data) {
        this.data = data;
        this.pointBack = data.length - 1;
    }

    @Override
    public boolean hasNext() {
        return point < data.length;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[point++];
    }

    public boolean hasPrevius() {
        return pointBack > -1;
    }

    public Integer previus() {

        if (!hasPrevius()) {
            throw new NoSuchElementException();
        }
        return data[pointBack--];
    }

    public static void main(String[] args) {
        ArrayIt it = new ArrayIt(new int[]{1, 2, 3});
        System.out.println(it.previus());
        System.out.println(it.previus());
        System.out.println(it.previus());
    }

}
