package servlets;

import java.util.ArrayList;
import java.util.List;

import beans.Partie;

public class PartieModel {
	private Partie partie;
	private String _libelleEtatPartie;
	private String _libelleLevelPartie;
	private List<Partie> parties = new ArrayList<Partie>();
	public PartieModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Partie getPartie() {
		return partie;
	}
	public void setPartie(Partie partie) {
		this.partie = partie;
	}
	public String get_libelleEtatPartie() {
		return _libelleEtatPartie;
	}
	public void set_libelleEtatPartie(String _libelleEtatPartie) {
		this._libelleEtatPartie = _libelleEtatPartie;
	}
	public String get_libelleLevelPartie() {
		return _libelleLevelPartie;
	}
	public void set_libelleLevelPartie(String _libelleLevelPartie) {
		this._libelleLevelPartie = _libelleLevelPartie;
	}
	public List<Partie> getParties() {
		return parties;
	}
	public void setParties(List<Partie> parties) {
		this.parties = parties;
	}
	

}
