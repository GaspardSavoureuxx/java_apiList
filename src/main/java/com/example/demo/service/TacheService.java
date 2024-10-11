package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.entities.Tache;
import com.example.demo.entities.Utilisateur;
import com.example.demo.enums.EtatTache;
import com.example.demo.enums.PrioriteTache;
import com.example.demo.repositories.TacheRepository;
import com.example.demo.repositories.UtilisateurRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class TacheService implements ITacheService {
	
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	@Autowired
	private TacheRepository tacheRepository;

	@Override
	public Tache creerTache(Long userId, Tache tache) {
		// TODO Auto-generated method stub
		Optional<Utilisateur> users = utilisateurRepository.findById(userId);
		
		if(users.isPresent()) {
		Tache t = Tache.builder().titre(tache.getTitre()).description(tache.getDescription()).priorite(PrioriteTache.MOYENNE.toString()).etat(EtatTache.EN_COURS.toString()).valeur(tache.getValeur()).utilisateur(users.get()).build();
		return tacheRepository.save(t);
		}
		throw new RuntimeException("Utilisateur non trouvé");
	}
	
	@Override
	public List<Tache> recupTachesById(Long userID) {
		Optional<Utilisateur> users = utilisateurRepository.findById(userID);
		
		if(users.isPresent()) {
			return users.get().getTaches();
		}
		throw new RuntimeException("Utilisateur non trouvé");
	}
	
	public int recupSumValueById(Long userID) {
		Optional<Utilisateur> users = utilisateurRepository.findById(userID);
		int somme = 0;
		
		if(users.isPresent()) {
			 List<Tache> tachesUser = users.get().getTaches();
			 for (Tache tache : tachesUser) {
				 int tachev = tache.getValeur();
				 somme += tachev;
				
			}
		return somme;
		}
		throw new RuntimeException("Utilisateur non trouvé");
	}
	
	
	public String supprTache(Long id) {
		
		Optional<Tache> taches = tacheRepository.findById(id);
		if(taches.isPresent()) {
			
			tacheRepository.deleteById(id);
			return "tache " + id + " supprimée avec succès";
		}
		throw new RuntimeException("Tache non trouvée");
	}
	
	
	public Optional<Tache> modifTache( Long tacheID, Tache tache ) {
		Optional<Tache> taches = tacheRepository.findById(tacheID);
		
		if(taches.isPresent()) {
			
			if(tache.getTitre() != null)
				{ taches.get().setTitre(tache.getTitre()); }
				
			if(tache.getDescription() != null )
				{ taches.get().setDescription(tache.getDescription()); }
				
			if(tache.getEtat() != null)
					{ taches.get().setEtat(tache.getEtat()); }
				
			if(tache.getPriorite() != null )
				{ taches.get().setPriorite(tache.getPriorite()); }
			if( tache.getValeur() != 0 )
			{taches.get().setValeur(tache.getValeur());}
				

			return Optional.empty();
						}
		throw new RuntimeException("Aucun id trouvé");
		
	}
	
	public Optional<Tache> recupTachesByEtat(String Etat) {
		Optional<Tache> taches = tacheRepository.findByEtat(Etat);
		if(taches.isPresent()) {
		return taches;
		}
		throw new RuntimeException("Aucune tache ne correspond");
	}
	
	public Optional<Tache> recupTachesByPriorite(String Priorite) {
		Optional<Tache> taches = tacheRepository.findByPriorite(Priorite);
		if(taches.isPresent()) {
		return taches;
		}
		throw new RuntimeException("Aucune tache ne correspond");
	}

}
