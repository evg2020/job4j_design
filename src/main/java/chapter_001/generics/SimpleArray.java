package chapter_001.generics;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/*Добавить методы:

        -add(T model) - добавляет указанный элемент (model) в первую свободную ячейку;
        -set(int index, T model) - заменяет указанным элементом (model) элемент,   находящийся по индексу index;
       - remove(int index) - удаляет элемент по указанному индексу,
                       все находящиеся справа элементы при этом необходимо сдвинуть на единицу влево (в середине массива не должно быть пустых ячеек);
        -get(int index) - возвращает элемент, расположенный по указанному индексу;
        -Также, реализуйте интерфейс Iterable<T> - метод iterator() возвращает итератор, предназначенный для обхода данной структуры.*/

public class SimpleArray<T> implements Iterable<T> {
    private T[] simpArray;
    int point = 0;
    int calculate = 0;

    SimpleArray(int size) {
        simpArray = (T[]) new Object[size];
    }

    public void add(T model) throws IndexOutOfBoundsException {
        simpArray[Objects.checkIndex(point++, simpArray.length)] = model;
    }

    public void set(int index, T model) throws IndexOutOfBoundsException {
        simpArray[Objects.checkIndex(index, simpArray.length)] = model;
    }

/*3. Копирование элементов массива
    Метод System.arraycopy() принимает несколько параметров.
    Первым параметром является массив-источник.
    Вторым параметром является позиция начала нового массива.
    Третий параметр — массив-назначения.
    Четвертый параметр является начальным положением целевого массива.
    Пятый параметр это количество элементов, которые будут скопированы.
    Вот код, чтобы скопировать последние пять элементов исходного массива в конечный массив (массив-назначения):
    Java
     System.arraycopy (sourceArr, 5, destArr, 0, 5);*/

    public void remove(int index) throws IndexOutOfBoundsException {
        index = Objects.checkIndex(index, simpArray.length);
        System.arraycopy(simpArray, index + 1, simpArray, index, simpArray.length - index - 1);
        point--;
    }

    public T get(int index) throws IndexOutOfBoundsException {
        return simpArray[Objects.checkIndex(index, simpArray.length)];
    }

    @NotNull
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return point < simpArray.length;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return simpArray[calculate++];
            }
        };
    }
}
