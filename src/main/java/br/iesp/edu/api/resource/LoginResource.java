package br.iesp.edu.api.resource;

import br.iesp.edu.api.entity.Cadastro;
import br.iesp.edu.api.entity.Login;
import br.iesp.edu.api.service.CadastroService;
import br.iesp.edu.api.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping("/login")
public class LoginResource {
    @Autowired
    private LoginService service;

    @PostMapping
    public String buscarCadastro(@RequestBody Login login)throws NoSuchAlgorithmException {
        return service.buscarCadastro(login);
    }

}
