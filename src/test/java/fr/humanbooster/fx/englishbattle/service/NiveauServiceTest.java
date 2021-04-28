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
	private NiveauService niveauService = new NiveauServiceImpl();
	private static Niveau niveau = null;

	
	@Test
	@Order(1)
	void testAjouterNiveau() {
		String nom = "";
		niveau = niveauService.ajouterNiveau(nom);
		assertNotNull(niveau);
		assertNotNull(niveau.getId());
		assertEquals(niveau.getNom(), nom);
	}

	@Test
	@Order(2)
	void testRecupererNiveau() {
		Niveau niveau1 = null;

		niveau1 = niveauService.recupererNiveau(niveau.getId());
		assertNotNull(niveau1);
		assertNotNull(niveau1.getId());
		assertEquals(niveau1.getId(), niveau.getId());
		assertEquals(niveau1.getNom(), niveau.getNom());
	}

	@Test
	@Order(3)
	void testRecupererNiveaux() {
		List<Niveau> niveaux = niveauService.recupererNiveaux();
		assertFalse(niveaux.isEmpty());
		assertTrue(niveaux.contains(niveau));

		for (Niveau niveau : niveaux) {
			assertNotNull(niveau.getId());
			assertTrue(niveau.getId() > 0);
			assertNotNull(niveau.getNom());
		}
}
}