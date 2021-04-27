package fr.humanbooster.fx.englishbattle.service.impl;

import java.sql.SQLException;
import java.util.List;

import fr.humanbooster.fx.englishbattle.business.Verbe;
import fr.humanbooster.fx.englishbattle.dao.VerbeDao;
import fr.humanbooster.fx.englishbattle.dao.impl.VerbeDaoImpl;
import fr.humanbooster.fx.englishbattle.service.VerbeService;

public class VerbeServiceImpl implements VerbeService {

	VerbeDao verbeDao = new VerbeDaoImpl();
	
	@Override
	public Verbe ajouterVerbe(Verbe verbe) {
		try {
			return verbeDao.create(verbe);
		} catch (SQLException e) {
			System.out.println(e);
			return null;
		}
	}

	@Override
	public List<Verbe> recupererVerbes() {
		try {
			return verbeDao.findAll();
		} catch (SQLException e) {
			System.out.println(e);
			return null;
		}
	}

	@Override
	public Verbe recupererVerbe(Long id) {
		try {
			return verbeDao.findOne(id);
		} catch (SQLException e) {
			System.out.println(e);
			return null;
		}
	}

	@Override
	public Verbe recupererAleatoire() {
		try {
			return verbeDao.findAleatoire();
		} catch (SQLException e) {
			System.out.println(e);
			return null;
		}
	}

	@Override
	public boolean supprimerVerbe(Long id) {
		try {
			return verbeDao.delete(id);
		} catch (SQLException e) {
			System.out.println(e);
			return false;
		}
	}


}
