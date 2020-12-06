package chapter_001.generics;

public class Role extends Base {
    private final String nameRole;

    Role(String id, String nameRole) {
        super(id);
        this.nameRole = nameRole;
    }

    public String getNameRole() {
        return nameRole;
    }
}
