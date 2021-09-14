package me.gabreuw.springwebmvc.config;

import lombok.RequiredArgsConstructor;
import me.gabreuw.springwebmvc.model.Jedi;
import me.gabreuw.springwebmvc.repository.JediRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class Initialization implements CommandLineRunner {

    private final JediRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.save(
                new Jedi(1L, "Luke", "Skywalker")
        );
    }

}
