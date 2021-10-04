package me.gabreuw.padroesdeprojetospring.service;

import me.gabreuw.padroesdeprojetospring.model.Cliente;

public interface ClienteService {

    Iterable<Cliente> buscarTodos();

    Cliente buscarPorId(Long id);

    void inserir(Cliente cliente);

    void atualizar(Cliente cliente);

    void deletar(Long id);

}
