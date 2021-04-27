package fr.humanbooster.fx.englishbattle.service;

import java.util.List;

import fr.humanbooster.fx.englishbattle.business.Niveau;


public interface NiveauService {

	Niveau ajouterNiveau(String nom);
	
	List<Niveau> recupererNiveaux();
	
	Niveau recupererNiveau(Long id);
	
	boolean supprimerNiveau(Long id);
}