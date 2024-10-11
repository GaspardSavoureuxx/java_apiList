package com.example.demo.entities;


import com.example.demo.enums.EtatTache;
import com.example.demo.enums.PrioriteTache;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Tache {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String titre;
	private String description;
	private String etat; 
	private String priorite;
	private int valeur;
	@ManyToOne()
	@JoinColumn(name="utilisateur_id")
	private Utilisateur utilisateur;

}
