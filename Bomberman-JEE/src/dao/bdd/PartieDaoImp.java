package dao.bdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.EtatPartie;
import beans.LevelPartie;
import beans.ModePartie;
import beans.Partie;
import beans.Utilisateur;

public class PartieDaoImp implements PartieDAO {
	private DaoFactory daoFactory;
	private static final String SQL_SELECT = "SELECT * FROM td_partie";
	private static final String SQL_SELECT_USERS_PARTIE = "SELECT t1.pseudo, nom, prenom, email, score FROM utilisateur t1, td_mapping_user_partie t2 WHERE t1.pseudo=t2.pseudo AND t2.numero_partie=? ORDER BY score DESC";
	private static final String SQL_SELECT_ETAT_PARTIE = "SELECT code_etat_partie, libelle_etat_partie FROM tc_etat_partie where code_etat_partie=?";
	private static final String SQL_SELECT_LEVEL_PARTIE = "SELECT code_level_partie, libelle_level_partie FROM tc_level_partie where code_level_partie=?";
	private static final String SQL_SELECT_MODE_PARTIE = "SELECT code_mode_partie, libelle_mode_partie FROM tc_mode_partie where code_mode_partie=?";
	public PartieDaoImp(DaoFactory daoFactory) {
		super();
		this.daoFactory = daoFactory;
	}

	@Override
	public List<Partie> listerParties() {
		List<Partie> parties = new ArrayList<Partie>();
		Connection connexion = null;
        PreparedStatement preparedStatement = null;
		try {
			connexion = daoFactory.getConnection();
			preparedStatement = connexion.prepareStatement
					(SQL_SELECT);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				Partie partie = new Partie();
				partie.set_numeroPartie(rs.getInt("numero_partie"));
				partie.set_dateCreationPartie(rs.getString("date_creation_partie"));
				partie.set_gagnantPartie(rs.getString("gagnant_partie"));
				partie.set_etatPartie(getLibelleEtatPartie((rs.getString("code_etat_partie"))));
				partie.set_dateDebutPartie(rs.getString("date_debut_partie"));
				partie.set_dateFinPartie(rs.getString("date_fin_partie"));
				partie.set_levelPartie(getLibelleLevelPartie((rs.getString("code_level_partie"))));
				partie.set_modePartie(getLibelleModePartie((rs.getString("code_mode_partie"))));
				parties.add(partie);
			}
			preparedStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return parties;
	}

	@Override
	public List<Utilisateur> getUtilisateursParPartie(int numeroPartie) {
		List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
		Connection connexion = null;
        PreparedStatement preparedStatement = null;
		try {
			connexion = daoFactory.getConnection();
			preparedStatement = connexion.prepareStatement
					(SQL_SELECT_USERS_PARTIE);
			preparedStatement.setInt(1, numeroPartie);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				Utilisateur utilisateur = new Utilisateur();
				utilisateur.set_Username(rs.getString("pseudo"));
				utilisateur.set_nom(rs.getString("nom"));
				utilisateur.set_prenom(rs.getString("prenom"));
				utilisateur.set_email(rs.getString("email"));
				utilisateur.set_score(rs.getInt("score"));
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
	public EtatPartie getLibelleEtatPartie(String codeEtatPartie) {
		Connection connexion = null;
        PreparedStatement preparedStatement = null;
        EtatPartie etatPartie = null;
		try {
			connexion = daoFactory.getConnection();
			preparedStatement = connexion.prepareStatement
					(SQL_SELECT_ETAT_PARTIE);
			preparedStatement.setString(1, codeEtatPartie);
			ResultSet rs = preparedStatement.executeQuery();
			if(rs.next()) {
				etatPartie = new EtatPartie();
				etatPartie.set_codeEtatPartie(rs.getString("code_etat_partie"));
				etatPartie.set_libelleEtatPartie(rs.getString("libelle_etat_partie"));
			}
			preparedStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return etatPartie;
	}

	@Override
	public LevelPartie getLibelleLevelPartie(String codeLevelPartie) {
		Connection connexion = null;
        PreparedStatement preparedStatement = null;
        LevelPartie levelPartie = null;
		try {
			connexion = daoFactory.getConnection();
			preparedStatement = connexion.prepareStatement
					(SQL_SELECT_LEVEL_PARTIE);
			preparedStatement.setString(1, codeLevelPartie);
			ResultSet rs = preparedStatement.executeQuery();
			if(rs.next()) {
				levelPartie = new LevelPartie();
				levelPartie.set_codeLevelPartie(rs.getString("code_level_partie"));
				levelPartie.set_libelleLevelPartie(rs.getString("libelle_level_partie"));
			}
			preparedStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return levelPartie;
	}

	@Override
	public ModePartie getLibelleModePartie(String codeModePartie) {
		Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ModePartie modePartie = null;
		try {
			connexion = daoFactory.getConnection();
			preparedStatement = connexion.prepareStatement
					(SQL_SELECT_MODE_PARTIE);
			preparedStatement.setString(1, codeModePartie);
			ResultSet rs = preparedStatement.executeQuery();
			if(rs.next()) {
				modePartie = new ModePartie();
				modePartie.set_codeModePartie(rs.getString("code_mode_partie"));
				modePartie.set_libelleModePartie(rs.getString("libelle_mode_partie"));
			}
			preparedStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return modePartie;
	}

}
