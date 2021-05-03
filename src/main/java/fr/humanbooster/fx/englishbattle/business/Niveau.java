package fr.humanbooster.fx.englishbattle.business;
 
public class Niveau {
 
    private Long id;
    private String nom;
    private static Long compteur = 0L;
 
    public Niveau(String nom) {
        super();
        this.id = ++compteur;
        this.nom = nom;
    }


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "Niveau [id=" + id + ", nom=" + nom + "]";
	}


}