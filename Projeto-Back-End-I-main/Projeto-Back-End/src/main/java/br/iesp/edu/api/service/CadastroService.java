package br.iesp.edu.api.service;

import br.iesp.edu.api.TO.CartaoTO;
import br.iesp.edu.api.entity.Assinatura;
import br.iesp.edu.api.entity.Cadastro;
import br.iesp.edu.api.entity.ListaFavoritos;
import br.iesp.edu.api.repository.AssinaturaRepository;
import br.iesp.edu.api.repository.CadastroRepository;
import br.iesp.edu.api.repository.ListaFavoritosRepository;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import static br.iesp.edu.api.service.LoginService.byteToHex;

@Service
public class CadastroService {
    @Autowired
    private CadastroRepository repository;
    @Autowired
    private ListaFavoritosRepository listaFavoritosRepository;
    public Cadastro salvar(Cadastro cadastro) throws NoSuchAlgorithmException {
        if(cadastro.getSenha().equals(cadastro.getConfirmarsenha())) {

            String senha = byteToHex(cadastro.getSenha().getBytes());
            String confirmarSenha = byteToHex(cadastro.getConfirmarsenha().getBytes());
            cadastro.setSenha(senha);
            cadastro.setConfirmarsenha(confirmarSenha);

            ListaFavoritos lisfa = new ListaFavoritos();
            listaFavoritosRepository.save(lisfa);
            cadastro.setListaFavoritos(lisfa);

            Assinatura assinatura = repository.findByName(cadastro.getAssinatura().getName());
            cadastro.setAssinatura(assinatura);
            cadastro = repository.save(cadastro);

            return cadastro;
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

    public Cadastro AtualizarDadosCartao(CartaoTO cartaoTO){
        Cadastro cadastro = repository.findByEmail(cartaoTO.cliente);
        System.out.println("####################"+cadastro);
        cadastro.setNumeroCartao(cartaoTO.numeroCartao);
        cadastro.setCodigoSegurança(cartaoTO.codigoSegurança);
        cadastro.setValidadeCartao(cartaoTO.validadeCartao);

        cadastro = repository.save(cadastro);
        return cadastro;
    }
}
