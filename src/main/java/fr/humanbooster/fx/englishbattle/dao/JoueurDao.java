package fr.humanbooster.fx.englishbattle.dao;

import java.sql.SQLException;
import java.util.List;

import fr.humanbooster.fx.englishbattle.business.Joueur;

public interface JoueurDao {
	Joueur create() throws SQLException;
	Joueur findOne(Long id) throws SQLException;
	List<Joueur> findAll() throws SQLException;
	boolean delete(Long id)throws SQLException;
}
