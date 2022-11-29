package br.iesp.edu.api.repository;

import br.iesp.edu.api.entity.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerfilRepository extends JpaRepository<Perfil,Integer> {
}
