package br.iesp.edu.api.service;

import br.iesp.edu.api.entity.Caso;
import br.iesp.edu.api.repository.CasoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CasoService {
    @Autowired
    private CasoRepository repository;

    public Caso salvar(Caso caso){
        caso = repository.save(caso);
        return caso;
    }

    public Caso atualizar(Caso caso){
        if(caso.getId()==null){
            throw new RuntimeException("ID Nulo");
        }
        caso = repository.save(caso);
        return caso;
    }

    public void excluir(Caso caso){
        if(caso.getId()==null){
            throw new RuntimeException("ID Nulo");
        }
        repository.delete(caso);
    }

    public void excluirPorID(Integer id){
        repository.deleteById(id);
    }

    public List<Caso> listarCaso(){
        return repository.findAll();
    }
}
