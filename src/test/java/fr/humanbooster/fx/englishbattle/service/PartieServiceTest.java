package fr.humanbooster.fx.englishbattle.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import fr.humanbooster.fx.englishbattle.business.Joueur;
import fr.humanbooster.fx.englishbattle.business.Niveau;
import fr.humanbooster.fx.englishbattle.business.Partie;
import fr.humanbooster.fx.englishbattle.business.Question;
import fr.humanbooster.fx.englishbattle.business.Verbe;
import fr.humanbooster.fx.englishbattle.business.Ville;
import fr.humanbooster.fx.englishbattle.service.impl.JoueurServiceImpl;
import fr.humanbooster.fx.englishbattle.service.impl.NiveauServiceImpl;
import fr.humanbooster.fx.englishbattle.service.impl.PartieServiceImpl;
import fr.humanbooster.fx.englishbattle.service.impl.VilleServiceImpl;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PartieServiceTest {

	private static PartieService partieService = new PartieServiceImpl();
	private static VilleService villeService = new VilleServiceImpl();
	private static NiveauService niveauService = new NiveauServiceImpl();
	private static JoueurService joueurService = new JoueurServiceImpl();
	private static Partie partie = null;

	@Test
	@Order(1)
	@DisplayName("Teste l'ajout d'une partie")
	void testAjouterPartie() throws SQLException {
		String nom = "Nils";
		String prenom = "Nils";
		String motDePasse = "KGKN";
		String email = "nils@nils.com";
		Ville ville = villeService.ajouterVille("Lyon");
		Niveau niveau = niveauService.ajouterNiveau("Niveau2");
		Joueur joueur = joueurService.ajouterJoueur(email, nom, prenom, motDePasse, ville, niveau);
		partie = partieService.ajouterPartie(joueur);

		assertNotNull(partie);
	}

	@Test
	@Order(2)
	@DisplayName("Teste la récuperation d'une partie")
	void testRecupererPartie() {
		Partie partie2 = null;
		partie2 = partieService.recupererPartie(partie.getId());
		assertNotNull(partie2);
	}

	@Test
	@Order(3)
	@DisplayName("Teste la récuperation de toutes les parties")
	void testRecupererParties() {
		List<Partie> parties = null;
		parties = partieService.recupererParties();
		assertNotNull(parties);
		for (Partie partie : parties) {
			assertNotNull(partie);
			assertTrue(partie.getId() > 0);
		}
	}

	@Test
	@Order(4)
	@DisplayName("Teste pour voir si les verbes sont present")
	void testEstPresent() {
//		Création d'un objet Verbe 
		Verbe verbe = new Verbe("Test", "Tost", "Tast");
//		Création d'un objetQuestion et ajout du Verbe
		Question question = new Question(partie, verbe);
//		On ajoute à la partie la Question
		partie.addQuestion(question);
//		On teste la présence d'un verbe dans la question
		boolean estPresent = partieService.estPresent(partie, verbe);
		assertTrue(estPresent);
	}

	@Test
	@Order(5)
	@DisplayName("Teste pour voir si la partie a été supprimé")
	void testSupprimerPartie() {
		boolean estSupprime = partieService.supprimerPartie(partie.getId());

		assertTrue(estSupprime);
	}

}
