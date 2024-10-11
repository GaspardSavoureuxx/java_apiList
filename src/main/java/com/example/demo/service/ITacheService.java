package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.entities.Tache;

public interface ITacheService {

	public Tache creerTache( Long userId, Tache tache);

	public List<Tache> recupTachesById(Long userID);
	
	public int recupSumValueById(Long userID);
	
	public String supprTache(Long id);
	
	public Optional<Tache> recupTachesByEtat(String Etat);
	
	public Optional<Tache> recupTachesByPriorite(String Priorite);
	
	public Optional<Tache> modifTache( Long tacheID, Tache tache );

}
