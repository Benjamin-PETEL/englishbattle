package fr.humanbooster.fx.englishbattle.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import fr.humanbooster.fx.englishbattle.business.Joueur;
import fr.humanbooster.fx.englishbattle.business.Niveau;
import fr.humanbooster.fx.englishbattle.business.Ville;
import fr.humanbooster.fx.englishbattle.dao.impl.JoueurDaoImpl;
import fr.humanbooster.fx.englishbattle.dao.impl.NiveauDaoImpl;
import fr.humanbooster.fx.englishbattle.dao.impl.VilleDaoImpl;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class JoueurDaoTest {
	
	// ----------------------------- Attributs ----------------------------------
	private JoueurDao joueurDao = new JoueurDaoImpl();
	private NiveauDao niveauDao = new NiveauDaoImpl();
	private VilleDao villeDao = new VilleDaoImpl();
	private static Joueur joueurIn = null;
	private static Joueur joueurOut = null;
	private static List<Joueur> joueurs = null;
	private static Niveau niveau = null;
	private static Ville ville = null;

	
	// -------------------------------- Tests -----------------------------------
	@Order(1)
	@Test
	void testCreate() {
		String nom = "flip";
		String prenom = "floup";
		String email = "flip.floup@gmail.com";
		String motDePasse = "flipfloup";
		try {
			niveau = niveauDao.create(new Niveau("debutant"));
			ville = villeDao.create(new Ville("Lyon"));
			Joueur joueur = new Joueur(email, nom, prenom, motDePasse);
			joueur.setVille(ville);
			joueur.setNiveau(niveau);
			joueurIn = joueurDao.create(joueur);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// Tests
		assertNotNull(joueurIn);
		assertNotNull(joueurIn.getId());
		assertTrue(joueurIn.getNom().equals(nom));
		assertTrue(joueurIn.getPrenom().equals(prenom));
		assertTrue(joueurIn.getEmail().equals(email));
		assertTrue(joueurIn.getMotDePasse().equals(motDePasse));
		assertTrue(joueurIn.getVille().equals(ville));
		assertTrue(joueurIn.getNiveau().equals(niveau));
	}

	
	@Order(2)
	@Test
	void testFindOne() {
		joueurOut = null;
		try {
			joueurOut = joueurDao.findOne(joueurIn.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// Tests
		assertNotNull(joueurOut);
		assertEquals(joueurIn, joueurOut);
	}

	
	@Order(3)
	@Test
	void testFindAll() {
		joueurs = null;
		try {
			joueurs = joueurDao.findAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// Tests
		assertNotNull(joueurs);
		assertTrue(joueurs.contains(joueurIn));
	}

	
	@Order(4)
	@Test
	void testUpdate() {
		boolean isUpdated = false;
		try {
			joueurIn.setEmail("flap@gmail.com");
			joueurIn.setMotDePasse("plouf");
			joueurIn.setNom("rard");
			joueurIn.setPrenom("gege");
			joueurIn.setNiveau(niveauDao.create(new Niveau("expert")));
			joueurIn.setVille(villeDao.create(new Ville("Le Mans")));
			isUpdated = joueurDao.update(joueurIn.getId(), joueurIn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// Tests
		assertTrue(isUpdated);
	}

	
	@Order(5)
	@Test
	void testDelete() {
		boolean isDeleted = false;
		try {
			isDeleted = joueurDao.delete(joueurIn.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// Tests
		assertTrue(isDeleted);
		assertFalse(joueurs.contains(joueurIn));
	}

	
}
