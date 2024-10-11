package com.example.demo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Tache;
import com.example.demo.entities.Utilisateur;
import com.example.demo.enums.EtatTache;
import com.example.demo.enums.PrioriteTache;

public interface TacheRepository extends JpaRepository<Tache, Long> {
	
	List<Tache> findByUtilisateur(Utilisateur utilisateur);
	Optional<Tache> findByEtat(String etat);
	Optional<Tache> findByPriorite(String priorite);

}
