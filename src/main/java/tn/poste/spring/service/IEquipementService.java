package tn.poste.spring.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import tn.poste.spring.entity.Equipements;

public interface IEquipementService {
	Equipements addEquipement( Equipements c);
	 
	 
		List<Equipements> retrieveAllEquipement();
		void deleteEquipement(Long id);
		Equipements updateEquipement(Equipements c);
	 
		Equipements updateEquipementBySN(Equipements o,Long idEq);
		
		
		Page<Equipements> findByCodeabarre(String Codeabarre, Pageable pageable);

		void EquipementCheck(Long idEq);
		
		Boolean badWords(Equipements c);


		List<Equipements> retrieveAllEquipementpdf();
		
		
		 
}
