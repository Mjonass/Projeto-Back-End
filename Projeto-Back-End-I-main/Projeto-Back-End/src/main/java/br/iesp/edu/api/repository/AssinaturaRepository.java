package br.iesp.edu.api.repository;

import br.iesp.edu.api.entity.Assinatura;
import br.iesp.edu.api.entity.Cadastro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AssinaturaRepository extends JpaRepository<Assinatura,Integer> {

}
