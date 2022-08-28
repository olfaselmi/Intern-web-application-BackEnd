package tn.poste.spring.service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;


import tn.poste.spring.entity.Bureau;


public interface IBureauService {
public List<Bureau> retrieveAllBureaux();
	
Bureau addBureau(Bureau t);

	void deleteBureau(Long idBureau);

	Bureau updateBureau(Bureau t);

	Bureau retrieveBureauById(Long idBureau);
	
	Bureau updateBureauById(Bureau t,Long idBureau);
	
	public String affecterBureautoBureauer(Long idBureau, Long idUser);
	
	List<Map<Long,Integer>> StatisticUserBureau();


	
	public int nbrBureaux();

}
