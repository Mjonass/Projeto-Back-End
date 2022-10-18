package br.iesp.edu.api.service;

import br.iesp.edu.api.entity.Cadastro;
import br.iesp.edu.api.repository.CadastroRepository;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
public class CadastroService {
    @Autowired
    private CadastroRepository repository;

    public Cadastro salvar(Cadastro cadastro) throws NoSuchAlgorithmException {
        if(cadastro.getSenha().equals(cadastro.getConfirmarsenha())){

            String senha = new Base64().encodeToString(cadastro.getSenha().getBytes());
            String confirmarSenha = new Base64().encodeToString(cadastro.getConfirmarsenha().getBytes());

            cadastro.setSenha(senha);
            cadastro.setConfirmarsenha(confirmarSenha);

            cadastro = repository.save(cadastro);

        }else {
            throw new RuntimeException("Senhas não correspondem");
        }
        return cadastro;

    }

    public Cadastro atualizar(Cadastro cadastro){
        if(cadastro.getId() == null){
            throw new RuntimeException("ID Nulo");
        }
        cadastro = repository.save(cadastro);
        return cadastro;
    }

    public void excluir(Cadastro cadastro){
        if(cadastro.getId()==null){
            throw new RuntimeException("ID Nulo");
        }
        repository.delete(cadastro);
    }

    public void excluirPorID(Integer id){

        repository.deleteById(id);
    }

    public List<Cadastro> listarCadastro(){
        return repository.findAll();
    }
}
