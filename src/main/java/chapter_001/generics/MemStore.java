package chapter_001.generics;

import java.util.ArrayList;
import java.util.List;

public final class MemStore<T extends Base> implements Store<T> {
    private final List<T> mem = new ArrayList<>();

    @Override
    public void add(T model) {
        mem.add(model);

    }

    @Override
    public boolean replace(String id, T model) {

        return replace(id, model);
    }

    @Override
    public boolean delete(String id) {
        int index = Integer.parseInt(findById(id).getId());
        if (index == -1) {
            return false;
        }
        mem.remove(index);
        return true;
    }

    @Override
    public T findById(String id) {
        return mem.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}

