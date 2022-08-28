package tn.poste.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.poste.spring.entity.Equipements;
import tn.poste.spring.repository.EquipementRepository;
import tn.poste.spring.service.IEquipementService;
@CrossOrigin(origins = "*", allowedHeaders = "*")

@RestController 
@RequestMapping("/Equipements")

public class EquipementsRestController {
	@Autowired 
	IEquipementService cs;

	@Autowired
	EquipementRepository cr;
	
	
	
	
	@GetMapping("/get-all-Equipements")
	@ResponseBody
	public List<Equipements> getAllEquipements()
	{
		List<Equipements> listEquipements = cs.retrieveAllEquipement();	
		return listEquipements; 	
	}
	
	/*@GetMapping("/filterByState/{state}")
	@ResponseBody
	public List<Equipements> filterEquipements(@PathVariable("state") Boolean state)
	{
		List<Equipements> listEquipements = cr.filterEquipements(state);	
		return listEquipements; 	
	}
	
	
	@GetMapping("/trierParDate")
	@ResponseBody
	public List<Equipements> trierParDate()
	{
		List<Equipements> listEquipements = cr.trierParDate();	
		return listEquipements; 	
	}
	
	*/
	
	@PostMapping("/addEquipement")
	@ResponseBody
	public Equipements addEquipement(@RequestBody Equipements c)
	{
		return cs.addEquipement(c);
	}
	
	
	
	@PutMapping("/EquipementsCheck/{id}")
	@ResponseBody
	public void EquipementsCheck(@PathVariable("id") Long id)
	{
		 cs.EquipementCheck(id);
	}
	
	
	
	
	@PutMapping("/modify-Equipements")
	@ResponseBody
	public Equipements modifyClient(@RequestBody Equipements c)
	{
		return cs.updateEquipement(c);
	}
	
	@DeleteMapping("/remove-Equipement/{idEq}")
	@ResponseBody
	public void removeEquipements(@PathVariable("idEq") Long idEq) {
		cs.deleteEquipement(idEq);
	}
  	
	
  	

	
	@PutMapping("/modify-Equipement-byID/{id}")
	@ResponseBody
	public Equipements ModifyEquipements(@PathVariable("id") Long ideq,@RequestBody Equipements t) {
	return cs.updateEquipementBySN(t, ideq);
	}
	
	
	
	
	
	
	
	@GetMapping("/search/{subject}")
	public ResponseEntity<Page<Equipements>> findByCodeabarre(@PathVariable("subject") String Codeabarre, @RequestParam(value = "page", defaultValue = "0", required = false) Integer page,
			@RequestParam(value = "size", defaultValue = "10", required = false) Integer size){
		Pageable pageable = PageRequest.of(page, size);
		Page<Equipements> cl = cs.findByCodeabarre(Codeabarre,pageable);	
		return ResponseEntity.ok().body(cl);
	}

	
	
	
	
	
	
	
	
	}