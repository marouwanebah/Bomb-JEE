package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import beans.Utilisateur;
import dao.bdd.*;

@WebServlet("/CreationUser")
public class CreationUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private UtilisateurDAO userDoa;

    public void init() throws ServletException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.userDoa = daoFactory.getUtilisateurDao();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher("/WEB-INF/creationUser.jsp").forward( request, response );
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		String message = "Ok"; 
		String username = request.getParameter("pseudo"); 
		String password = request.getParameter("motDePasse"); 
		String nom = request.getParameter("nom"); 
		String prenom = request.getParameter("prenom"); 
		String email = request.getParameter("email");
		
		Utilisateur newUser = new Utilisateur(username, password, nom, prenom, email); 

        
		userDoa.ajouter(newUser);
        
		request.setAttribute("user", newUser);
		request.setAttribute("test", message);
		
		
        
       this.getServletContext().getRequestDispatcher("/WEB-INF/creationUser.jsp").forward(request, response);
       
       
	
	}

}
