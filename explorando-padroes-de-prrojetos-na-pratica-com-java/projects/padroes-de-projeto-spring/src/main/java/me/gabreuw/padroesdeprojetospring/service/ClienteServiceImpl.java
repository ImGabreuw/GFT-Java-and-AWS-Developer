package me.gabreuw.padroesdeprojetospring.service;

import lombok.RequiredArgsConstructor;
import me.gabreuw.padroesdeprojetospring.model.Cliente;
import me.gabreuw.padroesdeprojetospring.model.Endereco;
import me.gabreuw.padroesdeprojetospring.repository.ClienteRepository;
import me.gabreuw.padroesdeprojetospring.repository.EnderecoRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;
    private final EnderecoRepository enderecoRepository;
    private final ViaCepService viaCepService;

    @Override
    public Iterable<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscarPorId(Long id) {
        return clienteRepository
                .findById(id)
                .get();
    }

    @Override
    public void inserir(Cliente cliente) {
        salverClienteComCep(cliente);
    }

    @Override
    public void atualizar(Cliente cliente) {
        clienteRepository
                .findById(cliente.getId())
                .ifPresent(this::salverClienteComCep);
    }

    @Override
    public void deletar(Long id) {
        clienteRepository.deleteById(id);
    }

    private void salverClienteComCep(Cliente cliente) {
        String cep = cliente.getEndereco().getCep();

        Endereco endereco = enderecoRepository
                .findById(cep)
                .orElseGet(() -> {
                    Endereco novoEndereco = viaCepService.consultarCep(cep);

                    return enderecoRepository.save(novoEndereco);
                });

        cliente.setEndereco(endereco);

        clienteRepository.save(cliente);
    }

}
