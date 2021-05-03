package fr.humanbooster.fx.englishbattle.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.humanbooster.fx.englishbattle.business.Joueur;
import fr.humanbooster.fx.englishbattle.service.JoueurService;
import fr.humanbooster.fx.englishbattle.service.impl.JoueurServiceImpl;

/**
 * Servlet implementation class ConnexionServlet
 */
@WebServlet("/connexion")
public class ConnexionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static JoueurService joueurService = new JoueurServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConnexionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// On récupère la donnée saisie dans le champ connexion
		String email = request.getParameter("email");
		String motDePasse = request.getParameter("mdp");
		
		Joueur joueur = joueurService.recupererJoueurParEmailEtMotDePasse(email, motDePasse);
        
		if (joueur == null) {
			request.setAttribute("utilisateurNonTrouve", "Utilisateur non trouvé!");
			request.getRequestDispatcher("WEB-INF/erreur.jsp").forward(request, response);
		} else {
			request.getSession().setAttribute("joueur", joueur);
			request.getRequestDispatcher("WEB-INF/jeu.jsp").forward(request, response);
		}
	}

}
