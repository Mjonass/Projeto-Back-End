package br.iesp.edu.api.repository;


import br.iesp.edu.api.entity.Cadastro;
import br.iesp.edu.api.entity.Entreterimento;
import br.iesp.edu.api.entity.ListaFavoritos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ListaFavoritosRepository extends JpaRepository<ListaFavoritos,Integer> {

}
