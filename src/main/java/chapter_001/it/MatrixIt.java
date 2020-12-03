package chapter_001.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

//итератор можно применить для любой структуры.
//
//Рассмотрим двухмерный массив.

public class MatrixIt implements Iterator<Integer> {
    private final int[][] data;
    private int row = 0;
    private int column = 0;

    public MatrixIt(int[][] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        while (row < data.length && data[row].length == 0) {
            row++;
        }
        return row < data.length;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int result = data[row][column++];
        if (column == data[row].length) {
            row++;
            column = 0;
        }
        return result;
    }

}

