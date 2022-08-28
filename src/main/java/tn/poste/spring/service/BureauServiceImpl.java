package tn.poste.spring.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tn.poste.spring.entity.*;
import tn.poste.spring.entity.User;
import tn.poste.spring.mail.EmailControllers;
import tn.poste.spring.repository.*;
@Service
public class BureauServiceImpl implements IBureauService{

	@Autowired 
	BureauRepository BureauRepo;
	@Autowired 
	UserRepository userRepo;
	@Autowired 
	EmailControllers mailController;
	
	
	
	@Override
	public List<Bureau> retrieveAllBureaux() {
		
		return (List<Bureau>) BureauRepo.findAll();
	}


	@Override
	public Bureau addBureau(Bureau t) {
		// TODO Auto-generated method stub
		return BureauRepo.save(t);
	}
	

	@Override
	public void deleteBureau(Long idBureau) {
		BureauRepo.deleteById(idBureau);
		
	}

	@Override
	public Bureau updateBureau(Bureau t) {
		
		return BureauRepo.save(t);
	}

	@Override
	public Bureau retrieveBureauById(Long idBureau) {

		return BureauRepo.findById(idBureau).orElse(null);
	}

	@Override
	public Bureau updateBureauById(Bureau t,Long idBureau) {
	
		Bureau found= BureauRepo.findById(idBureau).orElse(null);
		found.setAdresse(t.getAdresse());
		found.setCodePostale(t.getCodePostale());
		found.setNomAgence(t.getNomAgence());
		found.setPositionGPS(t.getPositionGPS());
		found.setTypeDeStructure(t.getTypeDeStructure());
		found.setUser(t.getUser());
	    BureauRepo.saveAndFlush(found);
		return found;
	}

	@Override
	public String affecterBureautoBureauer(Long idBureau, Long idUser) {
		
		User user= userRepo.findById(idUser).orElse(null);
		String mailt = user.getEmail();
		 Bureau t = BureauRepo.getById(idBureau);
		if (user.getRole().toString().equals("Bureauer")) 
		{
	user.getBureau().add(t);
		userRepo.save(user); 
	    mailController.ApplicationMail(mailt,t.getPositionGPS(),user.getName());
		
		}
		else {
			
	System.out.print("Bureau belong onely to Bureauer");
		
		}
				
		return "done!";
		
	}



	@Override
	public List<Map<Long, Integer>> StatisticUserBureau() {
		// TODO Auto-generated method stub
		return BureauRepo.statistics();
	}

	@Override
	public int nbrBureaux() {
		return BureauRepo.nbBureaux();
	}



	

	

	
}
