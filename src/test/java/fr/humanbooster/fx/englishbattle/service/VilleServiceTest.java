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

	// ----------------------------- Attributs ----------------------------------
	private static VilleService villeService = new VilleServiceImpl();
	private static Ville villeIn = null;
	private static Ville villeOut = null;
	private static List<Ville> villes = null;

	
	// -------------------------------- Tests -----------------------------------
	@Order(1)
	@Test
	void testAjouterVille() {
		String nom = "Marseille";
		villeIn = villeService.ajouterVille(nom);
		// Tests
		assertNotNull(villeIn);
		assertNotNull(villeIn.getIdVille());
		assertEquals(villeIn.getNom(), nom);

	}

	
	
	@Order(2)
	@Test
	void testRecupererVille() {
		villeOut = null;
		villeOut = villeService.recupererVille(villeIn.getIdVille());
		// Tests
		assertNotNull(villeOut);
		assertNotNull(villeOut.getIdVille());
		assertNotNull(villeOut.getNom());
		assertEquals(villeOut, villeIn);

	}

	
	
	@Order(3)
	@Test
	void testRecupererVilles() {
		villes = villeService.recupererVilles();
		// Tests
		assertFalse(villes.isEmpty());
		assertTrue(villes.contains(villeIn));
	}

	
	
	@Order(4)
	@Test
	void testSupprimerVille() {
		boolean villeEfface = false;
		villeEfface = villeService.supprimerVille(villeIn.getIdVille());
		villes = villeService.recupererVilles();
		// Tests
		assertTrue(villeEfface);
		assertFalse(villes.contains(villeIn));
	}

}
