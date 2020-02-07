package Controleur;

import Moteur.BombermanGame;
import Moteur.Game;
import Moteur.SimpleGame;
import Vue.ViewBombermanGame;
import Vue.ViewCommand;
import Vue.ViewSimpleGame;

public class ControleurSimpleGame implements InterfaceControleur {

	private Game _simpleGame; 
	
	public ControleurSimpleGame(Game g) {
		this._simpleGame=g;  
		ViewCommand a = new ViewCommand(g, this);
		//ViewSimpleGame b = new ViewSimpleGame(g,this); 
		
	}

	@Override
	public void start() {
	//	_simpleGame.init();
		//_simpleGame
	}

	@Override
	public void step() {
		_simpleGame.step();
		
	}

	@Override
	public void run() {
		_simpleGame.launch();
		
	}

	@Override
	public void stop() {
		_simpleGame.stop();
		
	}

	@Override
	public void setTime(double time) {
		_simpleGame.set_time((long)time);
		
	}

	@Override
	public BombermanGame get_bombermanGame() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ViewBombermanGame get_viewBomberman() {
		// TODO Auto-generated method stub
		return null;
	}

	

	




	
}
