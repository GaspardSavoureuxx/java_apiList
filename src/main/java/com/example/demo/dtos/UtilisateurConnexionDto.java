package com.example.demo.dtos;

import lombok.Data;

@Data
public class UtilisateurConnexionDto {
	private String email;
	private long motDePasse;
	// Cette classe est une alternative de la class client avec seulement les attributs nécessaires pour la méthode de connexion
}
