package br.iesp.edu.api.repository;

import br.iesp.edu.api.entity.Caso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CasoRepository extends JpaRepository<Caso,Integer> {
}
