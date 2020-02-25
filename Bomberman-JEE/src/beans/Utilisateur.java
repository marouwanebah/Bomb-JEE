package beans;

import java.sql.Date;

public class Utilisateur {
	private int _id; 
	private String _Username;
	private String _motDePasse;
	private String _nom;
	private String _prenom;
	private String _email;
	private Date _dateCreation; 
	private int nombre_de_jeu ;
	private int nombre_de_victoire ; 
	private int nombre_de_defaite ;
	
	public Utilisateur() {
	// TODO Auto-generated constructor stub
	}
	public Utilisateur(String _Username, String _motDePasse, String _nom, String _prenom, String _email) {
		super();
		this._Username = _Username;
		this._motDePasse = _motDePasse;
		this._nom = _nom;
		this._prenom = _prenom;
		this._email = _email;
	}
	public String get_Username() {
		return _Username;
	}
	public void set_Username(String _Username) {
		this._Username = _Username;
	}
	public String get_motDePasse() {
		return _motDePasse;
	}
	public void set_motDePasse(String _motDePasse) {
		this._motDePasse = _motDePasse;
	}
	public String get_nom() {
		return _nom;
	}
	public void set_nom(String _nom) {
		this._nom = _nom;
	}
	public String get_prenom() {
		return _prenom;
	}
	public void set_prenom(String _prenom) {
		this._prenom = _prenom;
	}
	public String get_email() {
		return _email;
	}
	public void set_email(String _email) {
		this._email = _email;
	}


	public Date get_date() {
		return _dateCreation;
	}
	public void set_date(Date _date) {
		this._dateCreation = _date;
	}
	public int get_id() {
		return _id;
	}
	public void set_id(int _id) {
		this._id = _id;
	}
	public int getNombre_de_jeu() {
		return nombre_de_jeu;
	}
	public void setNombre_de_jeu(int nombre_de_jeu) {
		this.nombre_de_jeu = nombre_de_jeu;
	}
	public int getNombre_de_victoire() {
		return nombre_de_victoire;
	}
	public void setNombre_de_victoire(int nombre_de_victoire) {
		this.nombre_de_victoire = nombre_de_victoire;
	}
	public int getNombre_de_defaite() {
		return nombre_de_defaite;
	}
	public void setNombre_de_defaite(int nombre_de_defaite) {
		this.nombre_de_defaite = nombre_de_defaite;
	}
	

	
	
	
	
}
