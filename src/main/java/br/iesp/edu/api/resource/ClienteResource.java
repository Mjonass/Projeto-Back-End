package br.iesp.edu.api.resource;

import br.iesp.edu.api.entity.Cliente;
import br.iesp.edu.api.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteResource {

    @Autowired
    private ClienteService service;

    @PostMapping
    public Cliente salvar(@RequestBody Cliente cliente){
        return service.salvar(cliente);
    }

    @PutMapping
    public Cliente atualizar(@RequestBody  Cliente cliente){
        return service.atualizar(cliente);
    }

    @DeleteMapping
    public void excluir(@RequestBody Cliente Cliente){
        service.excluir(Cliente);
    }
    @DeleteMapping("/{id}")
    public void excluirPorId(@PathVariable Integer id){
        service.excluirPorID(id);
    }

    @GetMapping
    public List<Cliente> listarCliente(){
        return service.listarCliente();
    }
}
