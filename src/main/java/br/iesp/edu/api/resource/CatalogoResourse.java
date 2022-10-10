package br.iesp.edu.api.resource;

import br.iesp.edu.api.entity.Catalogo;
import br.iesp.edu.api.service.CatalogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/catalago")
public class CatalogoResourse {

    @Autowired
    private CatalogoService service;

    @PostMapping
    public Catalogo salvar(@RequestBody Catalogo catalogo){
        return service.salvar(catalogo);
    }

    @PutMapping
    public Catalogo atualizar(@RequestBody  Catalogo catalogo){
        return service.atualizar(catalogo);
    }

    @DeleteMapping
    public void excluir(@RequestBody Catalogo catalogo){
        service.excluir(catalogo);
    }
    @DeleteMapping("/{id}")
    public void excluirPorId(@PathVariable Integer id){
        service.excluirPorID(id);
    }

    @GetMapping
    public List<Catalogo> listarCatalogo(){
        return service.listarCatalago();
    }


}
