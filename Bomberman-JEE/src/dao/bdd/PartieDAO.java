package dao.bdd;

import java.util.List;

import beans.Partie;
import beans.Utilisateur;

public interface PartieDAO {
	public List<Partie> listerParties();
	public List<Utilisateur> getUtilisateursParPartie(int numeroPartie);
}
