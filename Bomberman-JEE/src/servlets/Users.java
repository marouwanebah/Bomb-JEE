package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import beans.Utilisateur;
import dao.bdd.*;

//@WebServlet("/CreationUser")
public class Users extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private UtilisateurDAO userDoa;

    public void init() throws ServletException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.userDoa = daoFactory.getUtilisateurDao();
    }
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action= request.getParameter("action");
		if(action != null) {
			switch (action) {
			case "users":
				List<Utilisateur> utilisateurs = userDoa.listerUtilisateurs();
				request.setAttribute("utilisateurs", utilisateurs);
				this.getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request, response);
				break;

			default:
				this.getServletContext().getRequestDispatcher("/WEB-INF/creationUser.jsp").forward(request, response);
				break;
			}
		}
	
	}

}
