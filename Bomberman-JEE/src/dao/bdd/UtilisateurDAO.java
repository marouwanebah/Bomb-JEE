package dao.bdd;

import java.util.List;

import beans.Utilisateur;

public interface UtilisateurDAO {
    void ajouter( Utilisateur utilisateur );
    List<Utilisateur> lister();

}
