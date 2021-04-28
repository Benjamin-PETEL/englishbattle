package fr.humanbooster.fx.englishbattle.service;

import java.util.List;

import fr.humanbooster.fx.englishbattle.business.Partie;
import fr.humanbooster.fx.englishbattle.business.Question;
import fr.humanbooster.fx.englishbattle.business.Verbe;

public interface QuestionService {

	Question ajouterQuestion(Partie partie, Verbe verbe);
	
	List<Question> recupererQuestions();
	
	Question recupererQuestion(Long id);
	
	boolean supprimerQuestion(Long id);
	
	/**
	 * 
	 * @param id
	 * @param String reponsePreterit
	 * @param String reponseParticipePasse
	 * @return true si la question est mise à jour / false sinon
	 */
	boolean mettreAJourQuestion(Long id, String reponsePreterit, String reponseParticipePasse);
}
