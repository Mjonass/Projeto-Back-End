package br.iesp.edu.api.repository;

import br.iesp.edu.api.entity.Catalogo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatalogoRepository extends JpaRepository<Catalogo,Integer> {

}
