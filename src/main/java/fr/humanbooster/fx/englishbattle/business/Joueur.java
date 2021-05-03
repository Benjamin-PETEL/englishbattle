package fr.humanbooster.fx.englishbattle.business;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Joueur {

	
	// ----------------------------- Attributs ----------------------------------
	private Long id;	
	private String email;
	private String nom;
	private String prenom;
	private String motDePasse;
	private Niveau niveau;
	private Ville ville;
	private List<Partie> parties = new ArrayList<>();
	
	
	
	// ----------------------------- Constructeurs ------------------------------
	public Joueur() {
		
	}
	
	public Joueur(String email, String motDePasse) {
		super();
		this.email = email;
		this.motDePasse = motDePasse;
	}

	public Joueur(String email, String nom, String prenom, String motDePasse) {
		this();
		this.email = email;
		this.nom = nom;
		this.prenom = prenom;
		this.motDePasse = motDePasse;
	}

	
	
	// ----------------------------- Set - Get ----------------------------------
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

	
	
	// ----------------------------- hashCode -----------------------------------
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((motDePasse == null) ? 0 : motDePasse.hashCode());
		result = prime * result + ((niveau == null) ? 0 : niveau.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((parties == null) ? 0 : parties.hashCode());
		result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
		result = prime * result + ((ville == null) ? 0 : ville.hashCode());
		return result;
	}
	
	
	
	// ------------------------------ equals ------------------------------------
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Joueur other = (Joueur) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (motDePasse == null) {
			if (other.motDePasse != null)
				return false;
		} else if (!motDePasse.equals(other.motDePasse))
			return false;
		if (niveau == null) {
			if (other.niveau != null)
				return false;
		} else if (!niveau.equals(other.niveau))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (parties == null) {
			if (other.parties != null)
				return false;
		} else if (!parties.equals(other.parties))
			return false;
		if (prenom == null) {
			if (other.prenom != null)
				return false;
		} else if (!prenom.equals(other.prenom))
			return false;
		if (ville == null) {
			if (other.ville != null)
				return false;
		} else if (!ville.equals(other.ville))
			return false;
		return true;
	}

	
	
	// ----------------------------- toString -----------------------------------
	@Override
	public String toString() {
		return "Joueur [email=" + email + ", nom=" + nom + ", prenom=" + prenom + ", motDePasse=" + motDePasse + "]";
	}

}