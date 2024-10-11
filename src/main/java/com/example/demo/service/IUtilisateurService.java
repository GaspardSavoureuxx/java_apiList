package com.example.demo.service;

import com.example.demo.dtos.UtilisateurConnexionDto;
import com.example.demo.entities.Utilisateur;

public interface IUtilisateurService {

	Utilisateur inscription(Utilisateur user);

	String connexion(UtilisateurConnexionDto userDto);

}
