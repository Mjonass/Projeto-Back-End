package br.iesp.edu.api.resource;

import br.iesp.edu.api.TO.CartaoTO;
import br.iesp.edu.api.callout.Callout;
import br.iesp.edu.api.entity.Cadastro;
import br.iesp.edu.api.service.CadastroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@RestController
@RequestMapping("/cadastro")
public class CadastroResouce {
    @Autowired
    private CadastroService service;

    @PostMapping("/guest")
    public Cadastro salvar(@RequestBody Cadastro cadastro) throws NoSuchAlgorithmException, IOException {
        Callout.sendEmail(cadastro.getEmail(),cadastro.getAssinatura().getPreco__c());
        return service.salvar(cadastro);
    }

    @PutMapping("/user")
    public Cadastro atualizar(@RequestBody Cadastro cadastro){
        return service.atualizar(cadastro);
    }

    @DeleteMapping("/user")
    public void excluir(@RequestBody Cadastro cadastro){
        service.excluir(cadastro);
    }

    @DeleteMapping("/{id}")
    public void excluirPorId(@PathVariable Integer Id){
        service.excluirPorID(Id);
    }

    @GetMapping("/admin/listarTodos")
    public List<Cadastro> listarCadastro(){
        return service.listarCadastro();
    }

    @PutMapping("/user/atualizarDadosCartao")
    public Cadastro AtualizarDadosCartao(@RequestBody CartaoTO CartaoTO){
        return service.AtualizarDadosCartao(CartaoTO);
    }


}
