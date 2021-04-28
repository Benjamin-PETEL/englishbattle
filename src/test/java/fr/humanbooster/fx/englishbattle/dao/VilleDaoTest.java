package fr.humanbooster.fx.englishbattle.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
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

	private static VilleDao villeDao = new VilleDaoImpl();
	private static Ville ville = null;
	private static List<Ville> villes = new ArrayList<>();

	@Order(1)
	@Test
	void testCreate() {
		String nom = "Marseille";

		try {
			ville = villeDao.create(new Ville(nom));
		} catch (SQLException e) {

			e.printStackTrace();
		}
		assertNotNull(ville);
		assertNotNull(ville.getIdVille());
		assertEquals(ville.getNom(), nom);

	}

	@Order(2)
	@Test
	void testFindOne() {

		Ville villeOutPut = null;
		try {
			villeOutPut = villeDao.findOne(ville.getIdVille());
		} catch (SQLException e) {
			e.printStackTrace();
		}

		assertNotNull(villeOutPut);
		assertNotNull(villeOutPut.getIdVille());
		assertNotNull(villeOutPut.getNom());

		assertEquals(villeOutPut, ville);
	}

	@Order(3)
	@Test
	void testFindAll() {
		try {
			villes = villeDao.findAll();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		assertNotNull(villes);
		assertTrue(villes.size() > 0);
	}

	@Order(4)
	@Test
	void testDelete() {
		
		boolean villeEfface = false;
		try {
			villeEfface = villeDao.delete(ville.getIdVille());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertTrue(villeEfface);

	}

}
