package me.gabreuw.springwebmvc.exception;

public class JediNotFoundException extends RuntimeException {
    public JediNotFoundException(Long id) {
        super("Não foi possível encontrar um Jedi com o id: " + id);
    }
}
