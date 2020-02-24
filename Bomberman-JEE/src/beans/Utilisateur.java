package beans;

public class Utilisateur {
	private String _Username;
	private String _motDePasse;
	private String _nom;
	private String _prenom;
	private String _email;
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
	
	
	
	
}
