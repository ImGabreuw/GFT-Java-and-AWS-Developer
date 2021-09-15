package me.gabreuw.restful.repository;

import me.gabreuw.restful.domain.Soldier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SoldierRepository extends JpaRepository<Soldier, Long> {

    Optional<Soldier> findByCpf(String cpf);

}