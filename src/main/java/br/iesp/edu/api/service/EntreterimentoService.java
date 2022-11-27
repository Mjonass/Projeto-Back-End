package br.iesp.edu.api.service;

import br.iesp.edu.api.entity.Entreterimento;
import br.iesp.edu.api.entity.ListaFavoritos;
import br.iesp.edu.api.repository.EntreterimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntreterimentoService {
    @Autowired
    private EntreterimentoRepository repository;

    public Entreterimento salvar(Entreterimento entreterimento){
        entreterimento = repository.save(entreterimento);
        return entreterimento;
    }

    public Entreterimento atualizar(Entreterimento entreterimento){
        if(entreterimento.getId()==null){
            throw new RuntimeException("ID Nulo");
        }
        entreterimento = repository.save(entreterimento);
        return entreterimento;
    }

    public void excluir(Entreterimento entreterimento){
        if(entreterimento.getId()==null){
            throw new RuntimeException("ID Nulo");
        }
        repository.delete(entreterimento);
    }

    public void excluirPorID(Integer id){
        repository.deleteById(id);
    }

    public List<Entreterimento> ListarEntreterimento(){
        return repository.findAll();
    }
}
