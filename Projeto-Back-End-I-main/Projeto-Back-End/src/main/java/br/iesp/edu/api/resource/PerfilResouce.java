package br.iesp.edu.api.resource;

import br.iesp.edu.api.entity.Perfil;
import br.iesp.edu.api.service.PerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/perfil")
public class PerfilResouce {
    @Autowired
    private PerfilService service;

    @PostMapping("/user")
    public Perfil salvar(@RequestBody Perfil perfil){
        return service.salvar(perfil);
    }

    @PutMapping("/user")
    public Perfil atualizar(@RequestBody  Perfil perfil){
        return service.atualizar(perfil);
    }

    @DeleteMapping("/user")
    public void excluir(@RequestBody Perfil perfil){
        service.excluir(perfil);
    }
    @DeleteMapping("/user/{id}")
    public void excluirPorId(@PathVariable Integer id){
        service.excluirPorID(id);
    }

    @GetMapping
    @PreAuthorize("ADMIN")
    public List<Perfil> listarPerfil(){
        return service.listarPerfil();
    }
}
