package fr.humanbooster.fx.englishbattle.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import fr.humanbooster.fx.englishbattle.business.Joueur;
import fr.humanbooster.fx.englishbattle.business.Niveau;
import fr.humanbooster.fx.englishbattle.business.Ville;
import fr.humanbooster.fx.englishbattle.service.impl.JoueurServiceImpl;
import fr.humanbooster.fx.englishbattle.service.impl.NiveauServiceImpl;
import fr.humanbooster.fx.englishbattle.service.impl.VilleServiceImpl;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class JoueurServiceTest {
	private JoueurService joueurService = new JoueurServiceImpl();
	private NiveauService niveauService = new NiveauServiceImpl();
	private VilleService villeService = new VilleServiceImpl();
	private static Joueur joueur = null;
	private static Ville ville = null;
	private static Niveau niveau = null;

	@Order(1)
	@Test
	void testAjouterJoueur() {
		String nom = "Blip";
		String prenom = "bloup";
		String email = "blip.bloup@gmail.com";
		String motDePasse = "blipbloup";
		niveau = niveauService.ajouterNiveau("1");
		ville = villeService.ajouterVille("Lyon");
		joueur = joueurService.ajouterJoueur(email, nom, prenom, motDePasse, ville, niveau);
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
	void testRecupererJoueur() {
		Joueur joueur2 = null;
		joueur2 = joueurService.recupererJoueur(joueur.getId());
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
	void testMettreAJourJoueur() {
		niveau = niveauService.ajouterNiveau("debutant");
		ville = villeService.ajouterVille("Lyon");
		boolean aEteMisAJour = joueurService.mettreAJourJoueur(4l, "mail", "motdpasse", "nom", "prenom", ville, niveau);
		assertTrue(aEteMisAJour);
	}

	@Order(4)
	@Test
	void testerRecupererJoueurs() {
		List<Joueur> joueurs = null;
		joueurs = joueurService.recupererJoueurs();
		assertNotNull(joueurs);
		assertTrue(joueurs.contains(joueur));

	}

	@Order(5)
	@Test
	void testSupprimerJoueur() {
		boolean aEteSupprime = joueurService.supprimerJoueur(joueur.getId());
		assertTrue(aEteSupprime);
	}
}
