package chapter_001.it;

//итератор для одномерного массива чисел.

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
    // Метод hasNext проверяет, расположена ли ячейка в диапазоне масива.

    @Override
    public boolean hasNext() {
        return point < data.length;
    }

    // Метод next возвращает первый (номер толь) элемент ячейки.
// Второй вызов метода next вернет второй элемент и так далее.
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
       /* System.out.println(it.next());
        System.out.println(it.previus());
        System.out.println(it.previus());*/
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

}
