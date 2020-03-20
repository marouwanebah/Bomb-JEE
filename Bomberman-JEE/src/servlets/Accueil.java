package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Utilisateur;
import beans.UtilisateurSimple;
import dao.bdd.DaoFactory;
import dao.bdd.UtilisateurDAO;

/**
 * Servlet implementation class Accueil
 */
//@WebServlet("/Accueil")
public class Accueil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private UtilisateurDAO userDoa;
	public static final String ATT_SESSION_USER="sessionUtilisateur";
    @Override
    public void init() throws ServletException {
    	DaoFactory daoFactory = DaoFactory.getInstance();
        this.userDoa = daoFactory.getUtilisateurDao();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		this.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp").forward( request, response );
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		String username = request.getParameter("nomClient");
		String password = request.getParameter("motDePass");
		Utilisateur userBD = userDoa.getUtilisateur(username);
		Utilisateur userForm = new Utilisateur();
		HttpSession session = request.getSession(); 
		if(userBD != null && username.equals(userBD.get_Username()) && password.equals(userBD.get_motDePasse())) {
				session.setAttribute(ATT_SESSION_USER, userBD);
				request.setAttribute("user", userBD);
				request.setAttribute("action", "users");
				this.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp").forward( request, response );
		}
		else {
			session.setAttribute(ATT_SESSION_USER, null);
			userForm.set_motDePasse(password);
			userForm.set_Username(username);
			request.setAttribute("user", userForm);
			this.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp").forward( request, response );
		}
	}

}
