package me.gabreuw.springwebmvc.service;

import lombok.RequiredArgsConstructor;
import me.gabreuw.springwebmvc.exception.JediNotFoundException;
import me.gabreuw.springwebmvc.model.Jedi;
import me.gabreuw.springwebmvc.repository.JediRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JediService {

    private final JediRepository repository;

    public List<Jedi> findAll() {
        return repository.findAll();
    }

    public Jedi findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new JediNotFoundException(id));
    }

    public void save(Jedi jedi) {
        repository.save(jedi);
    }

    public Jedi update(Long id, Jedi jedi) {
        Jedi recoveredJedi = findById(id);

        recoveredJedi.setName(jedi.getName());
        recoveredJedi.setLastname(jedi.getLastname());

        return repository.save(recoveredJedi);
    }

    public void deleteById(Long id) {
        Jedi recoveredJedi = findById(id);

        repository.delete(recoveredJedi);
    }

}
