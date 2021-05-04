package fr.humanbooster.fx.englishbattle.business;

import java.util.Calendar;
import java.util.Date;

public class Question {

	// ----------------------------- Attributs ----------------------------------
	private Long id;	
	private Partie partie;	
	private Verbe verbe;
	private String reponsePreterit;
	private String reponseParticipePasse;
	private Date dateEnvoi;
	private Date dateReponse;
	
	
	
	// ----------------------------- Constructeurs ------------------------------
	public Question(Partie partie, Verbe verbe) {
		this.partie = partie;
		this.verbe = verbe;
		this.dateEnvoi = new Date();
	}

	
	
	// ----------------------------- Set - Get ----------------------------------
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Partie getPartie() {
		return partie;
	}

	public void setPartie(Partie partie) {
		this.partie = partie;
	}

	public Verbe getVerbe() {
		return verbe;
	}

	public void setVerbe(Verbe verbe) {
		this.verbe = verbe;
	}

	public String getReponsePreterit() {
		return reponsePreterit;
	}

	public void setReponsePreterit(String reponsePreterit) {
		this.reponsePreterit = reponsePreterit;
	}

	public String getReponseParticipePasse() {
		return reponseParticipePasse;
	}

	public void setReponseParticipePasse(String reponseParticipePasse) {
		this.reponseParticipePasse = reponseParticipePasse;
	}

	public Date getDateEnvoi() {
		return dateEnvoi;
	}

	public void setDateEnvoi(Date dateEnvoi) {
		this.dateEnvoi = dateEnvoi;
	}

	public Date getDateReponse() {
		return dateReponse;
	}

	public void setDateReponse(Date dateReponse) {
		this.dateReponse = dateReponse;
	}

	
	
	// ------------------------------- Methode ----------------------------------
	public long getNbSecondesRestantes() {
		// dateEnvoi + 60 secondes
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dateEnvoi);
		calendar.add(Calendar.SECOND, 60);
		Date maintenant = new Date();
		return (calendar.getTime().getTime() - maintenant.getTime())/1000;
	}
	
	
	
	// ----------------------------- hashCode -----------------------------------
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateEnvoi == null) ? 0 : dateEnvoi.hashCode());
		result = prime * result + ((dateReponse == null) ? 0 : dateReponse.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((partie == null) ? 0 : partie.hashCode());
		result = prime * result + ((reponseParticipePasse == null) ? 0 : reponseParticipePasse.hashCode());
		result = prime * result + ((reponsePreterit == null) ? 0 : reponsePreterit.hashCode());
		result = prime * result + ((verbe == null) ? 0 : verbe.hashCode());
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
		Question other = (Question) obj;
		if (dateEnvoi == null) {
			if (other.dateEnvoi != null)
				return false;
		} else if (!dateEnvoi.equals(other.dateEnvoi))
			return false;
		if (dateReponse == null) {
			if (other.dateReponse != null)
				return false;
		} else if (!dateReponse.equals(other.dateReponse))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (partie == null) {
			if (other.partie != null)
				return false;
		} else if (!partie.equals(other.partie))
			return false;
		if (reponseParticipePasse == null) {
			if (other.reponseParticipePasse != null)
				return false;
		} else if (!reponseParticipePasse.equals(other.reponseParticipePasse))
			return false;
		if (reponsePreterit == null) {
			if (other.reponsePreterit != null)
				return false;
		} else if (!reponsePreterit.equals(other.reponsePreterit))
			return false;
		if (verbe == null) {
			if (other.verbe != null)
				return false;
		} else if (!verbe.equals(other.verbe))
			return false;
		return true;
	}



	// ----------------------------- toString -----------------------------------
	@Override
	public String toString() {
		return "Question [verbe=" + verbe + ", reponsePreterit=" + reponsePreterit
				+ ", reponseParticipePasse=" + reponseParticipePasse + ", dateEnvoi=" + dateEnvoi + ", dateReponse="
				+ dateReponse + "]";
	}
	
}

