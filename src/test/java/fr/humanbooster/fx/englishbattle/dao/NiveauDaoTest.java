package fr.humanbooster.fx.englishbattle.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import fr.humanbooster.fx.englishbattle.business.Niveau;
import fr.humanbooster.fx.englishbattle.dao.impl.NiveauDaoImpl;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class NiveauDaoTest {

	
	// ----------------------------- Attributs ----------------------------------
	private static NiveauDao niveauDao = new NiveauDaoImpl();
	private static Niveau niveauIn = null;
	private static Niveau niveauOut = null;
	private static List<Niveau> niveaux = new ArrayList<>();

	
	// -------------------------------- Tests -----------------------------------
	@Order(1)
	@Test
	void testCreate() {
		String nom = "TestNiveau";
		try {
			niveauIn = niveauDao.create(new Niveau(nom));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// Tests
		assertNotNull(niveauIn);
		assertNotNull(niveauIn.getId());
		assertEquals(niveauIn.getNom(), nom);
	}
	
	
	@Order(2)
	@Test
	void testFindOne() {
		try {
			niveauOut = niveauDao.findOne(niveauIn.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// Tests
		assertNotNull(niveauOut);
		assertNotNull(niveauOut.getId());
		assertNotNull(niveauOut.getNom());
		assertEquals(niveauOut, niveauIn);
	}
	
	
	@Order(3)
	@Test
	void testFindAll() {
		try {
			niveaux = niveauDao.findAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// Tests
		assertNotNull(niveaux);
		assertTrue(niveaux.size() > 0);
		assertTrue(niveaux.contains(niveauIn));
	}
	
	

}
