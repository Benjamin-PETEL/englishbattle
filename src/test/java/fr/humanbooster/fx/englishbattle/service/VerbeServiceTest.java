package fr.humanbooster.fx.englishbattle.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import fr.humanbooster.fx.englishbattle.business.Verbe;
import fr.humanbooster.fx.englishbattle.service.impl.VerbeServiceImpl;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class VerbeServiceTest {

	private static VerbeService verbeService = new VerbeServiceImpl();
	private static Verbe verbe = null;
	private static List<Verbe> verbes = null;
	
	@Test
	@Order(1)
	@DisplayName("teste la création d'un verbe")
	void testAjouterVerbe() {
		String baseVerbale = "baseVerbale";
		String participePasse = "participePasse";
		String preterit = "preterit";
		String traduction = "traduction";
		Verbe verbe2 = new Verbe(baseVerbale, preterit, participePasse, traduction);
		verbe = verbeService.ajouterVerbe(verbe2);
		assertNotNull(verbe);
		assertNotNull(verbe.getId());
		assertTrue(verbe.equals(verbe2));
	}

	@Test
	@Order(2)
	@DisplayName("teste la recupération d'un verbe")
	void testRecupererVerbe() {
		Verbe verbe2 = null;
		verbe2 = verbeService.recupererVerbe(verbe.getId());
		assertNotNull(verbe2.getId());
		assertTrue(verbe2.getId() > 0);
	}

	@Test
	@Order(3)
	@DisplayName("teste la récupération d'une liste de verbes")
	void testRecupererVerbes() {
		verbes = verbeService.recupererVerbes();
		assertFalse(verbes.isEmpty());
		
		for (Verbe verbe : verbes) {
			assertNotNull(verbe.getId());
			assertTrue(verbe.getId() > 0);
		}
	}
	
	@Test
	@Order(4)
	@DisplayName("teste la récupération d'un verbe aleatoire")
	void testRecupererVerbeAleatoire() {
		Verbe verbe2 = null;
		verbe2 = verbeService.recupererAleatoire();
		assertNotNull(verbe2);
		assertNotNull(verbe2.getId());
	}
	
	@Test
	@Order(5)
	@DisplayName("teste la suppression d'un verbe par son Id")
	void testDeleteVerbe() {
		boolean ReleveaEteEfface = false;
		ReleveaEteEfface = verbeService.supprimerVerbe(verbe.getId());
		assertTrue(ReleveaEteEfface);
	}
	
	@Test
	@Order(6)
	@DisplayName("teste l'import des verbes")
	void testAjoutVerbes() {
		boolean verbesAjoutes = false;
		verbesAjoutes = verbeService.importerVerbes();
		assertTrue(verbesAjoutes);
	}
	
}

