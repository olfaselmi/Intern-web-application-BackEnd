package tn.poste.spring.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;


import tn.poste.spring.entity.Bureau;
import tn.poste.spring.service.IBureauService;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/BureauDePosteOuAgence")

public class BureauRestController {
	@Autowired
	IBureauService Bureauservice ;
	//http://localhost:8089/SpringMVC/Bureau/retrieve-all-BureauDePosteOuAgence
	
		@GetMapping("/retrieve-all-Bureaux") 
		@ResponseBody 
		public List<Bureau> getBureaus() { 
			return Bureauservice.retrieveAllBureaux();
		  
		}
		
		//http://localhost:8089/SpringMVC/Bureau/retrieve-Bureau/2
		@GetMapping("/retrieve-Bureau/{Bureau-id}")
		@ResponseBody
		public Bureau retrieveBureau(@PathVariable("Bureau-id") Long idBureau) {
		return Bureauservice.retrieveBureauById(idBureau);
		}
		
		
		//http://localhost:8089/SpringMVC/Bureau/add-Bureau
		@PostMapping("/add-Bureau")
		@ResponseBody
		public Bureau AddBureau(@RequestBody Bureau t)
		{
				Bureau Bureau= Bureauservice.addBureau(t);
				return Bureau;
		
	     }
		
		
		
		
		
		//http://localhost:8089/SpringMVC/Bureau/remove-Bureau/{Bureau-id}
		@DeleteMapping("/remove-Bureau/{Bureau-id}")
		@ResponseBody
		public void removeBureau(@PathVariable("Bureau-id") Long idBureau) {
		Bureauservice.deleteBureau(idBureau);	}
		
		
		
		//http://localhost:8089/SpringMVC/Bureau/modify-Bureau
			@PutMapping("/modify-Bureau")
			@ResponseBody
			public Bureau ModifyBureau(@RequestBody Bureau t)
			{
				return Bureauservice.updateBureau(t);
			}

			//http://localhost:8089/SpringMVC/Bureau/modify-Bureau-byID/2
			@PutMapping("/modify-Bureau-byID/{Bureau-id}")
			@ResponseBody
			public Bureau ModifyBureauById(@PathVariable("Bureau-id") Long idBureau,@RequestBody Bureau t) {
			return Bureauservice.updateBureauById(t, idBureau);
			}
			
			
		
			@GetMapping("/statisticnbBureauUser") 
			@ResponseBody 
			public List<Map<Long, Integer>> statisticnbBureauUser(){
				return Bureauservice.StatisticUserBureau();
			}
			
		
			
			@GetMapping("/nbr-Bureau")
			@ResponseBody
			public int numbreBureau() {
			return Bureauservice.nbrBureaux();
			}
}
