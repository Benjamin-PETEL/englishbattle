package fr.humanbooster.fx.englishbattle.service;

import java.util.List;

import fr.humanbooster.fx.englishbattle.business.Joueur;

public interface JoueurService {

	/**
	 * 
	 * @param email
	 * @param nom
	 * @param prenom
	 * @param motDePasse
	 * @return un Object joueur complet si l'insertion en base s'est effectué, null sinon
	 */
	Joueur ajouterJoueur(String email, String nom, String prenom, String motDePasse);

	/**
	 * 
	 * @param id l'ID du joueur à récuperer
	 * @return un joueur si l'ID est trouvé, null si le joueur n'existe pas dans la base
	 */
	Joueur recupererJoueur(Long id);

	/**
	 * 
	 * @return 
	 */
	List<Joueur> recupererJoueurs();

	boolean mettreAJourJoueur(Long id, String email, String nom, String prenom, String motDePasse);
	
	boolean supprimerJoueur(Long id);

}
