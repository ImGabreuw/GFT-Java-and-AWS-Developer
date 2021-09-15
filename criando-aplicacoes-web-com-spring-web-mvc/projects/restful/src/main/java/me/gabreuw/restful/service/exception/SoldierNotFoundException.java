package me.gabreuw.restful.service.exception;

public class SoldierNotFoundException extends RuntimeException {

    public SoldierNotFoundException(Long id) {
        super("Não foi possível encontrar um soldado com o ID: " + id);
    }

    public SoldierNotFoundException(String cpf) {
        super("Não foi possível encontrar um soldado com o CPF: " + cpf);
    }
}
