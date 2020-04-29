package beans;

public class ModePartie {
	private String _codeModePartie;
	private String _libelleModePartie;
	public ModePartie() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ModePartie(String _codeModePartie, String _libelleModePartie) {
		super();
		this._codeModePartie = _codeModePartie;
		this._libelleModePartie = _libelleModePartie;
	}
	public String get_codeModePartie() {
		return _codeModePartie;
	}
	public void set_codeModePartie(String _codeModePartie) {
		this._codeModePartie = _codeModePartie;
	}
	public String get_libelleModePartie() {
		return _libelleModePartie;
	}
	public void set_libelleModePartie(String _libelleModePartie) {
		this._libelleModePartie = _libelleModePartie;
	}
	
}
