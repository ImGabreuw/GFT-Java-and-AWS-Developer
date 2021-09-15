package me.gabreuw.restful.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import me.gabreuw.restful.domain.Soldier;
import me.gabreuw.restful.dto.SoldierListResponse;
import me.gabreuw.restful.repository.SoldierRepository;
import me.gabreuw.restful.resource.SoldierRepresentationModel;
import me.gabreuw.restful.service.exception.SoldierNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Log4j2
@Service
@RequiredArgsConstructor
public class SoldierService {

    private final SoldierRepository repository;
    private final SoldierRepresentationModel soldierRepresentationModel;
    private final ObjectMapper mapper;

    public List<SoldierListResponse> findAll() {
        return repository.findAll()
                .stream()
                .map(soldierRepresentationModel::createLink)
                .collect(Collectors.toList());
    }

    public Soldier findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new SoldierNotFoundException(id));
    }

    public Soldier findByCpf(String cpf) {
        return repository.findByCpf(cpf)
                .orElseThrow(() -> new SoldierNotFoundException(cpf));
    }

    public Soldier create(Soldier soldier) {
        return repository.save(soldier);
    }

    public Soldier update(Long id, Soldier soldier) {
        Soldier retrievedSoldier = findById(id);

        retrievedSoldier.setCpf(soldier.getCpf());
        retrievedSoldier.setName(soldier.getName());
        retrievedSoldier.setTribe(soldier.getTribe());
        retrievedSoldier.setWeapon(soldier.getWeapon());

        return repository.save(soldier);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
