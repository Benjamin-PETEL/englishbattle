package fr.humanbooster.fx.englishbattle.business;
 
public class Ville {
 
    private Long idVille;
    private String nom;
    private int nbHabitants;
    private static Long compteur = 0L;
     
    public Ville(String nom) {
        super();
        this.idVille = ++compteur;
        this.nom = nom;
    }
 
    public Ville(String nom, int nbHabitants) {
        this(nom);
        this.nbHabitants = nbHabitants;
    }
     
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
 
    @Override
    public String toString() {
        return "Ville [id=" + idVille + ", nom=" + nom + "]";
    }
 
    public int getNbHabitants() {
        return nbHabitants;
    }
 
    public void setNbHabitants(int nbHabitants) {
        this.nbHabitants = nbHabitants;
    }
     
}