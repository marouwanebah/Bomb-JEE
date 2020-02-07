package Controleur;


import Moteur.Game;
import Vue.ViewBombermanGame;

public interface InterfaceControleur {
	void start();
	void step();
	void run();
	void stop();
	void setTime(double time);
	Game get_bombermanGame();
	ViewBombermanGame get_viewBomberman();
	

}
