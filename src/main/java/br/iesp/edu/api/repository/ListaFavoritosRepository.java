package br.iesp.edu.api.repository;

import br.iesp.edu.api.entity.ListaFavoritos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListaFavoritosRepository extends JpaRepository<ListaFavoritos,Integer> {
}
