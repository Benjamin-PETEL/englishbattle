package fr.humanbooster.fx.englishbattle.service.impl;

import java.sql.SQLException;
import java.util.List;

import fr.humanbooster.fx.englishbattle.business.Partie;
import fr.humanbooster.fx.englishbattle.business.Question;
import fr.humanbooster.fx.englishbattle.business.Verbe;
import fr.humanbooster.fx.englishbattle.dao.QuestionDao;
import fr.humanbooster.fx.englishbattle.dao.impl.QuestionDaoImpl;
import fr.humanbooster.fx.englishbattle.service.QuestionService;

public class QuestionServiceImpl implements QuestionService {

	QuestionDao questionDao = new QuestionDaoImpl();
	
	@Override
	public Question ajouterQuestion(Partie partie, Verbe verbe) {
        Question question = new Question(partie, verbe);
        partie.addQuestion(question);
        return question;
	}

	@Override
	public List<Question> recupererQuestions() {
		try {
			return questionDao.findAll();
		} catch (SQLException e) {
			System.out.println(e);
			return null;
		}
	}

	@Override
	public Question recupererQuestion(Long id) {
		try {
			return questionDao.findOne(id);
		} catch (SQLException e) {
			System.out.println(e);
			return null;
		}
	}

	@Override
	public boolean supprimerQuestion(Long id) {
		try {
			return questionDao.delete(id);
		} catch (SQLException e) {
			System.out.println(e);
			return false;
		}
	}

	@Override
	public boolean mettreAJourQuestion(Long id, String reponsePreterit, String reponseParticipePasse) {
		try {
			Question question = questionDao.findOne(id);
			question.setReponsePreterit(reponsePreterit);
			question.setReponseParticipePasse(reponseParticipePasse);
			questionDao.update(id, question);
			return true;
		} catch (SQLException e) {
			System.out.println(e);
			return false;
		}
	}

	@Override
	public boolean verifierReponse(Question question) {
		if(!question.getVerbe().getPreterit().equals(question.getReponsePreterit())) {
			return false;
		}
		if(!question.getVerbe().getParticipePasse().equals(question.getReponseParticipePasse())) {
			return false;
		}
		return true;
	}

}
