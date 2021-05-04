package fr.humanbooster.fx.englishbattle.business;

import java.util.ArrayList;
import java.util.List;

public class Partie implements Comparable<Partie>{
	
	
	private Long id;
	private Joueur joueur;
	private List<Question> questions = new ArrayList<>();

	
	
	public Partie(Joueur joueur) {
		this.joueur = joueur;
	}

	public Joueur getJoueur() {
		return joueur;
	}

	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public Question getDerniereQuestion() {
		if (questions.isEmpty()) return null;
		return questions.get(questions.size()-1);
	}

	public int getNbQuestions()
	{
		return questions.size();
	}
	
	public int getScore() {
		if (questions.isEmpty()) { return 0; }
		return questions.size()-1;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public void addQuestion(Question question) {
		questions.add(question);
	}
	
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((joueur == null) ? 0 : joueur.hashCode());
		result = prime * result + ((questions == null) ? 0 : questions.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Partie other = (Partie) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (joueur == null) {
			if (other.joueur != null)
				return false;
		} else if (!joueur.equals(other.joueur))
			return false;
		if (questions == null) {
			if (other.questions != null)
				return false;
		} else if (!questions.equals(other.questions))
			return false;
		return true;
	}

	@Override
	public int compareTo(Partie autrePartie) {
		if (questions.size()==autrePartie.questions.size()) {
		return 0;
		}
		else if (questions.size()>autrePartie.questions.size()) return 1;
		else return -1;
	}
	
	@Override
	public String toString() {
		return "Partie [joueur=" + joueur + ", questions=" + questions + "]";
	}
	
}

