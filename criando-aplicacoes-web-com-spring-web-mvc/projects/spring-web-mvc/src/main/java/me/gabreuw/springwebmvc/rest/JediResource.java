package me.gabreuw.springwebmvc.rest;

import lombok.RequiredArgsConstructor;
import me.gabreuw.springwebmvc.model.Jedi;
import me.gabreuw.springwebmvc.repository.JediRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping(path = "/api/v1/jedi")
@RequiredArgsConstructor
public class JediResource {

    private final JediRepository repository;

    @GetMapping
    public ResponseEntity<List<Jedi>> findAll() {
        return ResponseEntity
                .ok()
                .body(repository.findAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Jedi> findById(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody Jedi jedi) {
        repository.save(jedi);

        return ResponseEntity
                .status(CREATED)
                .build();
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Jedi> update(
            @PathVariable Long id,
            @Valid @RequestBody Jedi jedi
    ) {
        return repository.findById(id)
                .map(recoveredJedi -> {
                    recoveredJedi.setName(jedi.getName());
                    recoveredJedi.setLastname(jedi.getLastname());

                    return ResponseEntity
                            .ok()
                            .body(repository.save(recoveredJedi));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        repository.deleteById(id);

        return ResponseEntity
                .noContent()
                .build();
    }

}
