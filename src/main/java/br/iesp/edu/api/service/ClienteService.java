package br.iesp.edu.api.service;


import br.iesp.edu.api.entity.Cliente;
import br.iesp.edu.api.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository repository;

    public Cliente salvar(Cliente cliente){
        cliente = repository.save(cliente);
        return cliente;
    }

    public Cliente atualizar(Cliente cliente){
        if(cliente.getId()==null){
            throw new RuntimeException("ID Nulo");
        }
        cliente = repository.save(cliente);
        return cliente;
    }

    public void excluir(Cliente cliente){
        if(cliente.getId()==null){
            throw new RuntimeException("ID Nulo");
        }
        repository.delete(cliente);
    }

    public void excluirPorID(Integer id){
        repository.deleteById(id);
    }

    public List<Cliente> listarCliente(){
        return repository.findAll();
    }
}
