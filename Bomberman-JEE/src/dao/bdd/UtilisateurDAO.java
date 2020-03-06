package dao.bdd;

import java.util.List;

import beans.Utilisateur;


public interface UtilisateurDAO {
    public void ajouterUtilisateur( Utilisateur utilisateur );
    public List<Utilisateur> listerUtilisateurs();
    public Utilisateur getUtilisateur(String pseudo);
    public void modifierUtilisateur(Utilisateur utilisateur);
    public void supprimerUtilisateur(String pseudo);

}
