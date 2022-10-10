package br.iesp.edu.api.resource;


import br.iesp.edu.api.entity.Assinatura;
import br.iesp.edu.api.service.AssinaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assinatura")
public class AssinaturaResource {

    @Autowired
    private AssinaturaService service;

    @PostMapping
    public Assinatura salvar(@RequestBody Assinatura assinatura){
        return service.salvar(assinatura);
    }

    @PutMapping
    public Assinatura atualizar(@RequestBody  Assinatura assinatura){
        return service.atualizar(assinatura);
    }

    @DeleteMapping
    public void excluir(@RequestBody Assinatura assinatura){
        service.excluir(assinatura);
    }
    @DeleteMapping("/{id}")
    public void excluirPorId(@PathVariable Integer id){
        service.excluirPorID(id);
    }

    @GetMapping
    public List<Assinatura> listarCatalogo(){
        return service.listarAssinatura();
    }
}
