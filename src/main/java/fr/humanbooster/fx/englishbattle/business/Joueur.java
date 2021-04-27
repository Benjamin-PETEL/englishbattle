package fr.humanbooster.fx.englishbattle.business;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Joueur {

	private Long id;	
	private String email;
	private String nom;
	private String prenom;
	private String motDePasse;
	private Niveau niveau;
	private Ville ville;
	private List<Partie> parties = new ArrayList<>();
	
	public Joueur(String email, String nom, String prenom, String motDePasse) {
		super();
		this.email = email;
		this.nom = nom;
		this.prenom = prenom;
		this.motDePasse = motDePasse;
	}

	public Joueur(String email, String motDePasse) {
		this.email = email;
		this.motDePasse = motDePasse;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long idJoueur) {
		this.id = idJoueur;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public int getMeilleurScore() {
		// Trie les parties du joueur sur le score et renvoie le score de la meilleure
		if (parties.isEmpty()) { return 0; }
		Collections.sort(parties);
		return parties.get(parties.size()-1).getScore();
	}
	
	public void addPartie(Partie partie) {
		parties.add(partie);
	}
	
	public Niveau getNiveau() {
		return niveau;
	}

	public void setNiveau(Niveau niveau) {
		this.niveau = niveau;
	}

	public Ville getVille() {
		return ville;
	}

	public void setVille(Ville ville) {
		this.ville = ville;
	}

	@Override
	public String toString() {
		return "Joueur [email=" + email + ", nom=" + nom + ", prenom=" + prenom + ", motDePasse=" + motDePasse + "]";
	}

}