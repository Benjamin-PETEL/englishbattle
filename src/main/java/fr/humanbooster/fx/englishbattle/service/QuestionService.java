package fr.humanbooster.fx.englishbattle.service;

import java.util.List;

import fr.humanbooster.fx.englishbattle.business.Question;

public interface QuestionService {

	Question ajouterQuestion(String nom);
	
	List<Question> recupererQuestions();
	
	Question recupererQuestion(Long id);
	
	boolean supprimerQuestion(Long id);
	
	
}
