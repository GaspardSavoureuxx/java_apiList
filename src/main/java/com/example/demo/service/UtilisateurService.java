package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.dtos.UtilisateurConnexionDto;
import com.example.demo.entities.Utilisateur;
import com.example.demo.repositories.UtilisateurRepository;

@Service
//Obligatoire pour rendre le fichier visible
public class UtilisateurService implements IUtilisateurService {
	
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	// nous sert ici pour utiliser la méthode save

	@Override
	public Utilisateur inscription(Utilisateur user) {
		// TODO Auto-generated method stub
		Utilisateur us = Utilisateur.builder().nom(user.getNom()).email(user.getEmail()).motDePasse(user.getMotDePasse()).build();
		return utilisateurRepository.save(us);
	}

	@Override
	public String connexion(@RequestBody UtilisateurConnexionDto userDto) {
		
		Optional<Utilisateur> userExistant = utilisateurRepository.findByEmail(userDto.getEmail());
		
		if(userExistant.isPresent()) {
			if(userExistant.get().getMotDePasse() == userDto.getMotDePasse()) {
				
				return "Connexion effectuée avec Succès";
			}
			return "Mot de passe incorrect";
		}
		
		return "Client non trouvé avec cette adressse email";
	}
	}
	
	


