package fr.humanbooster.fx.englishbattle.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.humanbooster.fx.englishbattle.business.Verbe;
import fr.humanbooster.fx.englishbattle.dao.ConnexionBdd;
import fr.humanbooster.fx.englishbattle.dao.Requetes;
import fr.humanbooster.fx.englishbattle.dao.VerbeDao;

public class VerbeDaoImpl implements VerbeDao, AutoCloseable{

	private Connection connexion;

	public VerbeDaoImpl() {
		try {
			connexion = ConnexionBdd.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public Verbe create(Verbe verbe) throws SQLException {
		PreparedStatement ps = connexion.prepareStatement(Requetes.AJOUT_VERBE, Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, verbe.getBaseVerbale());
		ps.setString(2, verbe.getParticipePasse());
		ps.setString(3, verbe.getPreterit());
		ps.setString(4, verbe.getTraduction());
		ps.executeUpdate();
		ResultSet rs = ps.getGeneratedKeys();
		Verbe newVerbe = new Verbe(verbe.getBaseVerbale(), verbe.getPreterit(), verbe.getParticipePasse(), verbe.getTraduction());
		if (rs.next()) {
			newVerbe.setId(rs.getLong(1));
		}
		return newVerbe;
	}

	@Override
	public List<Verbe> findAll() throws SQLException {
		List<Verbe> verbes = new ArrayList<>();
		PreparedStatement ps = connexion.prepareStatement(Requetes.TOUS_LES_VERBES);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Verbe verbe = new Verbe(rs.getString("baseVerbale"), rs.getString("preterit"), rs.getString("participePasse"), rs.getString("traduction"));
			verbe.setId(rs.getLong("id"));
			verbes.add(verbe);
		}
		return verbes;
	}

	@Override
	public Verbe findOne(Long id) throws SQLException {
		Verbe Verbe2 = null;
		PreparedStatement ps = connexion.prepareStatement(Requetes.VERBE_PAR_ID);
		ps.setLong(1, id);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			Verbe2 = new Verbe(rs.getString("baseVerbale"), rs.getString("preterit"), rs.getString("participePasse"), rs.getString("traduction"));
			Verbe2.setId(rs.getLong("id"));
		}
		return Verbe2;
	}

	@Override
	public Verbe findAleatoire() throws SQLException {
		Verbe Verbe2 = null;
		PreparedStatement ps = connexion.prepareStatement(Requetes.VERBE_ALEATOIRE);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			Verbe2 = new Verbe(rs.getString("baseVerbale"), rs.getString("preterit"), rs.getString("participePasse"), rs.getString("traduction"));
			Verbe2.setId(rs.getLong("id"));
		}
		return Verbe2;
	}

	@Override
	public boolean delete(Long id) throws SQLException {
		Verbe verbe = findOne(id);
		if (verbe==null) {
			return false;
		}
		PreparedStatement ps = connexion.prepareStatement(Requetes.SUPPRESSION_VERBE);
		ps.setLong(1, id);
		ps.executeUpdate();
		return true;
	}

	@Override
	public void close() throws Exception {
		connexion.close();
	}

}
