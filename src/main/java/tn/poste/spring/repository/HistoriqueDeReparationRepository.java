package tn.poste.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.poste.spring.entity.HistoriqueDeReparation;

@Repository
public interface HistoriqueDeReparationRepository extends CrudRepository<HistoriqueDeReparation,Long>{

}
