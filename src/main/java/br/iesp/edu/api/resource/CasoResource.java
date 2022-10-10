package br.iesp.edu.api.resource;

import br.iesp.edu.api.entity.Caso;
import br.iesp.edu.api.service.CasoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/caso")
public class CasoResource {
    @Autowired
    private CasoService service;

    @PostMapping
    public Caso salvar(@RequestBody Caso caso){
        return service.salvar(caso);
    }

    @PutMapping
    public Caso atualizar(@RequestBody  Caso caso){
        return service.atualizar(caso);
    }

    @DeleteMapping
    public void excluir(@RequestBody Caso caso){
        service.excluir(caso);
    }
    @DeleteMapping("/{id}")
    public void excluirPorId(@PathVariable Integer id){
        service.excluirPorID(id);
    }

    @GetMapping
    public List<Caso> listarCaso(){
        return service.listarCaso();
    }
}
