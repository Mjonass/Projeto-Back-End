package br.iesp.edu.api.service;

import br.iesp.edu.api.entity.Catalogo;
import br.iesp.edu.api.repository.CatalogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogoService {

    @Autowired
    private CatalogoRepository repository;

    public Catalogo salvar(Catalogo catalogo){
        catalogo = repository.save(catalogo);
        return catalogo;
    }

    public Catalogo atualizar(Catalogo catalogo){
        if(catalogo.getId()==null){
            throw new RuntimeException("ID Nulo");
        }
        catalogo = repository.save(catalogo);
        return catalogo;
    }

    public void excluir(Catalogo catalogo){
        if(catalogo.getId()==null){
            throw new RuntimeException("ID Nulo");
        }
        repository.delete(catalogo);
    }

    public void excluirPorID(Integer id){
        repository.deleteById(id);
    }

    public List<Catalogo> listarCatalago(){
        return repository.findAll();
    }






}