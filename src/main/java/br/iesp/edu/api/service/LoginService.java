package br.iesp.edu.api.service;

import br.iesp.edu.api.entity.Cadastro;
import br.iesp.edu.api.entity.Login;
import br.iesp.edu.api.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
public class LoginService {

    @Autowired
    private LoginRepository repositor;

    public String buscarCadastro(Login login){

        Cadastro cadastro = repositor.findByEmail(login.getEmail());
        System.out.println("####################"+cadastro);
        if(cadastro != null){
            String s = cadastro.getSenha();
            byte[] senhadecode = Base64.getDecoder().decode(s);
            String senha = new String(senhadecode);
            if( senha.equals(login.getSenha()) ){
                return  "Success";
            }else{
                return "Dados Invalidos";
            }
        }else{
            return "Cadastro não encontrado";
        }
    }
}
