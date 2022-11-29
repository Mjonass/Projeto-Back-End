package br.iesp.edu.api.resource;

import br.iesp.edu.api.callout.Callout;
import br.iesp.edu.api.entity.Caso;
import br.iesp.edu.api.service.CasoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

import static br.iesp.edu.api.callout.Callout.dataPersistenceSF;

@RestController
@RequestMapping("/caso")
public class CasoResource {
    @Autowired
    private CasoService service;

    @PostMapping("/guest")
    public Caso salvar(@RequestBody Caso caso) throws IOException {
        return service.salvar(caso);
    }

    @PutMapping("/guest")
    public Caso atualizar(@RequestBody  Caso caso){
        return service.atualizar(caso);
    }

    @DeleteMapping("/admin")
    public void excluir(@RequestBody Caso caso){
        service.excluir(caso);
    }
    @DeleteMapping("/admin/{id}")
    public void excluirPorId(@PathVariable Integer id){
        service.excluirPorID(id);
    }

    @GetMapping("admin")
    public List<Caso> listarCaso(){
        return service.listarCaso();
    }
}
