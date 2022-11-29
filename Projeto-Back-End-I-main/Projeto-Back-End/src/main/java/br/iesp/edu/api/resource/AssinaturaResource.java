package br.iesp.edu.api.resource;


import br.iesp.edu.api.callout.Callout;
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

    @PostMapping(path = "/admin")
    public Assinatura salvar(@RequestBody Assinatura assinatura) throws Exception {
        String id = Callout.dataPersistenceSF(assinatura,"POST");
        assinatura.setIdSalesForce(id);
        return service.salvar(assinatura);
    }

    @PutMapping(path = "/admin")
    public Assinatura atualizar(@RequestBody  Assinatura assinatura){
        return service.atualizar(assinatura);
    }

    @DeleteMapping(path = "admin")
    public void excluir(@RequestBody Assinatura assinatura){
        service.excluir(assinatura);
    }
    @DeleteMapping("/admin/{id}")
    public void excluirPorId(@PathVariable Integer id){
        service.excluirPorID(id);
    }

    @GetMapping("/guest")
    public List<Assinatura> listarCatalogo(){
        return service.listarAssinatura();
    }
}
