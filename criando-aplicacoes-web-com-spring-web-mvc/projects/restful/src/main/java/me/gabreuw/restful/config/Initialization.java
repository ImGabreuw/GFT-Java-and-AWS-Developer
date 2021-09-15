package me.gabreuw.restful.config;

import lombok.RequiredArgsConstructor;
import me.gabreuw.restful.domain.Soldier;
import me.gabreuw.restful.repository.SoldierRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class Initialization implements CommandLineRunner {

    private final SoldierRepository repository;

    @Override
    public void run(String... args) throws Exception {
        List<Soldier> mockSoldiers = List.of(
                new Soldier(
                        1L,
                        "123456789",
                        "Legolas",
                        "Elfo",
                        "Arco e flecha",
                        "Vivo"
                ),
                new Soldier(
                        2L,
                        "987654321",
                        "Ricardo",
                        "Humano",
                        "Espada",
                        "Morto"
                )
        );

        repository.saveAll(mockSoldiers);
    }

}
