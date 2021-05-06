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
import fr.humanbooster.fx.englishbattle.service.QuestionService;
import fr.humanbooster.fx.englishbattle.service.impl.PartieServiceImpl;
import fr.humanbooster.fx.englishbattle.service.impl.QuestionServiceImpl;

/**
 * Servlet implementation class JeuServlet
 */
@WebServlet("/jeu")
public class JeuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static PartieService partieService = new PartieServiceImpl();
	private static QuestionService questionService = new QuestionServiceImpl();
       
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
			partie = partieService.ajouterPartie((Joueur) request.getSession().getAttribute("Joueur"));
			request.getSession().setAttribute("partie", partie);
		}
		else {
			partie = (Partie) request.getSession().getAttribute("partie");
		}
		
		
		// Si il existe une question en session
		if (request.getParameterMap().containsKey("question")) {
			// TODO on traite les réponses
			// si les réponses sont bonne 
			if (questionService.verifierReponse((Question) request.getSession().getAttribute("question"))) {
				// On créer une nouvelle question
				throwQuestion(request);
			}
			else {
				// TODO sinon on deconnecter et on revient à l'index	
			}
		}
		else {
			// TODO sinon on crée une nouvelle question	
			throwQuestion(request);
		}
		
		
		
		// TODO Inscrire la question en base
		Question question = new Question(partie, (Verbe) request.getAttribute("verbe"));
		question.setReponsePreterit(request.getParameter("PRETERIT"));
		question.setReponseParticipePasse(request.getParameter("PARTICIPEPASSE"));
		
		// TODO Si les réponses sont bonnes on solicite VerbeServlet
		
		
		// TODO Si les réponses sont mauvaise, on retourne à index.jsp
		
	}
	
	private void throwQuestion(HttpServletRequest request) {
		// TODO on creer une nouvelle question
		// TODO on met la question en base
		// TODO on met la question en session
		// TODO on redirige vers la page jeu.jsp
	}

}
