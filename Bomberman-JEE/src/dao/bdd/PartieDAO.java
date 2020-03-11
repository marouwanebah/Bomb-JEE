package dao.bdd;

import java.util.List;

import beans.EtatPartie;
import beans.LevelPartie;
import beans.Partie;
import beans.Utilisateur;

public interface PartieDAO {
	public List<Partie> listerParties();
	public List<Utilisateur> getUtilisateursParPartie(int numeroPartie);
	public EtatPartie getLibelleEtatPartie(String codeEtatPartie);
	public LevelPartie getLibelleLevelPartie(String codeLevelPartie);
}
