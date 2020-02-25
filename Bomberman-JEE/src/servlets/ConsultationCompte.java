package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.bdd.DaoFactory;
import dao.bdd.UtilisateurDAO;

/**
 * Servlet implementation class ConsultationCompte
 */
@WebServlet("/ConsultationCompte")
public class ConsultationCompte extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    
	private UtilisateurDAO userDoa;

	public void init() throws ServletException {
		DaoFactory daoFactory = DaoFactory.getInstance();
		this.userDoa = daoFactory.getUtilisateurDao();
	}

    public ConsultationCompte() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 request.setAttribute("utilisateurs", userDoa.lister());
		this.getServletContext().getRequestDispatcher("/WEB-INF/ConsultationComptes.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
