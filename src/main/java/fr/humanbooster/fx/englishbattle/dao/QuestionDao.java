package fr.humanbooster.fx.englishbattle.dao;

import java.sql.SQLException;
import java.util.List;

import fr.humanbooster.fx.englishbattle.business.Question;


public interface QuestionDao {
	Question create(Question question) throws SQLException;
	List<Question> findAll() throws SQLException;
	Question findOne(Long id) throws SQLException;
	boolean delete(Long id) throws SQLException;
	Question modify(Long id, Question nouvelleQuestion) throws SQLException;
}
