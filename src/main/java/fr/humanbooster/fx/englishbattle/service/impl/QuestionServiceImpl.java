package fr.humanbooster.fx.englishbattle.service.impl;

import java.sql.SQLException;
import java.util.Date;
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
	public Question ajouterQuestion(Question question) {
		try {
			return questionDao.create(question);
		} catch (SQLException e) {
			System.out.println(e);
			return null;
		}
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
	public boolean modify(Long id, Partie partie, Verbe verbe, String reponsePreterit, String reponseParticipePasse,
			Date dateEnvoi, Date dateReponse) {
		try {
			questionDao.modify(id, partie, verbe, reponsePreterit, reponseParticipePasse, dateEnvoi, dateReponse);
			return true;
		} catch (SQLException e) {
			System.out.println(e);
			return false;
		}
	}

}
