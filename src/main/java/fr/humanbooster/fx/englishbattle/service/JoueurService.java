package fr.humanbooster.fx.englishbattle.service;

import java.util.List;

import fr.humanbooster.fx.englishbattle.business.Joueur;

public interface JoueurService {

	Joueur recupererJoueur(Long id);

	List<Joueur> recupererJoueurs();

	Joueur ajouterJoueur(String email, String nom, String prenom, String motDePasse);

	boolean supprimerJoueur(Long id);

	boolean mettreAJourJoueur(Long id, String email, String nom, String prenom, String motDePasse);
}
