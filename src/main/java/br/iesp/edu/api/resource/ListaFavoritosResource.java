package br.iesp.edu.api.resource;


import br.iesp.edu.api.TO.InputListTO;
import br.iesp.edu.api.entity.ListaFavoritos;
import br.iesp.edu.api.service.ListaFavoritosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ListaFavorito")
public class ListaFavoritosResource {

    @Autowired
    private ListaFavoritosService service;

    @PutMapping("/teste")
    public ListaFavoritos addList(@RequestBody InputListTO listTO){
        return service.addList(listTO);
    }

    @PutMapping
    public ListaFavoritos atualizar(@RequestBody  ListaFavoritos listaFavoritos){
        return service.atualizar(listaFavoritos);
    }

    @DeleteMapping
    public void excluir(@RequestBody ListaFavoritos listaFavoritos){
        service.excluir(listaFavoritos);
    }

    @DeleteMapping("/{id}")
    public void excluirPorId(@PathVariable Integer id){
        service.excluirPorID(id);
    }

    @GetMapping
    public List<ListaFavoritos> ListarFavoritos(){
        return service.ListarFavoritos();
    }
}
