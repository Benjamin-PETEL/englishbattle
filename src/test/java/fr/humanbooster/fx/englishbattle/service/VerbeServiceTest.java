package fr.humanbooster.fx.englishbattle.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
	private static Verbe verbeIn = null;
	private static Verbe verbeOut = null;
	private static List<Verbe> verbes = null;
	
	@Test
	@Order(1)
	@DisplayName("teste la création d'un verbe")
	void testAjouterVerbe() {
		String baseVerbale = "baseVerbale";
		String participePasse = "participePasse";
		String preterit = "preterit";
		String traduction = "traduction";
		Verbe verbe = new Verbe(baseVerbale, preterit, participePasse, traduction);
		verbeIn = verbeService.ajouterVerbe(verbe);
		// Tests
		assertNotNull(verbeIn);
		assertNotNull(verbeIn.getId());
		assertTrue(verbeIn.getBaseVerbale().equals(verbe.getBaseVerbale()));
		assertTrue(verbeIn.getParticipePasse().equals(verbe.getParticipePasse()));
		assertTrue(verbeIn.getPreterit().equals(verbe.getPreterit()));
		assertTrue(verbeIn.getTraduction().equals(verbe.getTraduction()));
	}

	
	@Test
	@Order(2)
	@DisplayName("teste la recupération d'un verbe")
	void testRecupererVerbe() {
		verbeOut = verbeService.recupererVerbe(verbeIn.getId());
		// Tests
		assertNotNull(verbeOut);
		assertEquals(verbeIn, verbeOut);
	}
	

	@Test
	@Order(3)
	@DisplayName("teste la récupération d'une liste de verbes")
	void testRecupererVerbes() {
		verbes = verbeService.recupererVerbes();
		// Tests
		assertFalse(verbes.isEmpty());
		assertTrue(verbes.contains(verbeIn));
	}
	
	@Test
	@Order(4)
	@DisplayName("teste la récupération d'un verbe aleatoire")
	void testRecupererVerbeAleatoire() {
		verbeOut = null;
		verbeOut = verbeService.recupererAleatoire();
		// Tests
		assertNotNull(verbeOut);
		assertNotNull(verbeOut.getId());
		assertNotNull(verbeOut.getBaseVerbale());
		assertNotNull(verbeOut.getParticipePasse());
		assertNotNull(verbeOut.getPreterit());
		assertNotNull(verbeOut.getTraduction());
	}
	
	@Test
	@Order(5)
	@DisplayName("teste la suppression d'un verbe par son Id")
	void testDeleteVerbe() {
		boolean verbeIsDeleted = false;
		verbeIsDeleted = verbeService.supprimerVerbe(verbeIn.getId());
		verbes = verbeService.recupererVerbes();
		// Tests
		assertTrue(verbeIsDeleted);
		assertFalse(verbes.contains(verbeIn));
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

