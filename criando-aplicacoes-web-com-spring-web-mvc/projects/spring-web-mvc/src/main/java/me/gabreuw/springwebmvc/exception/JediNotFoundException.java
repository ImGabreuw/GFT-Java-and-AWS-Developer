package me.gabreuw.springwebmvc.exception;

public class JediNotFoundException extends RuntimeException {
    public JediNotFoundException(Integer id) {
        super("Não foi possível encontrar um Jedi com o id: " + id);
    }
}
