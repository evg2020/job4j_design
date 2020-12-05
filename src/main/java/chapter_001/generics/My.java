package chapter_001.generics;

import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.Map;
import java.util.function.Predicate;
//тип ключа (K) и тип значения (V).

public interface My<K, V> {

    /**
     * Кладёт значение в хранилище по заданному ключу.
     *
     * @param key   Ключ.
     * @param value Значение.
     */
    void put(K key, V value);
    //void put(

    /**
     * Читает значение из хранилища по заданному ключу.
     *
     * @param key Ключ.
     * @return Значение либо null.
     */
    @Nullable V get(K key);

    /**
     * Кладёт все пары ключ-значение в хранилище.
     *
     * @param entries Набор пар ключ-значение.
     */
    void putAll(Map<K, V> entries);
    //void putAll(Map<? extends K, ? extends V> entries);
    //void putAll(Map<? extends K, ? extends V>
    //если аргумент - производитель (producer), нужно использовать ? extends T
//если метод читает данные из аргумента, то этот аргумент - производитель
    /**
     * Читает все значения из хранилища по заданным
     * ключам.
     *
     * @param keys Набор ключей.
     * @return Пары ключ-значение.
     */
    Map<K, V> getAll(Collection<K> keys);

    /**
     * Читает из хранилища все значения, удовлетворяющие
     * заданному условию (предикату).
     *
     * @param p Предикат для проверки значений.
     * @return Значения, удовлетворяющие предикату.
     */
    Collection<V> getAll(Predicate<V> p);
    //Collection<V> getAll(Predicate<? super V> p); аргумент - потребитель (consumer),
    // нужно использовать ? super T.
    //метод передаёт данные в аргумент, то аргумент является потребителем.

}
