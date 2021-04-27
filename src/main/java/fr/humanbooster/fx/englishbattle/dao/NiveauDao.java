package fr.humanbooster.fx.englishbattle.dao;

import java.sql.SQLException;
import java.util.List;


public interface NiveauDao {

	NiveauDao create(NiveauDao niveauDao) throws SQLException;
	List<NiveauDao> findAll() throws SQLException;
	NiveauDao findOne(Long id) throws SQLException;
	boolean delete(Long id) throws SQLException;
	
	
	
	}
	

