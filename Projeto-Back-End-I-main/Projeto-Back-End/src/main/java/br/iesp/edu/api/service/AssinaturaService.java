package br.iesp.edu.api.service;

import br.iesp.edu.api.entity.Assinatura;
import br.iesp.edu.api.repository.AssinaturaRepository;
import br.iesp.edu.api.repository.CatalogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssinaturaService {

    @Autowired
    private AssinaturaRepository repository;

    public Assinatura salvar(Assinatura assinatura){
        assinatura = repository.save(assinatura);
        return assinatura;
    }

    public Assinatura atualizar(Assinatura assinatura){
        if(assinatura.getId()==null){
            throw new RuntimeException("ID Nulo");
        }
        assinatura = repository.save(assinatura);
        return assinatura;
    }

    public void excluir(Assinatura assinatura){
        if(assinatura.getId()==null){
            throw new RuntimeException("ID Nulo");
        }
        repository.delete(assinatura);
    }

    public void excluirPorID(Integer id){
        repository.deleteById(id);
    }

    public List<Assinatura> listarAssinatura(){
        return repository.findAll();
    }
}
