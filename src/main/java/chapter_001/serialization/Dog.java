package chapter_001.serialization;

public class Dog {
    private final String breed;
    private final int id;

    public Dog(String breed, int id) {
        this.breed = breed;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "breed='" + breed + '\'' +
                ", id=" + id +
                '}';
    }
}
