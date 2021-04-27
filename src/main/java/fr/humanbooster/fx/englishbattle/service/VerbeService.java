package fr.humanbooster.fx.englishbattle.service;

import java.util.List;

import fr.humanbooster.fx.englishbattle.business.Verbe;

public interface VerbeService {
	
	Verbe ajouterVerbe(Verbe verbe);
	List<Verbe> recupererVerbes();
	Verbe recupererVerbe(Long id);
	Verbe recupererAleatoire();
	boolean supprimerVerbe(Long id);
}
