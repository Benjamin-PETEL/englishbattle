package fr.humanbooster.fx.englishbattle.business;
 
public class Ville {
 
	// ----------------------------- Attributs ----------------------------------
    private Long idVille;
    private String nom;
    private int nbHabitants;
    private static Long compteur = 0L;
    
    
    // ----------------------------- Constructeurs ------------------------------
    public Ville(String nom) {
        super();
        this.idVille = ++compteur;
        this.nom = nom;
    }
 
    public Ville(String nom, int nbHabitants) {
        this(nom);
        this.nbHabitants = nbHabitants;
    }
    
    
    // ----------------------------- Set - Get ----------------------------------
    public Long getIdVille() {
        return idVille;
    }
 
    public void setIdVille(Long id) {
        this.idVille = id;
    }
 
    public String getNom() {
        return nom;
    }
 
    public void setNom(String nom) {
        this.nom = nom;
    }
 
    public int getNbHabitants() {
    	return nbHabitants;
    }
    
    public void setNbHabitants(int nbHabitants) {
    	this.nbHabitants = nbHabitants;
    }
    
    
	// ----------------------------- hashCode -----------------------------------   
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idVille == null) ? 0 : idVille.hashCode());
		result = prime * result + nbHabitants;
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
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
		Ville other = (Ville) obj;
		if (idVille == null) {
			if (other.idVille != null)
				return false;
		} else if (!idVille.equals(other.idVille))
			return false;
		if (nbHabitants != other.nbHabitants)
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		return true;
	}

	
	// ----------------------------- toString -----------------------------------
    @Override
    public String toString() {
        return "Ville [id=" + idVille + ", nom=" + nom + "]";
    }
 
     
}