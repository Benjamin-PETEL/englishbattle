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

import fr.humanbooster.fx.englishbattle.business.Ville;
import fr.humanbooster.fx.englishbattle.dao.impl.VilleDaoImpl;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class VilleDaoTest {

	
	// ----------------------------- Attributs ----------------------------------
	private static VilleDao villeDao = new VilleDaoImpl();
	private static Ville villeIn = null;
	private static Ville villeOut = null;
	private static List<Ville> villes = new ArrayList<>();

	
	
	// -------------------------------- Tests -----------------------------------
	@Order(1)
	@Test
	void testCreate() {
		String nom = "Marseille";
		try {
			villeIn = villeDao.create(new Ville(nom));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// Tests
		assertNotNull(villeIn);
		assertNotNull(villeIn.getIdVille());
		assertEquals(villeIn.getNom(), nom);
	}
	

	@Order(2)
	@Test
	void testFindOne() {
		try {
			villeOut = villeDao.findOne(villeIn.getIdVille());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// Tests
		assertNotNull(villeOut);
		assertNotNull(villeOut.getIdVille());
		assertNotNull(villeOut.getNom());
		assertEquals(villeOut, villeIn);
	}

	
	@Order(3)
	@Test
	void testFindAll() {
		try {
			villes = villeDao.findAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// Tests
		assertNotNull(villes);
		assertTrue(villes.size() > 0);
		assertTrue(villes.contains(villeIn));
	}

	
	@Order(4)
	@Test
	void testDelete() {
		boolean villeEfface = false;
		try {
			villeEfface = villeDao.delete(villeIn.getIdVille());
			villes = villeDao.findAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// Tests
		assertTrue(villeEfface);
		assertFalse(villes.contains(villeIn));

	}

}
