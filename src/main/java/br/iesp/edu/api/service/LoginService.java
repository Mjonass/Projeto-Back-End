package br.iesp.edu.api.service;


import br.iesp.edu.api.entity.Cadastro;
import br.iesp.edu.api.entity.Login;
import br.iesp.edu.api.repository.CadastroRepository;
import br.iesp.edu.api.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
public class LoginService {

    @Autowired
    private LoginRepository repository;
    @Autowired
    private CadastroRepository repositori;

    boolean autenticado = false;
    public String buscarCadastro(Login login){

        Cadastro cadastro = repository.findByEmail(login.getEmail());
        System.out.println("####################"+cadastro);
        if(cadastro != null){
            String s = cadastro.getSenha();
            byte[] senhadecode = Base64.getDecoder().decode(s);
            String senha = new String(senhadecode);
            if( senha.equals(login.getSenha()) ){
                autenticado = true;
                return  "Success";
            }else{
                return "Dados Invalidos";
            }
        }else{
            return "Cadastro não encontrado";
        }
    }

    public String atualizarCartao(Cadastro cadastro){
        String msg;
        if(autenticado == true ){
            System.out.println("=========passou  "+cadastro);
            cadastro = repositori.save(cadastro);
            msg = "Cadastro atualizado";
        }else{
            msg = "Cadastro não autorizado, necessario uma autenticação";
        }

        return msg;
    }

}
