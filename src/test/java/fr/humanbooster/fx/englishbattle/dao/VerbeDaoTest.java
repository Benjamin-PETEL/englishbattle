package fr.humanbooster.fx.englishbattle.dao;

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

	private static VerbeDao verbeDao = new VerbeDaoImpl();
	private static Verbe verbe = null;
	private static List<Verbe> verbes = null;
	
	
	@Test
	@Order(1)
	@DisplayName("teste la création d'un verbe")
	void testCreate() {
		String baseVerbale = "baseVerbale";
		String participePasse = "participePasse";
		String preterit = "preterit";
		String traduction = "traduction";
		Verbe verbe2 = new Verbe(baseVerbale, preterit, participePasse, traduction);
		
		try {
			verbe = verbeDao.create(verbe2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertNotNull(verbe);
		assertNotNull(verbe.getId());
		assertTrue(verbe.equals(verbe2));
	}
	
	@Test
	@Order(2)
	@DisplayName("teste la recupération de la liste des verbes")
	void testFindAll() {
		try {
			verbes = verbeDao.findAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		assertNotNull(verbes);
		assertTrue(verbes.size() > 0);
	}
	
	@Test
	@Order(3)
	@DisplayName("teste la récupération d'un verbe par son Id")
	void testFindOne() {
		Verbe verbe3 = null;
		try {
			verbe3 = verbeDao.findOne(verbe.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		assertNotNull(verbe3);
		assertNotNull(verbe3.getId());
		assertTrue(verbe3.equals(verbe));
	}
	
	@Test
	@Order(4)
	@DisplayName("teste la récupération d'un verbe aléatoire")
	void testFindAleatoire() {
		Verbe verbe4 = null;
		try {
			verbe4 = verbeDao.findAleatoire();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		assertNotNull(verbe4);
		assertNotNull(verbe4.getId());
		assertNotNull(verbe4.getBaseVerbale());
		assertNotNull(verbe4.getParticipePasse());
		assertNotNull(verbe4.getPreterit());
		assertNotNull(verbe4.getTraduction());
	}
	
	
	@Test
	@Order(5)
	@DisplayName("teste la suppression d'un verbe par son Id")
	void testDelete() {
		boolean ReleveaEteEfface = false;
		try {
			ReleveaEteEfface = verbeDao.delete(verbe.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		assertTrue(ReleveaEteEfface);
	}
}
