package me.gabreuw.springwebmvc.rest;

import lombok.RequiredArgsConstructor;
import me.gabreuw.springwebmvc.exception.JediNotFoundException;
import me.gabreuw.springwebmvc.model.Jedi;
import me.gabreuw.springwebmvc.repository.JediRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/jedi")
@RequiredArgsConstructor
public class JediResource {

    private final JediRepository repository;

    @GetMapping
    public List<Jedi> getAll() {
        return repository.getAll();
    }

    @GetMapping(path = "/{id}")
    public Jedi getById(@PathVariable Integer id) {
        return repository.getById(id);
    }

}
