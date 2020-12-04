package chapter_001.it;

public class GenericsClass<K, V> {
    private K key;
    private V value;

    @Override
    public String toString() {
        return "GenericsClass{"
                +
                "key=" + key
                +
                ", value=" + value
                +
                '}';
    }

    public GenericsClass(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public static void main(String[] args) {
        GenericsClass<String, String> gen = new GenericsClass<>("First key", "First value");
        System.out.println(gen);
        GenericsClass<Integer, String> second = new GenericsClass<>(12, "Second value");
        System.out.println(second);
    }
}
