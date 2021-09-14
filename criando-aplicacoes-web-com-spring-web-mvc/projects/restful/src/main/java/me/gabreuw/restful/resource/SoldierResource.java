package me.gabreuw.restful.resource;

import lombok.RequiredArgsConstructor;
import me.gabreuw.restful.domain.Soldier;
import me.gabreuw.restful.service.SoldierService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping(path = "/api/v1/soldiers")
@RequiredArgsConstructor
public class SoldierResource {

    private final SoldierService service;

    @GetMapping
    public ResponseEntity<List<Soldier>> findAll() {
        List<Soldier> soldiers = service.findAll();

        return ResponseEntity
                .ok()
                .body(soldiers);
    }

    @GetMapping(path = "/{cpf}")
    public ResponseEntity<Soldier> findByCpf(@PathVariable String cpf) {
        Soldier retrievedSoldier = service.findByCpf(cpf);

        return ResponseEntity
                .ok()
                .body(retrievedSoldier);
    }

    @PostMapping
    public ResponseEntity<Soldier> create(@RequestBody Soldier soldier) {
        Soldier savedSoldier = service.create(soldier);

        return ResponseEntity
                .status(CREATED)
                .body(savedSoldier);
    }

    @PutMapping(path = "/{cpf}")
    public ResponseEntity<Soldier> update(
            @PathVariable String cpf,
            @RequestBody Soldier soldier
    ) {
        Soldier updatedSoldier = service.update(cpf, soldier);

        return ResponseEntity
                .ok()
                .body(updatedSoldier);
    }

    @DeleteMapping(path = "/{cpf}")
    public ResponseEntity<Void> deleteByCpf(@PathVariable String cpf) {
        service.deleteByCpf(cpf);

        return ResponseEntity
                .noContent()
                .build();
    }

}
