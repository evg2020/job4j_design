package chapter_001.generics;

public class User extends Base {
    private final String name;

    public User(String id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
