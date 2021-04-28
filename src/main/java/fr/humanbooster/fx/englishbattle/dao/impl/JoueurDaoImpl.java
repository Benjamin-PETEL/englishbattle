package fr.humanbooster.fx.englishbattle.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.humanbooster.fx.englishbattle.business.Joueur;
import fr.humanbooster.fx.englishbattle.dao.ConnexionBdd;
import fr.humanbooster.fx.englishbattle.dao.JoueurDao;
import fr.humanbooster.fx.englishbattle.dao.NiveauDao;
import fr.humanbooster.fx.englishbattle.dao.Requetes;

public class JoueurDaoImpl implements JoueurDao{
	
	private Connection connexion ;
	private NiveauDao niveauDao;
	public JoueurDaoImpl() {
		try {
			connexion = ConnexionBdd.getConnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	 
	@Override
	public Joueur create(Joueur joueur) throws SQLException {
		PreparedStatement preparedStatement = connexion.prepareStatement(Requetes.AJOUT_JOUEUR, Statement.RETURN_GENERATED_KEYS);
		
		preparedStatement.setString(1, joueur.getEmail());
		preparedStatement.setString(2, joueur.getMotDePasse());
		preparedStatement.setString(3, joueur.getNom());
		preparedStatement.setString(4, joueur.getPrenom());
		preparedStatement.setLong(5, joueur.getNiveau().getIdNiveau());
		preparedStatement.setString(6, joueur.getVille().getNom());
		preparedStatement.executeUpdate();
		ResultSet rs = preparedStatement.getGeneratedKeys();
		if (rs.next()) {
			// On affecte à la compagnie donnée en paramètre l'id choisi par MySql
			joueur.setId(rs.getLong(5));			
			}
		return joueur;
	}

	@Override
	public Joueur findOne(Long id) throws SQLException {
		PreparedStatement preparedStatement = connexion.prepareStatement(Requetes.JOUEUR_PAR_ID, Statement.RETURN_GENERATED_KEYS);
		// On transforme le premier ? par l'id donné en paramètre
		preparedStatement.setLong(1, id);
		ResultSet rs = preparedStatement.executeQuery();
		if (rs .next()) {
			String email = rs.getString("email");
			String nom = rs.getString("nom");
			String prenom = rs.getString("prenom");
			String motDePasse = rs.getString("motDePasse");
			Joueur joueur = new Joueur();
			return joueur;
			}
		return null;
	}

	@Override
	public List<Joueur> findAll() throws SQLException {
		List<Joueur> joueurs = new ArrayList<>();
		PreparedStatement ps = connexion.prepareStatement(Requetes.TOUS_LES_JOUEURS);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Joueur joueur = new Joueur();
			joueur.setId(rs.getLong("id"));
			joueur.setNom(rs.getString("nom"));
			joueur.setPrenom("prenom");
			joueur.setNiveau(niveauDao.findOne(rs.getLong("id")));		}
		return joueurs;
	}

	@Override
	public boolean delete(Joueur joueur) throws SQLException {
		Joueur joueurAEffacer =  findOne(joueur.getId());
		//si l'id du joueur est different de null alors on execute la requete
		if (joueurAEffacer != null) {
			PreparedStatement ps = connexion.prepareStatement(Requetes.SUPPRESSION_JOUEUR);
			ps.executeUpdate();
		}
		
		return false;
	}

	@Override
	public boolean update(Joueur joueur) throws SQLException {
		
		PreparedStatement ps = connexion.prepareStatement(Requetes.UPDATE_JOUEUR);
		ps.setString(1,joueur.getEmail());
		ps.setString(2, joueur.getMotDePasse());
		ps.setString(3, joueur.getNom());
		ps.setString(4, joueur.getPrenom());
		//On recupere l'id du niveau du joueur, cette id me sert à remplacer le 4eme "?"
		ps.setLong(5,joueur.getNiveau().getIdNiveau());
		ps.setLong(6, joueur.getVille().getIdVille());
		ps.executeUpdate();
		
		return true;
	}


}