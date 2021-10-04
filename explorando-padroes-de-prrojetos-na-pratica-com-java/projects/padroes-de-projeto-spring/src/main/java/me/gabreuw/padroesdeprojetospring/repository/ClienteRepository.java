package me.gabreuw.padroesdeprojetospring.repository;

import me.gabreuw.padroesdeprojetospring.model.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {}
