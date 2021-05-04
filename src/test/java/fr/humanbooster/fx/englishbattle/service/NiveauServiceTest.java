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

import fr.humanbooster.fx.englishbattle.business.Niveau;
import fr.humanbooster.fx.englishbattle.service.impl.NiveauServiceImpl;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class NiveauServiceTest {
	
	// ----------------------------- Attributs ----------------------------------
	private NiveauService niveauService = new NiveauServiceImpl();
	private static Niveau niveauIn = null;
	private static Niveau niveauOut = null;
	private static List<Niveau> niveaux = null;

	
	// -------------------------------- Tests -----------------------------------
	@Test
	@Order(1)
	void testAjouterNiveau() {
		String nom = "Debutant";
		niveauIn = niveauService.ajouterNiveau(nom);
		// Tests
		assertNotNull(niveauIn);
		assertNotNull(niveauIn.getId());
		assertEquals(niveauIn.getNom(), nom);
	}

	
	@Test
	@Order(2)
	void testRecupererNiveau() {
		niveauOut = null;
		niveauOut = niveauService.recupererNiveau(niveauIn.getId());
		// Tests
		assertNotNull(niveauOut);
		assertEquals(niveauIn, niveauOut);
	}

	
	@Test
	@Order(3)
	void testRecupererNiveaux() {
		niveaux = niveauService.recupererNiveaux();
		assertFalse(niveaux.isEmpty());
		// Tests
		assertTrue(niveaux.contains(niveauIn));
	}


}