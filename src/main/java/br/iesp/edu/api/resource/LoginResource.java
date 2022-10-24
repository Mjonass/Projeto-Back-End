package br.iesp.edu.api.resource;

import br.iesp.edu.api.entity.Login;
import br.iesp.edu.api.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
