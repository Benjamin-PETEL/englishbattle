package fr.humanbooster.fx.englishbattle.service.impl;

import java.sql.SQLException;
import java.util.List;

import fr.humanbooster.fx.englishbattle.business.Joueur;
import fr.humanbooster.fx.englishbattle.dao.JoueurDao;
import fr.humanbooster.fx.englishbattle.service.JoueurService;

public class JoueurServiceImpl implements JoueurService {
	private JoueurDao joueurDao = new JoueurDaoImpl();

	@Override
	public Joueur recupererJoueur(Long id) {
		try {
			joueurDao.findOne(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Joueur> recupererJoueurs() {
		try {
			joueurDao.findAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Joueur ajouterJoueur(String email, String nom, String prenom, String motDePasse) {
		Joueur joueur = new Joueur(email, nom, prenom, motDePasse);
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
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean mettreAJourJoueur(String email, String nom, String prenom, String motDePasse) {
		try {
			joueurDao.update(null, email, nom, prenom, motDePasse)
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
