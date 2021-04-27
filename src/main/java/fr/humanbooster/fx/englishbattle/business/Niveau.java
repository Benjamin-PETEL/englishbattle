package fr.humanbooster.fx.englishbattle.business;
 
public class Niveau {
 
    private Long idNiveau;
    private String nom;
    private static Long compteur = 0L;
 
    public Niveau(String nom) {
        super();
        this.idNiveau = ++compteur;
        this.nom = nom;
    }
 
    public Long getIdNiveau() {
        return idNiveau;
    }
 
    public void setIdNiveau(Long idNiveau) {
        this.idNiveau = idNiveau;
    }
 
    public String getNom() {
        return nom;
    }
 
    public void setNom(String nom) {
        this.nom = nom;
    }
 
    @Override
    public String toString() {
        return "Niveau [idNiveau=" + idNiveau + ", nom=" + nom + "]";
    }
     
}