package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Partie;
import beans.Utilisateur;
import dao.bdd.*;

//@WebServlet("/CreationUser")
public class PartieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private PartieDAO partieDao;

    public void init() throws ServletException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.partieDao = daoFactory.getPartieDao();
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
			case "parties":
				List<Partie> parties = partieDao.listerParties();
				request.setAttribute("parties", parties);
				this.getServletContext().getRequestDispatcher("/WEB-INF/parties.jsp").forward(request, response);
				break;
				
			case "joueurs":
				int numeroPartie=Integer.parseInt(request.getParameter("numeroPartie"));
				List<Utilisateur> utilisateurs = partieDao.getUtilisateursParPartie(numeroPartie);
				request.setAttribute("utilisateurs", utilisateurs);
				request.setAttribute("numeroPartie", numeroPartie);
				this.getServletContext().getRequestDispatcher("/WEB-INF/joueurs.jsp").forward(request, response);
				break;
				
			default:
				this.getServletContext().getRequestDispatcher("/WEB-INF/parties.jsp").forward(request, response);
				break;
			}
		}
	
	}

}
