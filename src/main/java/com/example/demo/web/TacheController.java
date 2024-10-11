package com.example.demo.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Tache;
import com.example.demo.service.ITacheService;

@RestController
@RequestMapping("/utilisateur")
public class TacheController {
	

	@Autowired
	private ITacheService iTacheService;
	
	
	@PostMapping("/{userId}/tache")
	public Tache creerTache(@PathVariable Long userId, @RequestBody Tache tache) {
		return iTacheService.creerTache(userId, tache);
	}
	
	@GetMapping("/{userID}/taches")
	public List<Tache> recupTacheById(@PathVariable Long userID) {
		return iTacheService.recupTachesById(userID);
		
	}
	
	@GetMapping("/{userID}/taches/value")
	public int recupSumValueById(@PathVariable Long userID) {
		return iTacheService.recupSumValueById(userID);
		
	}
	
	@DeleteMapping("/taches/{id}")
	public void supprTache(@PathVariable Long id) {
		
		iTacheService.supprTache(id);
		
	}
	
	@PutMapping("/taches/{id}")
	public Optional<Tache> modifTache(@PathVariable Long id, @RequestBody Tache tache) {
		return iTacheService.modifTache(id, tache);
	}
		
	
	@GetMapping("/taches/filtre/etat")
	public Optional<Tache> recupTacheByEtat(@RequestBody String etat){
		return iTacheService.recupTachesByEtat(etat) ;
		
	}
	
	@GetMapping("/taches/filtre/priorite")
	public Optional<Tache> recupTacheByPriorite(@RequestBody String priorite){
		return iTacheService.recupTachesByPriorite(priorite);
		
	}

}
