package br.iesp.edu.api.service;

import br.iesp.edu.api.entity.Cadastro;
import br.iesp.edu.api.repository.CadastroRepository;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
public class CadastroService {
    @Autowired
    private CadastroRepository repository;

    public Cadastro salvar(Cadastro cadastro) throws NoSuchAlgorithmException {
        if(cadastro.getSenha().equals(cadastro.getConfirmarsenha())){



            String senha = byteToHex(cadastro.getSenha().getBytes());
            String confirmarSenha = byteToHex(cadastro.getConfirmarsenha().getBytes());

            cadastro.setSenha(senha);
            cadastro.setConfirmarsenha(confirmarSenha);

            cadastro = repository.save(cadastro);

        }else {
            throw new RuntimeException("Senhas não correspondem");
        }
        return cadastro;

    }
    public static byte[] getHash(String password) throws NoSuchAlgorithmException{
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        byte[] hash;
        return hash = messageDigest.digest(password.getBytes(StandardCharsets.UTF_8));
    }
    public static String byteToHex(byte[] hash) {
        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(255 & hash[i]);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        System.out.println(hexString);
        return hexString.toString();
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
