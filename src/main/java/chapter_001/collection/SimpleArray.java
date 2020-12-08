package chapter_001.collection;


import java.util.Iterator;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {
    private T[] container = (T[]) new Object[10];
    private int index = 0;


    public T get(int index) {
        return container[Objects.checkIndex(index, this.index)];
    }

    public void add(T model) {
        if (index == container.length - 1) {
            expContainer();
        }
        container[index++] = model;

    }

    @Override
    public Iterator<T> iterator() {
        return new SimArrayIterator<T>(this);
    }

    private void expContainer() {
        T[] temp = container;
        container = (T[]) new Object[container.length + 10];
        System.arraycopy(temp, 0, container, 0, temp.length);
    }

}
