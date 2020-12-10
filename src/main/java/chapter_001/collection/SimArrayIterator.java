package chapter_001.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimArrayIterator<T> implements Iterator<T> {

    private final SimpleArray<T> array;
    private int index = 0;

    public SimArrayIterator(SimpleArray<T> array) {
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        return index < 10;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return array.get(index++);
    }
}
