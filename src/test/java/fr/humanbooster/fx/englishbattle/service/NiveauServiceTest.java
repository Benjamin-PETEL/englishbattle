package fr.humanbooster.fx.englishbattle.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import fr.humanbooster.fx.englishbattle.business.Niveau;
import fr.humanbooster.fx.englishbattle.service.impl.NiveauServiceImpl;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class NiveauServiceTest {

	private static NiveauService niveauService = new NiveauServiceImpl();
	private static Niveau niveau = null;
	// private static List<Niveau> niveaux = null;

	@Test
	@Order(1)
	@DisplayName("Teste l'ajout d'un niveau")
	void testAjouterNiveau() {
		String nom = "Niveau 1";

		Niveau niveau2 = new Niveau(nom);

		niveau = niveauService.ajouterNiveau(nom);

		assertNotNull(niveau);
		assertNotNull(niveau.getIdNiveau());
		assertTrue(niveau.equals(niveau2));

	}

	@Test
	@Order(2)
	@DisplayName("Teste de la récupération d'un niveau")
	void testRecupererNiveau() {
		Niveau niveau3 = null;
		niveau3 = niveauService.recupererNiveau(niveau.getIdNiveau());
		assertNotNull(niveau3);
		assertTrue(niveau.equals(niveau3));
	}

	@Test
	void testRecupererNiveaux() {
		List<Niveau> niveaux = null;

		niveaux = niveauService.recupererNiveaux();
		assertNotNull(niveaux);
		for (Niveau niveau : niveaux) {
			assertNotNull(niveau);
			assertTrue(niveau.getNom().equals(niveau.getNom()));
		}

	}

}
