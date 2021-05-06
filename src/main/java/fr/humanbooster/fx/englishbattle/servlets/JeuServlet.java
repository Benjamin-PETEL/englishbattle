package fr.humanbooster.fx.englishbattle.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.humanbooster.fx.englishbattle.business.Joueur;
import fr.humanbooster.fx.englishbattle.business.Partie;
import fr.humanbooster.fx.englishbattle.business.Question;
import fr.humanbooster.fx.englishbattle.business.Verbe;
import fr.humanbooster.fx.englishbattle.service.PartieService;
import fr.humanbooster.fx.englishbattle.service.impl.PartieServiceImpl;

/**
 * Servlet implementation class JeuServlet
 */
@WebServlet("/jeu")
public class JeuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static PartieService partieService = new PartieServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JeuServlet() {
        super();
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Partie partie = null;
		
		// On regarde si la session ne contient pas une partie
		if (!request.getParameterMap().containsKey("partie")) {
			// TODO Inscrire en base + en session la partie (joueur) si la partie n'existe pas encore
			partie = partieService.ajouterPartie((Joueur) request.getAttribute("Joueur"));
			request.setAttribute("partie", partie);
		}
		
		// TODO Inscrire la question en base
		Question question = new Question(partie, (Verbe) request.getAttribute("verbe"));
		question.setReponsePreterit(request.getParameter("PRETERIT"));
		question.setReponseParticipePasse(request.getParameter("PARTICIPEPASSE"));
		
		// TODO Si les réponses sont bonnes on solicite VerbeServlet
		
		
		// TODO Si les réponses sont mauvaise, on retourne à index.jsp
		
	}

}
