package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.UtilisateurSimple;

/**
 * Servlet implementation class Accueil
 */
@WebServlet("/Accueil")
public class Accueil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Accueil() {
        super();
        // TODO Auto-generated constructor stub
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
		UtilisateurSimple user = new UtilisateurSimple(); 
		
		user.setMotDePasse(password); 
		user.setEmail(username);
		request.setAttribute("user", user);
		
		String resultat =""; 
		if ( resultat=="ok")
		{
			//this.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp").forward( request, response );

		}else 
			this.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp").forward( request, response );
	}

}
