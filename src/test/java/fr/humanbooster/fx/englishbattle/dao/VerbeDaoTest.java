package fr.humanbooster.fx.englishbattle.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import fr.humanbooster.fx.englishbattle.business.Verbe;
import fr.humanbooster.fx.englishbattle.dao.impl.VerbeDaoImpl;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class VerbeDaoTest {

	// ----------------------------- Attributs ----------------------------------
	private static VerbeDao verbeDao = new VerbeDaoImpl();
	private static Verbe verbeIn = null;
	private static Verbe verbeOut = null;
	private static List<Verbe> verbes = null;
	
	
	
	// -------------------------------- Tests -----------------------------------
	@Test
	@Order(1)
	@DisplayName("teste la création d'un verbe")
	void testCreate() {
		String baseVerbale = "baseVerbale";
		String participePasse = "participePasse";
		String preterit = "preterit";
		String traduction = "traduction";
		Verbe verbe = new Verbe(baseVerbale, preterit, participePasse, traduction);
		
		try {
			verbeIn = verbeDao.create(verbe);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// Tests
		assertNotNull(verbeIn);
		assertNotNull(verbeIn.getId());
		assertEquals(verbeIn.getBaseVerbale(),verbe.getBaseVerbale());
		assertEquals(verbeIn.getParticipePasse(),verbe.getParticipePasse());
		assertEquals(verbeIn.getPreterit(),verbe.getPreterit());
		assertEquals(verbeIn.getTraduction(),verbe.getTraduction());
	}
	
	
	@Test
	@Order(2)
	@DisplayName("teste la récupération d'un verbe par son Id")
	void testFindOne() {
		verbeOut = null;
		try {
			verbeOut = verbeDao.findOne(verbeIn.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// Tests
		assertNotNull(verbeOut);
		assertNotNull(verbeOut.getId());
		assertTrue(verbeOut.equals(verbeIn));
	}
	
	
	@Test
	@Order(3)
	@DisplayName("teste la recupération de la liste des verbes")
	void testFindAll() {
		try {
			verbes = verbeDao.findAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// Tests
		assertNotNull(verbes);
		assertTrue(verbes.size() > 0);
		assertTrue(verbes.contains(verbeIn));
	}
	
	
	@Test
	@Order(4)
	@DisplayName("teste la récupération d'un verbe aléatoire")
	void testFindAleatoire() {
		verbeOut = null;
		try {
			verbeOut = verbeDao.findAleatoire();
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
	void testDelete() {
		boolean ReleveaEteEfface = false;
		try {
			ReleveaEteEfface = verbeDao.delete(verbeIn.getId());
			verbes = verbeDao.findAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// Tests
		assertTrue(ReleveaEteEfface);
		assertFalse(verbes.contains(verbeIn));
	}
}
