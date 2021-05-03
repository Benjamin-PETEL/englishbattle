package fr.humanbooster.fx.englishbattle.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import fr.humanbooster.fx.englishbattle.business.Joueur;
import fr.humanbooster.fx.englishbattle.business.Niveau;
import fr.humanbooster.fx.englishbattle.business.Partie;
import fr.humanbooster.fx.englishbattle.business.Ville;
import fr.humanbooster.fx.englishbattle.dao.impl.JoueurDaoImpl;
import fr.humanbooster.fx.englishbattle.dao.impl.NiveauDaoImpl;
import fr.humanbooster.fx.englishbattle.dao.impl.PartieDaoImpl;
import fr.humanbooster.fx.englishbattle.dao.impl.VilleDaoImpl;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class PartieDaoTest {

	private static Partie partie = null;
	private static PartieDao partieDao = new PartieDaoImpl();
	private static List<Partie> parties = new ArrayList<>();
	private static JoueurDao joueurDao = new JoueurDaoImpl();
	private static Ville ville = null;
	private static Niveau niveau = null;
	private static boolean test = false;

	@Order(1)
	@Test
	void testCreate() {
		Joueur joueur = new Joueur("email777.com", "Dupont", "jean", "7171");
		joueur.setVille(new Ville("Beyrouth"));
		joueur.setNiveau(new Niveau("expert"));

//		try {
//			joueur = joueurDao.create(new Joueur("email.com", "Hardy", "Bilal", "125421", niveauDao.create(niveau),
//					villeDao.create(ville)));
//		} catch (SQLException e1) {
//
//			e1.printStackTrace();
//		}

		partie = new Partie(joueur);
		try {
			partieDao.create(partie);
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	@Order(2)
	@Test
	void testFindOne() {
		Partie newPartie = null;
		
		try {
			newPartie = partieDao.findOne(partie.getId());
		} catch (SQLException e) {
		System.out.println("dd");
			e.printStackTrace();
		}
		System.out.println(newPartie);
		assertEquals( partie, newPartie);
	}
	
	@Order(3)
	@Test
	void testFindAll() {
		
		try {
			parties = partieDao.findAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertNotNull(parties);
	}


	@Order(3)
	@Test
	void testUpdate() {
		test = false;
		Partie partieModifiee = null;
		Joueur joueurModifie = null;
		Ville villeModifiee = new Ville("Tyr");
		Niveau niveauModifie = new Niveau("moyen");

		// On crée un nouveau joueur
		try {
			 joueurModifie = joueurDao.create(new Joueur("email777.com", "Dupont", "jean", "7171"));
		} catch (SQLException e1) {

			e1.printStackTrace();
		}

		// On teste le boolean que renvoie la méthode update
		try {
			test = partieDao.update(partie.getId(), joueurModifie);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		assertTrue(test);
		
		
	}
	@Order(4)
	@Test
	void testDelete() {
		
		
		Partie newPartie = null;
		
		try {
			test = partieDao.delete(partie.getId());
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
		
		assertTrue(test);
		
		// On fait un 2ème test en recherchant l'objet qui a été supprimé 
		try {
			newPartie = partieDao.findOne(partie.getId());
		} catch (SQLException e) {
	
			e.printStackTrace();
		}
		
		assertNull(newPartie);
		
	}

}
