package me.gabreuw.springwebmvc.repository;

import me.gabreuw.springwebmvc.model.Jedi;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JediRepository extends JpaRepository<Jedi, Long> {}