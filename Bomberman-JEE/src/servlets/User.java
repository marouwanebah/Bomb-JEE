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
public class User extends HttpServlet {
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
		String message = "Ok"; 
		String mode=null;
		if(action != null) {
			switch (action) {
			case "Enregistrer":
				String username = request.getParameter("pseudo"); 
				String password = request.getParameter("motDePasse"); 
				String nom = request.getParameter("nom"); 
				String prenom = request.getParameter("prenom"); 
				String email = request.getParameter("email");
				
				Utilisateur newUser = new Utilisateur(username, password, nom, prenom, email); 
				
				mode=(request.getParameter("mode"));
				if(mode.equals("ajout")) {
					userDoa.ajouterUtilisateur(newUser);
					
				}
				else if(mode.equals("edit")) {
					userDoa.modifierUtilisateur(newUser);
				}
				request.setAttribute("user", newUser);
				request.setAttribute("mode", mode);
				request.setAttribute("test", message);
				this.getServletContext().getRequestDispatcher("/WEB-INF/creationUser.jsp").forward(request, response);
		       
				break;
			case "users":
				List<Utilisateur> utilisateurs = userDoa.listerUtilisateurs();
				request.setAttribute("utilisateurs", utilisateurs);
				this.getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request, response);
				break;
			case "delete":
				String pseudo=request.getParameter("pseudo");
				userDoa.supprimerUtilisateur(pseudo);
				utilisateurs = userDoa.listerUtilisateurs();
				request.setAttribute("utilisateurs", utilisateurs);
				this.getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request, response);
				break;
			case "edit":
				pseudo=request.getParameter("pseudo");
				Utilisateur utilisateur= userDoa.getUtilisateur(pseudo);
				mode="edit";
				request.setAttribute("user", utilisateur);
				request.setAttribute("mode", mode);
				this.getServletContext().getRequestDispatcher("/WEB-INF/creationUser.jsp").forward(request, response);
				break;

			default:
				this.getServletContext().getRequestDispatcher("/WEB-INF/creationUser.jsp").forward(request, response);
				break;
			}
		}
	
	}

}
