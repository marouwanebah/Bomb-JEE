package beans;

public class EtatPartie {
	private String _codeEtatPartie;
	private String _libelleEtatPartie;
	public EtatPartie() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EtatPartie(String _codeEtatPartie, String _libelleEtatPartie) {
		super();
		this._codeEtatPartie = _codeEtatPartie;
		this._libelleEtatPartie = _libelleEtatPartie;
	}
	public String get_codeEtatPartie() {
		return _codeEtatPartie;
	}
	public void set_codeEtatPartie(String _codeEtatPartie) {
		this._codeEtatPartie = _codeEtatPartie;
	}
	public String get_libelleEtatPartie() {
		return _libelleEtatPartie;
	}
	public void set_libelleEtatPartie(String _libelleEtatPartie) {
		this._libelleEtatPartie = _libelleEtatPartie;
	}
	
}
