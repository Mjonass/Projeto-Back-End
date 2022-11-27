package br.iesp.edu.api.resource;


import br.iesp.edu.api.entity.Entreterimento;
import br.iesp.edu.api.service.EntreterimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entreterimento")
public class EntreterimentoResource {
    @Autowired
    private EntreterimentoService service;

    @PostMapping
    public Entreterimento salvar(@RequestBody Entreterimento entreterimento){
        return service.salvar(entreterimento);
    }

    @PutMapping
    public Entreterimento atualizar(@RequestBody  Entreterimento entreterimento){
        return service.atualizar(entreterimento);
    }

    @DeleteMapping
    public void excluir(@RequestBody Entreterimento assinatura){
        service.excluir(assinatura);
    }
    @DeleteMapping("/{id}")
    public void excluirPorId(@PathVariable Integer id){
        service.excluirPorID(id);
    }

    @GetMapping
    public List<Entreterimento> listarEntreterimento(){
        return service.ListarEntreterimento();
    }
}
