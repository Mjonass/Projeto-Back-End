package br.iesp.edu.api.service;


import br.iesp.edu.api.TO.InputListTO;
import br.iesp.edu.api.entity.Cadastro;
import br.iesp.edu.api.entity.Entreterimento;
import br.iesp.edu.api.entity.ListaFavoritos;
import br.iesp.edu.api.repository.CadastroRepository;
import br.iesp.edu.api.repository.EntreterimentoRepository;
import br.iesp.edu.api.repository.ListaFavoritosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ListaFavoritosService {
    @Autowired
    private ListaFavoritosRepository repository;
    @Autowired
    private EntreterimentoRepository entreterimentoRepository;
    @Autowired
    private CadastroRepository cadastroRepository;


    public ListaFavoritos addList(InputListTO inputListTO){

        Entreterimento entreterimento = entreterimentoRepository.findByTitulo(inputListTO.idEntreterimento);
        Cadastro cadastro = cadastroRepository.findByEmail(inputListTO.idCliente);
        List<Entreterimento> entreterimento1 = cadastro.getListaFavoritos().getEntreterimento();
        entreterimento1.add(entreterimento);
        cadastro.getListaFavoritos().setEntreterimento(entreterimento1);
        repository.save(cadastro.getListaFavoritos());


        return cadastro.getListaFavoritos();
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
