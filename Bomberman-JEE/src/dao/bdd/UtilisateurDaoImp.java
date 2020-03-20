package dao.bdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
	
	
	private static final String SQL_INSERT = "INSERT INTO utilisateur (pseudo, password, nom, prenom, email,  date_creation, nbre_victoires, nbre_defaites, role)"
			+ " VALUES(?,?,?,?,?,NOW(),0,0,'utilisateur' )";
	private static final String SQL_UPDATE = "UPDATE utilisateur SET password=?, nom=?, prenom=?, email=? WHERE pseudo=?";
	private static final String SQL_DELETE = "DELETE FROM utilisateur WHERE pseudo=?";
	private static final String SQL_SELECT = "SELECT * FROM utilisateur";
	private static final String SQL_SELECT_ONLY = "SELECT pseudo, password, nom, prenom,  email, role FROM utilisateur WHERE pseudo=?";
	
	 
	
	public UtilisateurDaoImp(DaoFactory daoFactory) {
		super();
		this.daoFactory = daoFactory;
	}

	@Override
	public void ajouterUtilisateur(Utilisateur utilisateur) {
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
	            preparedStatement.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		
	}



	@Override
	public List<Utilisateur> listerUtilisateurs() {
		List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
		Connection connexion = null;
        PreparedStatement preparedStatement = null;
		try {
			connexion = daoFactory.getConnection();
			preparedStatement = connexion.prepareStatement
					(SQL_SELECT);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				Utilisateur utilisateur = new Utilisateur();
				utilisateur.set_Username(rs.getString("pseudo"));
				utilisateur.set_nom(rs.getString("nom"));
				utilisateur.set_prenom(rs.getString("prenom"));
				utilisateur.set_email(rs.getString("email"));
				utilisateur.set_dateCreation(rs.getString("date_creation"));
				utilisateur.set_nbreVictoires(rs.getInt("nbre_victoires"));
				utilisateur.set_nbreDefaites(rs.getInt("nbre_defaites"));
				utilisateurs.add(utilisateur);
			}
			preparedStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return utilisateurs;
	}

	@Override
	public Utilisateur getUtilisateur(String pseudo) {
		Utilisateur utilisateur = null;
		Connection connexion = null;
        PreparedStatement preparedStatement = null;
		try {
			connexion = daoFactory.getConnection();
			preparedStatement = connexion.prepareStatement
					(SQL_SELECT_ONLY);
			preparedStatement.setString(1, pseudo);
			ResultSet rs = preparedStatement.executeQuery();
			if(rs.next()) {
				utilisateur = new Utilisateur();
				utilisateur.set_Username(rs.getString("pseudo"));
				utilisateur.set_motDePasse(rs.getString("password"));
				utilisateur.set_nom(rs.getString("nom"));
				utilisateur.set_prenom(rs.getString("prenom"));
				utilisateur.set_email(rs.getString("email"));
				utilisateur.set_role(rs.getString("role"));
			}
			preparedStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (utilisateur==null) throw new RuntimeException("Utilisateur"+ pseudo + "introuvable");
		return utilisateur;
	}

	@Override
	public void modifierUtilisateur(Utilisateur utilisateur) {
		Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement(SQL_UPDATE);
            preparedStatement.setString(1, utilisateur.get_motDePasse());
            preparedStatement.setString(2, utilisateur.get_nom());
            preparedStatement.setString(3, utilisateur.get_prenom());
            preparedStatement.setString(4, utilisateur.get_email());
            preparedStatement.setString(5, utilisateur.get_Username());            
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
	}

	@Override
	public void supprimerUtilisateur(String pseudo) {
		Connection connexion = null;
        PreparedStatement preparedStatement = null;
		try {
			connexion = daoFactory.getConnection();
			preparedStatement = connexion.prepareStatement
					(SQL_DELETE);
			preparedStatement.setString(1, pseudo);
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
