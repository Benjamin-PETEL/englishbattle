package fr.humanbooster.fx.englishbattle.dao;

public class Requetes {

        // Requetes des verbes
        public static final String AJOUT_VERBE = "INSERT INTO verbe (baseVerbale, participePasse, preterit, traduction) VALUES (? , ? , ? , ?)";
        public static final String VERBE_PAR_ID = "SELECT id, baseVerbale, participePasse, preterit, traduction FROM verbe WHERE id= ?";
        public static final String TOUS_LES_VERBES = "SELECT id, baseVerbale, participePasse, preterit, traduction FROM verbe";
        public static final String VERBE_ALEATOIRE = "SELECT id, baseVerbale, participePasse, preterit, traduction FROM verbe ORDER BY rand() LIMIT 1";
        public static final String SUPPRESSION_VERBE = "DELETE FROM verbe WHERE id = ?";

        // Requetes des questions
        public static final String AJOUT_QUESTION = "INSERT INTO question (partie_id, verbe_id, reponsePreterit, reponseParticipePasse, dateEnvoi, dateReponse) VALUES (?,?,?,?,?,?)";
        public static final String UPDATE_QUESTION = "UPDATE question SET partie_id = ?, verbe_id = ?, reponsePreterit = ?, reponseParticipePasse = ?, dateEnvoi = ?, dateReponse = ? WHERE id = ?";
        public static final String QUESTION_PAR_ID = "SELECT id, partie_id, verbe_id, reponsePreterit, reponseParticipePasse, dateEnvoi, dateReponse FROM question WHERE id = ?";
        public static final String TOUS_LES_QUESTIONS = "SELECT id, partie_id, verbe_id, reponsePreterit, reponseParticipePasse, dateEnvoi, dateReponse FROM question";
        public static final String SUPPRESSION_QUESTION = "DELETE FROM question WHERE id = ?";

        // Requetes des niveaux
        public static final String AJOUT_NIVEAU = "INSERT INTO niveau (nom) VALUES (?)";
        public static final String NIVEAU_PAR_ID = "SELECT id, nom FROM niveau WHERE id=?";
        public static final String TOUS_LES_NIVEAUX = "SELECT id, nom FROM niveau";

        // Requetes des joueurs
        public static final String AJOUT_JOUEUR = "INSERT INTO joueur (email, motDePasse, nom, prenom, niveau_id, ville_id) VALUES (?,?,?,?,?,?)";
        public static final String UPDATE_JOUEUR = "UPDATE joueur SET email = ?, motDePasse = ?, nom = ?, prenom = ?, niveau_id = ?, ville_id = ? WHERE id = ?";
        public static final String JOUEUR_PAR_ID = "SELECT id, email, motDePasse, nom, prenom, niveau_id, ville_id FROM joueur WHERE id=?";
        public static final String TOUS_LES_JOUEURS = "SELECT id, email, motDePasse, nom, prenom, niveau_id, ville_id FROM joueur";
        public static final String SUPPRESSION_JOUEUR = "DELETE FROM joueur WHERE id = ?";

        // Requetes des villes
        public static final String AJOUT_VILLE = "INSERT INTO ville (nom) VALUES (?)";
        public static final String VILLE_PAR_ID = "SELECT id, nom FROM ville WHERE id=?";
        public static final String VILLE_PAR_NOM = "SELECT id, nom FROM ville WHERE nom=?";
        public static final String TOUTES_LES_VILLES = "SELECT id, nom FROM ville";
        public static final String SUPPRESSION_VILLE = "DELETE FROM ville WHERE id=?";

        // Requetes des parties
        public static final String AJOUT_PARTIE = "INSERT INTO partie (joueur_id) VALUES (?)";
        public static final String PARTIE_PAR_ID = "SELECT id, joueur_id FROM partie WHERE id=?";
        public static final String TOUTES_LES_PARTIES = "SELECT id, joueur_id FROM partie";
        public static final String UPDATE_PARTIE = "UPDATE partie SET joueur_id=? WHERE id =?";
        public static final String SUPPRESSION_PARTIE = "DELETE FROM partie WHERE id=?";

}
