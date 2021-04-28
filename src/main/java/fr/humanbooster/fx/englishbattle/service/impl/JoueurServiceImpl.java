package fr.humanbooster.fx.englishbattle.service.impl;

import java.sql.SQLException;
import java.util.List;

import fr.humanbooster.fx.englishbattle.business.Joueur;
import fr.humanbooster.fx.englishbattle.business.Niveau;
import fr.humanbooster.fx.englishbattle.business.Ville;
import fr.humanbooster.fx.englishbattle.dao.JoueurDao;
import fr.humanbooster.fx.englishbattle.dao.impl.JoueurDaoImpl;
import fr.humanbooster.fx.englishbattle.service.JoueurService;

public class JoueurServiceImpl implements JoueurService {
	private JoueurDao joueurDao = new JoueurDaoImpl();

	@Override
	public Joueur recupererJoueur(Long id) {
		try {
			return joueurDao.findOne(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Joueur> recupererJoueurs() {
		try {
			return joueurDao.findAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Joueur ajouterJoueur(String email, String nom, String prenom, String motDePasse, Ville ville,
			Niveau niveau) {
		Joueur joueur = new Joueur();
		joueur.setEmail(email);
		joueur.setMotDePasse(motDePasse);
		joueur.setNiveau(niveau);
		joueur.setNom(nom);
		joueur.setPrenom(prenom);
		joueur.setVille(ville);
		try {
			joueurDao.create(joueur);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return joueur;
	}

	@Override
	public boolean supprimerJoueur(Long id) {
		try {
			joueurDao.delete(id);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean mettreAJourJoueur(Long idDuJoueurAModifier, String email, String nom, String prenom,
			String motDePasse, Ville ville, Niveau niveau) {
		Joueur joueur = new Joueur();
		joueur.setEmail(email);
		joueur.setMotDePasse(motDePasse);
		joueur.setNiveau(niveau);
		joueur.setNom(nom);
		joueur.setPrenom(prenom);
		joueur.setVille(ville);
		try {
			joueurDao.update(idDuJoueurAModifier, joueur);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
