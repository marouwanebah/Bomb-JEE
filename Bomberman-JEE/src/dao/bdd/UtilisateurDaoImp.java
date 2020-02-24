package dao.bdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import beans.Utilisateur;

public class UtilisateurDaoImp implements UtilisateurDAO {
	private DaoFactory daoFactory; 
	
	private static final String CHAMP_ID = "id";
	private static final String CHAMP_PSEUDO = "pseudo";
	private static final String CHAMP_PASSWORD = "password";
	private static final String CHAMP_NOM = "nom";
	private static final String CHAMP_PRENOM = "prenom";
	private static final String CHAMP_EMAIL = "email";
	private static final String CHAMP_DATE_INSCRIPTION = "date_creation";
	
	
	private static final String SQL_INSERT = "INSERT INTO utilisateur (pseudo, password, nom, prenom, email,  date_creation)"
			+ " VALUES(?,?,?,?,?,NOW() )";
	
	 
	
	public UtilisateurDaoImp(DaoFactory daoFactory) {
		super();
		this.daoFactory = daoFactory;
	}

	@Override
	public void ajouter(Utilisateur utilisateur) {
			Connection connexion = null;
	        PreparedStatement preparedStatement = null;

	        try {
	            connexion = daoFactory.getConnection();
	            preparedStatement = connexion.prepareStatement(SQL_INSERT);

	            preparedStatement.setString(1, utilisateur.get_Username());
	            preparedStatement.setString(2, utilisateur.get_motDePasse());
	            preparedStatement.setString(3, utilisateur.get_nom());
	            preparedStatement.setString(4, utilisateur.get_prenom());
	            preparedStatement.setString(5, utilisateur.get_email());
	            
	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		
	}

	@Override
	public List<Utilisateur> lister() {
		// TODO Auto-generated method stub
		return null;
	}

}
