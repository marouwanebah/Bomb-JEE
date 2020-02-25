package dao.bdd;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
        List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
        Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;

        try {
            connexion = daoFactory.getConnection();
            statement = connexion.createStatement();
            resultat = statement.executeQuery("SELECT nom, prenom, date_creation,nombre_de_jeu,nombre_de_victoire, nombre_de_defaite  FROM utilisateur;");

            while (resultat.next()) {
                String nom = resultat.getString("nom");
                String prenom = resultat.getString("prenom");
                Date dateDeCreation = resultat.getDate("date_creation");
                int NombreDeJeu = resultat.getInt("nombre_de_jeu");
                int NombreDeVictoire = resultat.getInt("nombre_de_victoire");
                int nombreDeDefaite = resultat.getInt("nombre_de_defaite");


                Utilisateur utilisateur = new Utilisateur();
                utilisateur.set_nom(nom);
                utilisateur.set_prenom(prenom);
                utilisateur.set_date(dateDeCreation);
                utilisateur.setNombre_de_jeu(NombreDeJeu);
                utilisateur.setNombre_de_victoire(NombreDeVictoire);
                utilisateur.setNombre_de_defaite(nombreDeDefaite);
                
                
                utilisateurs.add(utilisateur);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return utilisateurs;
    }

}


