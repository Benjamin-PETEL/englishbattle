package fr.humanbooster.fx.englishbattle.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

	private JoueurDao joueurDao = new JoueurDaoImpl();
	private NiveauDao niveauDao = new NiveauDaoImpl();
	private VilleDao villeDao = new VilleDaoImpl();
	private static Joueur joueur = null;
	private static Niveau niveau = null;
	private static Ville ville = null;

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
			Joueur joueur2 = new Joueur(email, nom, prenom, motDePasse);
			joueur2.setVille(ville);
			joueur2.setNiveau(niveau);
			joueur = joueurDao.create(joueur2);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		assertNotNull(joueur);
		assertTrue(joueur.getEmail().equals(email));
		assertTrue(joueur.getMotDePasse().equals(motDePasse));
		assertTrue(joueur.getNom().equals(nom));
		assertTrue(joueur.getPrenom().equals(prenom));
		assertTrue(joueur.getVille().equals(ville));
		assertTrue(joueur.getNiveau().equals(niveau));
	}

	@Order(2)
	@Test
	void testFindOne() {
		Joueur joueur2 = null;
		try {
			joueur2 = joueurDao.findOne(joueur.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		assertNotNull(joueur2);
		assertNotNull(joueur2.getEmail());
		assertNotNull(joueur2.getId());
		assertNotNull(joueur2.getMotDePasse());
		assertNotNull(joueur2.getNom());
		assertNotNull(joueur2.getPrenom());
		assertEquals(joueur, joueur2);
	}

	@Order(3)
	@Test
	void testFindAll() {
		List<Joueur> joueurs = null;
		try {
			joueurs = joueurDao.findAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		assertNotNull(joueurs);
		assertTrue(joueurs.contains(joueur));
	}

	@Order(4)
	@Test
	void testUpdate() {
		boolean isUpdated = false;
		try {
			joueur.setEmail("flap@gmail.com");
			joueur.setMotDePasse("plouf");
			joueur.setNom("rard");
			joueur.setPrenom("gege");
			joueur.setNiveau(niveauDao.create(new Niveau("expert")));
			joueur.setVille(villeDao.create(new Ville("Le Mans")));
			isUpdated = joueurDao.update(joueur.getId(), joueur);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		assertTrue(isUpdated);
	}

	@Order(5)
	@Test
	void testDelete() {
		boolean isDeleted = false;
		try {
			isDeleted = joueurDao.delete(joueur.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		assertTrue(isDeleted);
	}

//	
}
