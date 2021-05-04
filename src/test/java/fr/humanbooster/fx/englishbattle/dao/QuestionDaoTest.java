package fr.humanbooster.fx.englishbattle.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import fr.humanbooster.fx.englishbattle.business.Joueur;
import fr.humanbooster.fx.englishbattle.business.Niveau;
import fr.humanbooster.fx.englishbattle.business.Partie;
import fr.humanbooster.fx.englishbattle.business.Question;
import fr.humanbooster.fx.englishbattle.business.Verbe;
import fr.humanbooster.fx.englishbattle.business.Ville;
import fr.humanbooster.fx.englishbattle.dao.impl.JoueurDaoImpl;
import fr.humanbooster.fx.englishbattle.dao.impl.NiveauDaoImpl;
import fr.humanbooster.fx.englishbattle.dao.impl.PartieDaoImpl;
import fr.humanbooster.fx.englishbattle.dao.impl.QuestionDaoImpl;
import fr.humanbooster.fx.englishbattle.dao.impl.VilleDaoImpl;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class QuestionDaoTest {

	private static QuestionDao questionDao = new QuestionDaoImpl();
	private static PartieDao partieDao = new PartieDaoImpl();
	private static JoueurDao joueurDao = new JoueurDaoImpl();
	private static NiveauDao niveauDao = new NiveauDaoImpl();
	private static VilleDao villeDao = new VilleDaoImpl();
			
	private static Question question = null;
	private static List<Question> questions = null;
	private static Joueur joueur = null;
	private static Partie partie = null;
	private static Verbe verbe = new Verbe("baseverbaleTest","preteritTest","participePasseTest");
	
	@Test
	@Order(1)
	@DisplayName("teste la création d'une question")
	void testCreate() throws SQLException {
		joueur = new Joueur();
		joueur.setNiveau(niveauDao.create(new Niveau("Debutant")));
		joueur.setVille(villeDao.create(new Ville("Aix")));
		joueur = joueurDao.create(joueur);
		partie = partieDao.create(new Partie(joueur));
		Question question2 = new Question(partie, verbe);
		question2.setDateReponse(new Date());
		try {
			question = questionDao.create(question2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		assertNotNull(question);
		assertNotNull(question.getId());
		assertTrue(question.equals(question2));
	}
	
	@Test
	@Order(2)
	@DisplayName("teste la recupération de la liste des questions")
	void testFindAll() {
		try {
			questions = questionDao.findAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		assertNotNull(questions);
		assertTrue(questions.size() > 0);
	}
	
	@Test
	@Order(3)
	@DisplayName("teste la récupération d'une question par son Id")
	void testFindOne() {
		Question question2 = null;
		try {
			question2 = questionDao.findOne(question.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		assertNotNull(question2);
		assertNotNull(question2.getId());
	}
	
	@Test
	@Order(4)
	@DisplayName("teste la suppression d'une question par son Id")
	void testDelete() {
		boolean ReleveaEteEfface = false;
		try {
			ReleveaEteEfface = questionDao.delete(question.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		assertTrue(ReleveaEteEfface);
	}
	
	@Test
	@Order(5)
	@DisplayName("teste la modification d'une question par son Id")
	void testModification() {
		//je relance la methode create() pour garantir qu'il y ait au moins un objet dans ma table sinon j'aurais une failure car le test 4 a supprimé celui créé par le test 1
		testCreate();
		Verbe verbe = new Verbe("baseverbaleTest","preteritTestModification","participePasseTestModification");
		Question questionTest = null;
		
		try {
			questionTest = questionDao.findAll().get(0);
			questionTest.setVerbe(verbe);
			questionDao.update(questionTest.getId(), questionTest);
			questionTest = questionDao.findAll().get(0);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		assertEquals(questionTest.getReponsePreterit(),verbe.getPreterit());
		assertEquals(questionTest.getReponseParticipePasse(),verbe.getParticipePasse());
	}
}
