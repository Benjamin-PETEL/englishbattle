package fr.humanbooster.fx.englishbattle.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import fr.humanbooster.fx.englishbattle.business.Partie;
import fr.humanbooster.fx.englishbattle.business.Question;
import fr.humanbooster.fx.englishbattle.business.Verbe;
import fr.humanbooster.fx.englishbattle.dao.ConnexionBdd;
import fr.humanbooster.fx.englishbattle.dao.PartieDao;
import fr.humanbooster.fx.englishbattle.dao.QuestionDao;
import fr.humanbooster.fx.englishbattle.dao.Requetes;
import fr.humanbooster.fx.englishbattle.dao.VerbeDao;

public class QuestionDaoImpl implements QuestionDao, AutoCloseable{
	
	// ----------------------------- Attributs ----------------------------------
	private Connection connexion;
	private static VerbeDao verbeDao = new VerbeDaoImpl();
	private static PartieDao partieDao = new PartieDaoImpl();
	private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	
	// ----------------------------- Constructeurs ------------------------------
	public QuestionDaoImpl() {
		try {
			connexion = ConnexionBdd.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public Question create(Question question) throws SQLException {
		// voir methode initialiseStatement en bas de page
		PreparedStatement ps = initialiseStatement(Requetes.AJOUT_QUESTION, question);
		ps.executeUpdate();
		ResultSet rs = ps.getGeneratedKeys();
		if (rs.next()) {
			question.setId(rs.getLong(1));
		}
		return question;
	}

	@Override
	public List<Question> findAll() throws SQLException, ParseException {
        List<Question> questions = new ArrayList<>();
        PreparedStatement ps = connexion.prepareStatement(Requetes.TOUS_LES_QUESTIONS);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            questions.add(findOne(rs.getLong("id")));
        }
        return questions;
	}

	@Override
	public Question findOne(Long id) throws SQLException, ParseException {
		Question question = null;
        PreparedStatement ps = connexion.prepareStatement(Requetes.QUESTION_PAR_ID);
        ps.setLong(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
        	Partie partie = partieDao.findOne(rs.getLong("partie_id"));
        	Verbe verbe = verbeDao.findOne(rs.getLong("verbe_id"));
            question = new Question(partie, verbe);
            question.setId(id);
            question.setDateEnvoi(simpleDateFormat.parse(rs.getString("dateEnvoi")));
            question.setDateReponse(simpleDateFormat.parse(rs.getString("dateReponse")));
            question.setReponsePreterit(rs.getString("reponsePreterit"));
            question.setReponseParticipePasse(rs.getString("reponseParticipePasse"));
        }
        return question;
	}

	@Override
	public boolean delete(Long id) throws SQLException {
		PreparedStatement ps = connexion.prepareStatement(Requetes.SUPPRESSION_QUESTION);
		ps.setLong(1, id);
		try {
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Question update(Long id, Question nouvelleQuestion) throws SQLException {
		PreparedStatement ps = initialiseStatement(Requetes.UPDATE_QUESTION, nouvelleQuestion);
		ps.setLong(7, id);
		ps.executeUpdate();
		ResultSet rs = ps.getGeneratedKeys();
		if (rs.next()) {
			nouvelleQuestion.setId(rs.getLong(1));
			return nouvelleQuestion;
		}
		else {
			return null;
		}
	}
	
	private PreparedStatement initialiseStatement(String requete, Question question) throws SQLException {
		PreparedStatement ps = connexion.prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);
		Date dateEnvoie = new java.sql.Date(question.getDateEnvoi().getTime());
		Date dateReponse = new java.sql.Date(question.getDateReponse().getTime());
		ps.setLong(1, question.getPartie().getId());
		ps.setLong(2, question.getVerbe().getId());
		ps.setString(3, question.getReponsePreterit());
		ps.setString(4, question.getReponseParticipePasse());
		ps.setString(5, simpleDateFormat.format(dateReponse));
		ps.setString(6, simpleDateFormat.format(dateEnvoie));
		return ps;
	}

	@Override
	public void close() throws Exception {
		connexion.close();
	}
	

}
