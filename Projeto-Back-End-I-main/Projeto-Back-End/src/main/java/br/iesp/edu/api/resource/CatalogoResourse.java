package br.iesp.edu.api.resource;

import br.iesp.edu.api.callout.Callout;
import br.iesp.edu.api.entity.Catalogo;
import br.iesp.edu.api.service.CatalogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/catalago")
public class CatalogoResourse {

    @Autowired
    private CatalogoService service;

    @PostMapping("/admin")
    public Catalogo salvar(@RequestBody Catalogo catalogo) throws Exception {

        try {
            Callout.dataPersistenceSF(catalogo,"POST");
            return service.salvar(catalogo);
        }catch (Exception e){
            throw new Exception(e.getMessage());


        }


    }

    @PutMapping("admin")
    public Catalogo atualizar(@RequestBody  Catalogo catalogo){
        return service.atualizar(catalogo);
    }

    @DeleteMapping("admin")
    public void excluir(@RequestBody Catalogo catalogo){
        service.excluir(catalogo);
    }
    @DeleteMapping("/admin/{id}")
    public void excluirPorId(@PathVariable Integer id){
        service.excluirPorID(id);
    }

    @GetMapping("/admin")
    public List<Catalogo> listarCatalogo(){
        return service.listarCatalago();
    }


}
