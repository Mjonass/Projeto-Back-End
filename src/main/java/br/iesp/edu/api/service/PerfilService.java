package br.iesp.edu.api.service;

import br.iesp.edu.api.entity.Cliente;
import br.iesp.edu.api.entity.Perfil;
import br.iesp.edu.api.repository.ClienteRepository;
import br.iesp.edu.api.repository.PerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerfilService {
    @Autowired
    private PerfilRepository repository;

    public Perfil salvar(Perfil perfil){
        perfil = repository.save(perfil);
        return perfil;
    }

    public Perfil atualizar(Perfil perfil){
        if(perfil.getId()==null){
            throw new RuntimeException("ID Nulo");
        }
        perfil = repository.save(perfil);
        return perfil;
    }

    public void excluir(Perfil perfil){
        if(perfil.getId()==null){
            throw new RuntimeException("ID Nulo");
        }
        repository.delete(perfil);
    }

    public void excluirPorID(Integer id){
        repository.deleteById(id);
    }

    public List<Perfil> listarPerfil(){
        return repository.findAll();
    }
}
