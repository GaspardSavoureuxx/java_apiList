package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.UtilisateurConnexionDto;
import com.example.demo.entities.Utilisateur;
import com.example.demo.service.IUtilisateurService;

@RestController
@RequestMapping("/utilisateur")
public class UtilisateurController {
	
	@Autowired
	private IUtilisateurService iUtilisateurService;
	
	@PostMapping("/inscription")
	public Utilisateur inscription(@RequestBody Utilisateur us) {
		return iUtilisateurService.inscription(us);
		
	}
	
	
	@PostMapping("/connexion")
	public String connexion(@RequestBody UtilisateurConnexionDto usDto) {
		return iUtilisateurService.connexion(usDto);
		
	}

}
