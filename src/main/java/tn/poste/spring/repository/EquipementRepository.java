package tn.poste.spring.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


import tn.poste.spring.entity.Equipements;
@Repository
public interface EquipementRepository extends PagingAndSortingRepository<Equipements, Long>{
	
	
	Page<Equipements> findByCodeabarre(String Codeabarre, Pageable pageable);
    
	
	//@Query(value="SELECT * FROM Equipements ORDER BY DATE",  nativeQuery = true)
	//public List<Equipements> trierParDate();
	
	
	//@Query(value="SELECT * FROM Equipements WHERE ETAT=?1", nativeQuery = true )
	//public List<Equipements> filterEquipements(Boolean etat);
}