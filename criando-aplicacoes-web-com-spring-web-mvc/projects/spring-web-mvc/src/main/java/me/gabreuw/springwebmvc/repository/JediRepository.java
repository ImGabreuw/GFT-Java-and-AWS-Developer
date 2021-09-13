package me.gabreuw.springwebmvc.repository;

import me.gabreuw.springwebmvc.exception.JediNotFoundException;
import me.gabreuw.springwebmvc.model.Jedi;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class JediRepository {

    private final List<Jedi> jediList = new ArrayList<>();

    public JediRepository() {
        jediList.add(new Jedi("Luke", "Skywalker"));
    }

    public List<Jedi> getAll() {
        return jediList;
    }

    public Jedi getById(int id) {
        if (id < 0 || id >= jediList.size()) {
            throw new JediNotFoundException(id);
        }

        return jediList.get(id);
    }

    public void add(Jedi jedi) {
        jediList.add(jedi);
    }

}
