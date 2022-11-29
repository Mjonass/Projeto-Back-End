package br.iesp.edu.api.repository;

import br.iesp.edu.api.entity.Assinatura;
import br.iesp.edu.api.entity.Cadastro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CadastroRepository extends JpaRepository<Cadastro,Integer> {
    @Query(value ="SELECT a FROM Assinatura a where a.name =:name")
    Assinatura findByName(String name);

    @Query(value ="SELECT c FROM Cadastro c where c.email =:idCliente")
    Cadastro findByEmail(String idCliente);
}
