package me.gabreuw.springwebmvc.repository;

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

    public void add(Jedi jedi) {
        jediList.add(jedi);
    }

}
