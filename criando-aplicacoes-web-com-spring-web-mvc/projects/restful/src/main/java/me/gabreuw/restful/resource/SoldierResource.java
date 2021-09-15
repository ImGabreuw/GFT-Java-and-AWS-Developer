package me.gabreuw.restful.resource;

import lombok.RequiredArgsConstructor;
import me.gabreuw.restful.domain.Soldier;
import me.gabreuw.restful.dto.SoldierListResponse;
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
    public ResponseEntity<List<SoldierListResponse>> findAll() {
        List<SoldierListResponse> soldiers = service.findAll();

        return ResponseEntity
                .ok()
                .body(soldiers);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Soldier> findById(@PathVariable Long id) {
        Soldier retrievedSoldier = service.findById(id);

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

    @PutMapping(path = "/{id}")
    public ResponseEntity<Soldier> update(
            @PathVariable Long id,
            @RequestBody Soldier soldier
    ) {
        Soldier updatedSoldier = service.update(id, soldier);

        return ResponseEntity
                .ok()
                .body(updatedSoldier);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteByCpf(@PathVariable Long id) {
        service.deleteById(id);

        return ResponseEntity
                .noContent()
                .build();
    }

}
