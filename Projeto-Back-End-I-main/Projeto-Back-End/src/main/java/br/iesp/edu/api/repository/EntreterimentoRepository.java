package br.iesp.edu.api.repository;


import br.iesp.edu.api.entity.Entreterimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EntreterimentoRepository extends JpaRepository<Entreterimento,Integer> {
    @Query(value ="SELECT e FROM Entreterimento e where e.titulo =:idEntreterimento")
    Entreterimento findByTitulo(String idEntreterimento);
}
