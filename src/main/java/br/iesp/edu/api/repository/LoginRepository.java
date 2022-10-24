package br.iesp.edu.api.repository;

import br.iesp.edu.api.entity.Cadastro;
import br.iesp.edu.api.entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<Login,String> {
    @Query(value ="SELECT * FROM Cadastro c where c.email = email",nativeQuery = true)
    Cadastro findByEmail(String email);

}
