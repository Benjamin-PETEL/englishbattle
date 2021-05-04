package fr.humanbooster.fx.englishbattle.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.SQLException;
import java.text.ParseException;
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
import fr.humanbooster.fx.englishbattle.dao.impl.VerbeDaoImpl;
import fr.humanbooster.fx.englishbattle.dao.impl.VilleDaoImpl;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class QuestionDaoTest {

	private static QuestionDao questionDao = new QuestionDaoImpl();
	private static PartieDao partieDao = new PartieDaoImpl();
	private static JoueurDao joueurDao = new JoueurDaoImpl();
	private static NiveauDao niveauDao = new NiveauDaoImpl();
	private static VilleDao villeDao = new VilleDaoImpl();
	private static VerbeDao verbeDao = new VerbeDaoImpl();
			
	private static Question questionIn = null;
	private static Question questionOut = null;
	private static List<Question> questions = null;
	private static Joueur joueur = null;
	private static Partie partie = null;
	private static Verbe verbe = null;
	
	@Test
	@Order(1)
	@DisplayName("teste la création d'une question")
	void testCreate() throws SQLException {
		joueur = new Joueur();
		joueur.setNiveau(niveauDao.create(new Niveau("Debutant")));
		joueur.setVille(villeDao.create(new Ville("Aix")));
		joueur = joueurDao.create(joueur);
		partie = partieDao.create(new Partie(joueur));
		verbe = verbeDao.create(new Verbe(String.valueOf(Math.random()),String.valueOf(Math.random()),String.valueOf(Math.random())));
		Question question = new Question(partie, verbe);
		question.setDateReponse(new Date());
		question.setDateEnvoi(new Date());
		try {
			questionIn = questionDao.create(question);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		assertNotNull(questionIn);
		assertNotNull(questionIn.getId());
		assertTrue(questionIn.equals(question));
	}
	
	
	@Test
	@Order(2)
	@DisplayName("teste la recupération de la liste des questions")
	void testFindAll() throws ParseException {
		try {
			questions = questionDao.findAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		assertNotNull(questions);
		assertTrue(questions.size() > 0);
		assertTrue(questions.contains(questionIn));
	}
	
	
	@Test
	@Order(3)
	@DisplayName("teste la récupération d'une question par son Id")
	void testFindOne() throws ParseException {
		questionOut = null;
		try {
			questionOut = questionDao.findOne(questionIn.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		assertNotNull(questionOut);
		assertNotNull(questionOut.getId());
		assertTrue(questionOut.equals(questionIn));
	}
	
	
	@Test
	@Order(4)
	@DisplayName("teste la suppression d'une question par son Id")
	void testDelete() {
		boolean ReleveaEteEfface = false;
		try {
			ReleveaEteEfface = questionDao.delete(questionIn.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		assertTrue(ReleveaEteEfface);
		assertFalse(questions.contains(questionIn));
	}
	
	
	@Test
	@Order(5)
	@DisplayName("teste la modification d'une question par son Id")
	void testModification() throws SQLException {
		//je relance la methode create() pour garantir qu'il y ait au moins un objet dans ma table sinon j'aurais une failure car le test 4 a supprimé celui créé par le test 1
		//testCreate();
		
		verbe = verbeDao.create(new Verbe(String.valueOf(Math.random()),String.valueOf(Math.random()),String.valueOf(Math.random())));
		questionIn.setVerbe(verbe);
		questionOut = null;
		
		try {
			questionOut = questionDao.update(questionIn.getId(), questionIn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		assertNotNull(questionOut);
		assertNotNull(questionOut.getId());
		assertTrue(questionOut.equals(questionIn));
	}
}
