package me.gabreuw.springwebmvc.rest;

import lombok.RequiredArgsConstructor;
import me.gabreuw.springwebmvc.model.Jedi;
import me.gabreuw.springwebmvc.repository.JediRepository;
import me.gabreuw.springwebmvc.service.JediService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping(path = "/api/v1/jedi")
@RequiredArgsConstructor
public class JediResource {

    private final JediService service;

    @GetMapping
    public ResponseEntity<List<Jedi>> findAll() {
        return ResponseEntity
                .ok()
                .body(service.findAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Jedi> findById(@PathVariable Long id) {
        Jedi recoveredJedi = service.findById(id);

        return ResponseEntity
                .ok()
                .body(recoveredJedi);
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody Jedi jedi) {
        service.save(jedi);

        return ResponseEntity
                .status(CREATED)
                .build();
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Jedi> update(
            @PathVariable Long id,
            @Valid @RequestBody Jedi jedi
    ) {
        Jedi updatedJedi = service.update(id, jedi);

        return ResponseEntity
                .ok()
                .body(updatedJedi);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);

        return ResponseEntity
                .noContent()
                .build();
    }

}
