package fr.humanbooster.fx.englishbattle.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.humanbooster.fx.englishbattle.business.Joueur;
import fr.humanbooster.fx.englishbattle.business.Niveau;
import fr.humanbooster.fx.englishbattle.business.Ville;
import fr.humanbooster.fx.englishbattle.service.JoueurService;
import fr.humanbooster.fx.englishbattle.service.NiveauService;
import fr.humanbooster.fx.englishbattle.service.VilleService;
import fr.humanbooster.fx.englishbattle.service.impl.JoueurServiceImpl;
import fr.humanbooster.fx.englishbattle.service.impl.NiveauServiceImpl;
import fr.humanbooster.fx.englishbattle.service.impl.VilleServiceImpl;

/**
 * Servlet implementation class Inscription
 */
@WebServlet("/inscription")
public class InscriptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static VilleService villeService = new VilleServiceImpl();
	private static NiveauService niveauService = new NiveauServiceImpl();
	private static JoueurService joueurService = new JoueurServiceImpl();
	private static List<Ville> villes = new ArrayList<>();
	private static List<Niveau> niveaux = new ArrayList<>();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InscriptionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		villes = villeService.recupererVilles();
		niveaux = niveauService.recupererNiveaux();
		request.setAttribute("villes", villes);
		request.setAttribute("niveaux", niveaux);
		request.getRequestDispatcher("WEB-INF/inscription.jsp").include(request, response);
	}
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String nom = request.getParameter("NOM");
		String prenom = request.getParameter("PRENOM");
		String email = request.getParameter("EMAIL");
		Ville ville = villeService.recupererVille( Long.valueOf(request.getParameter("ID_VILLE")));
		Niveau niveau = niveauService.recupererNiveau(Long.valueOf(request.getParameter("ID_NIVEAU")));
		String mdp = request.getParameter("MDP");
		Joueur joueur = joueurService.ajouterJoueur(email, nom, prenom, mdp, niveau.getId(), ville.getIdVille());
		request.getSession().setAttribute("joueur", joueur);
		request.getRequestDispatcher("WEB-INF/merciInscription.jsp").include(request, response);
		

	}

}
