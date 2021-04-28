package fr.humanbooster.fx.englishbattle.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import fr.humanbooster.fx.englishbattle.business.Ville;
import fr.humanbooster.fx.englishbattle.service.impl.VilleServiceImpl;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class VilleServiceTest {

	private static VilleService villeService = new VilleServiceImpl();
	private static Ville ville = null;

	@Order(1)
	@Test
	void testAjouterVille() {
		String nom = "Marseille";

		ville = villeService.ajouterVille(nom);
		assertNotNull(ville);
		assertNotNull(ville.getIdVille());
		assertEquals(ville.getNom(), nom);

	}

	@Order(2)
	@Test
	void testRecupererVille() {
		Ville ville2 = null;

		ville2 = villeService.recupererVille(ville.getIdVille());
		assertNotNull(ville2);
		assertNotNull(ville2.getIdVille());
		assertNotNull(ville2.getNom());
		assertEquals(ville2, ville);

	}

	@Order(3)
	@Test
	void testRecupererVilles() {
		List<Ville> villes = villeService.recupererVilles();
		assertFalse(villes.isEmpty());

		for (Ville ville : villes) {
			assertNotNull(ville.getIdVille());
			assertTrue(ville.getIdVille() > 0);

			assertNotNull(ville.getNom());
		}
	}

	@Order(4)
	@Test
	void testSupprimerVille() {
		boolean villeEfface = false;

		villeEfface = villeService.supprimerVille(ville.getIdVille());

		assertTrue(villeEfface);
	}

}
