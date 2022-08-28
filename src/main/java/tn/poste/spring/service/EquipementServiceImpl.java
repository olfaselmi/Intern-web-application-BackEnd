package tn.poste.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import tn.poste.spring.entity.User;
import tn.poste.spring.entity.Equipements;
import tn.poste.spring.repository.EquipementRepository;
import tn.poste.spring.repository.UserRepository;


@Service
public class EquipementServiceImpl implements IEquipementService {
	@Autowired
	EquipementRepository repository;
	@Autowired
	UserRepository ur;
	@Override
	public Equipements addEquipement(Equipements c) {
	
	
	
		repository.save(c);
		
		return c;
	}

	@Override
	public List<Equipements> retrieveAllEquipement() {
		return (List<Equipements>) repository.findAll();
	}

	@Override
	public void deleteEquipement(Long id) {
		repository.deleteById(id);		
	}

	@Override
	public Equipements updateEquipement(Equipements c) {
		return repository.save(c);
	}

	@Override
	public Equipements updateEquipementBySN(Equipements o, Long idEq) {
		Equipements cl= repository.findById(idEq).orElse(null);
		
		

		cl.setNature(o.getNature());
		cl.setMarque(o.getMarque());
		cl.setCodeabarre(o.getCodeabarre());
		cl.setDiagnostic(o.getDiagnostic());
		cl.setDate_Affectation(o.getDate_Affectation());

		//repository.saveAndFlush(cl);



		return cl;
	}

	@Override
	public Page<Equipements> findByCodeabarre(String Codeabarre, Pageable pageable) {
		return repository.findByCodeabarre(Codeabarre, pageable);
	}

	@Override
	public void EquipementCheck(Long idEq) {
		Equipements c=repository.findById(idEq).get();	
        repository.save(c);
		
	}

	@Override
public Boolean badWords(Equipements c) {
		String CodeaBarre = c.getCodeabarre();
		 List<String >bw= new ArrayList<String>();
		 bw.add("fuck");
		 bw.add("shit");

        for(String i:bw)
        {
       	 if (CodeaBarre.contains(i)){
       		 return false;
       	 }
        }
       	 
		return true;
	}

	@Override
	public List<Equipements> retrieveAllEquipementpdf() {
		return (List<Equipements>)repository.findAll();
	}

	
	

}
