package me.gabreuw.padroesdeprojetospring.controller;

import lombok.RequiredArgsConstructor;
import me.gabreuw.padroesdeprojetospring.model.Cliente;
import me.gabreuw.padroesdeprojetospring.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping(path = "/clientes")
@RequiredArgsConstructor
public class ClienteRestController {

    private final ClienteService clienteService;

    @GetMapping
    public ResponseEntity<Iterable<Cliente>> buscarTodos() {
        return ResponseEntity
                .ok()
                .body(clienteService.buscarTodos());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable Long id) {
        return ResponseEntity
                .ok()
                .body(clienteService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Cliente> inserir(@RequestBody Cliente cliente) {
        clienteService.inserir(cliente);

        return ResponseEntity
                .status(CREATED)
                .body(cliente);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Cliente> atualizar(@PathVariable Long id, @RequestBody Cliente cliente) {
        clienteService.atualizar(cliente);

        return ResponseEntity
                .ok()
                .body(cliente);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        clienteService.deletar(id);

        return ResponseEntity
                .noContent()
                .build();
    }

}
