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

    @PostMapping("admin")
    public Entreterimento salvar(@RequestBody Entreterimento entreterimento){
        return service.salvar(entreterimento);
    }

    @PutMapping("admin")
    public Entreterimento atualizar(@RequestBody  Entreterimento entreterimento){
        return service.atualizar(entreterimento);
    }

    @DeleteMapping("admin")
    public void excluir(@RequestBody Entreterimento assinatura){
        service.excluir(assinatura);
    }

    @DeleteMapping("admin/{id}")
    public void excluirPorId(@PathVariable Integer id){
        service.excluirPorID(id);
    }

    @GetMapping("guest")
    public List<Entreterimento> listarEntreterimento(){
        return service.ListarEntreterimento();
    }
}
