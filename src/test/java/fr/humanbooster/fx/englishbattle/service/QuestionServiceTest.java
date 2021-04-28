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

import fr.humanbooster.fx.englishbattle.business.Joueur;
import fr.humanbooster.fx.englishbattle.business.Partie;
import fr.humanbooster.fx.englishbattle.business.Question;
import fr.humanbooster.fx.englishbattle.business.Verbe;
import fr.humanbooster.fx.englishbattle.service.impl.QuestionServiceImpl;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class QuestionServiceTest {

	private static QuestionService questionService = new QuestionServiceImpl();
	private static Question question = null;
	private static List<Question> questions = null;
	private static Joueur joueur = new Joueur("email test","mdp test");
	private static Partie partie = new Partie(joueur);
	private static Verbe verbe = new Verbe("baseverbaleTest","preteritTest","participePasseTest");
	
	
	@Test
	@Order(1)
	@DisplayName("teste la création d'une question")
	void testAjouterQuestion() {
		Question question2 = new Question(partie, verbe);
		question = questionService.ajouterQuestion(question2);
		assertNotNull(question);
		assertNotNull(question.getId());
		assertTrue(question.equals(question2));
	}

	@Test
	@Order(2)
	@DisplayName("teste la recupération d'une question")
	void testRecupererQuestion() {
		Question question2 = null;
		question2 = questionService.recupererQuestion(question.getId());
		assertNotNull(question2.getId());
		assertTrue(question2.getId() > 0);
	}

	@Test
	@Order(3)
	@DisplayName("teste la récupération d'une liste de questions")
	void testRecupererQuestions() {
		questions = questionService.recupererQuestions();
		assertFalse(questions.isEmpty());
		
		for (Question question : questions) {
			assertNotNull(question.getId());
			assertTrue(question.getId() > 0);
		}
	}
	
	
	@Test
	@Order(4)
	@DisplayName("teste la suppression d'une question par son Id")
	void testDeleteQuestion() {
		boolean ReleveaEteEfface = false;
		ReleveaEteEfface = questionService.supprimerQuestion(question.getId());
		assertTrue(ReleveaEteEfface);
	}
	
	@Test
	@Order(5)
	@DisplayName("teste la modification d'une question par son Id")
	void testModification() {
		//je relance la methode create() pour garantir qu'il y ait au moins un objet dans ma table sinon j'aurais une failure car le test 4 a supprimé celui créé par le test 1
		testAjouterQuestion();
		Question questionTest = null;
		String nouvelleReponsePreterit = "test";
		String nouvelleReponseParticipePasse = "test";

		
		questionTest = questionService.recupererQuestions().get(0);
		questionService.modify(question.getId(), partie, verbe, nouvelleReponsePreterit, nouvelleReponseParticipePasse, null, null);
		questionTest = questionService.recupererQuestions().get(0);

		assertEquals(questionTest.getReponsePreterit(),nouvelleReponsePreterit);
		assertEquals(questionTest.getReponseParticipePasse(),nouvelleReponseParticipePasse);
	}
}
