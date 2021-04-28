package fr.humanbooster.fx.englishbattle.servlets;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.humanbooster.fx.englishbattle.business.Joueur;
import fr.humanbooster.fx.englishbattle.service.JoueurService;
import fr.humanbooster.fx.englishbattle.service.NiveauService;
import fr.humanbooster.fx.englishbattle.service.VilleService;
import fr.humanbooster.fx.englishbattle.service.impl.JoueurServiceImpl;
import fr.humanbooster.fx.englishbattle.service.impl.NiveauServiceImpl;
import fr.humanbooster.fx.englishbattle.service.impl.VilleServiceImpl;

/**
 * Servlet implementation class InscriptionServlet
 */
@WebServlet(urlPatterns = "/inscription", loadOnStartup=1)
public class InscriptionServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
	private JoueurService joueurService = new JoueurServiceImpl();
	private NiveauService niveauService = new NiveauServiceImpl();
	private VilleService villeService = new VilleServiceImpl();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public InscriptionServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("EMAIL");
		String nom = request.getParameter("NOM");
		String prenom = request.getParameter("PRENOM");
		String motDePasse = request.getParameter("MOT_DE_PASSE");
		Long idNiveau = Long.parseLong(request.getParameter("ID_NIVEAU"));
		Long idVille = Long.parseLong(request.getParameter("ID_VILLE"));
		joueurService.ajouterJoueur(email, nom, prenom, motDePasse, idNiveau, idVille);
		response.sendRedirect("index");
	}

}
