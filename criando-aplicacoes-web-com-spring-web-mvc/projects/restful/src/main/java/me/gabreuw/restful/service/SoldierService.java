package me.gabreuw.restful.service;

import lombok.extern.log4j.Log4j2;
import me.gabreuw.restful.domain.Soldier;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
public class SoldierService {

    public List<Soldier> findAll() {
        return List.of(
                new Soldier(
                        "123456789",
                        "Legolas",
                        "Elfo",
                        "Arco e flecha"
                ),
                new Soldier(
                        "987654321",
                        "Ricardo",
                        "Humano",
                        "Espada"
                )
        );
    }

    public Soldier findByCpf(String cpf) {
        return new Soldier(
                cpf,
                "Legolas",
                "Elfo",
                "Arco e flecha"
        );
    }

    public Soldier create(Soldier soldier) {
        log.info("Soldado salvo com sucesso! {}", soldier);
        return soldier;
    }

    public Soldier update(String cpf, Soldier soldier) {
        Soldier retrievedSoldier = findByCpf(cpf);

        retrievedSoldier.setCpf(cpf);
        retrievedSoldier.setName(soldier.getName());
        retrievedSoldier.setTribe(soldier.getTribe());
        retrievedSoldier.setWeapon(soldier.getWeapon());

        log.info("Soldado, com o CPF {}, foi atualizado com sucesso! {}", cpf, soldier);

        return retrievedSoldier;
    }

    public void deleteByCpf(String cpf) {
        log.info("Soldado, com o CPF {}, deletado com sucesso!", cpf);
    }
}
