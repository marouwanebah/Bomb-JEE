package Controleur;


import Moteur.Game;
import Vue.ViewBombermanGame;
import Vue.VueClavier;

public class ControleurBombermanGame implements InterfaceControleur{
	
	private Game _bombermanGame; 
	private ViewBombermanGame _viewBomberman; 
	private VueClavier v; 
	

	public ControleurBombermanGame(Game g, String map) throws Exception {
		this._bombermanGame=g; 
		this._viewBomberman = new ViewBombermanGame (g, this, map);
		
		
	}
	public VueClavier getVuClaiver() {
		return v; 
	}
	public void SetVuClavier() {
		this.v = VueClavier.getInstance();
	}

	public ViewBombermanGame get_viewBomberman() {
		return _viewBomberman;
	}

	public void set_viewBomberman(ViewBombermanGame _viewBomberman) {
		this._viewBomberman = _viewBomberman;
	}

	@Override
	public void start() {
		_bombermanGame.init();
		_bombermanGame.stop();
		
	}

	@Override
	public void step() {
		_bombermanGame.init();
		_bombermanGame.step();
		
	}

	@Override
	public void run() {
		_bombermanGame.init();
		_bombermanGame.launch();
		
	}

	@Override
	public void stop() {
		_bombermanGame.stop();
		
	}

	@Override
	public void setTime(double time) {
		_bombermanGame.set_time((long)time);
		
	}



	@Override
	public Game get_bombermanGame() {
		// TODO Auto-generated method stub
		return _bombermanGame;
	}


}
