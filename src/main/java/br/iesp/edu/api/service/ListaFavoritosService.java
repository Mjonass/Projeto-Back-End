package br.iesp.edu.api.service;

import br.iesp.edu.api.entity.ListaFavoritos;
import br.iesp.edu.api.repository.ListaFavoritosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListaFavoritosService {
    @Autowired
    private ListaFavoritosRepository repository;


    public ListaFavoritos salvar(ListaFavoritos listaFavoritos){
        listaFavoritos = repository.save(listaFavoritos);
        return listaFavoritos;
    }

    public ListaFavoritos atualizar(ListaFavoritos listaFavoritos){
        if(listaFavoritos.getId()==null){
            throw new RuntimeException("ID Nulo");
        }
        listaFavoritos = repository.save(listaFavoritos);
        return listaFavoritos;
    }

    public void excluir(ListaFavoritos listaFavoritos){
        if(listaFavoritos.getId()==null){
            throw new RuntimeException("ID Nulo");
        }
        repository.delete(listaFavoritos);
    }

    public void excluirPorID(Integer id){
        repository.deleteById(id);
    }

    public List<ListaFavoritos> ListarFavoritos(){
        return repository.findAll();
    }
}
