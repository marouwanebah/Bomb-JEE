package Vue;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

import javax.swing.JPanel;

import Controleur.InterfaceControleur;
import Moteur.BombermanGame;
import Moteur.Game;
import Moteur.SimpleGame;
import Moteur.Agents.AgentAction;


public class ViewBombermanGame extends JFrame implements Moteur.Observer {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private InterfaceControleur _controleurBombermanGame; 
	private Game _game;  
	private Map _map; 
	private PanelBomberman _panelBomberman;
	private ViewCommand _commande;
	
	private int keypressed; 
	private AgentAction action;

	private ViewSimpleGame _gameOver; 

	public ViewBombermanGame(Game g, InterfaceControleur c, String map ) throws Exception {
		super();
		this._game=g; 
		this._game.addObserver(this); 
		this._controleurBombermanGame=c; 
		
		_commande = new ViewCommand(_game, _controleurBombermanGame); 
		
		this._map = new Map(map);
		this._panelBomberman = new PanelBomberman(this._map);
		
		JPanel CommandePanel = new JPanel();
		CommandePanel = _commande.get_mainContenaire();
		
		this.setTitle("Game Bomberman");
		this.setSize(_map.getSizeX()*55, _map.getSizeY()*55+200);
		this.setLayout(new BorderLayout());
		this.add("North", CommandePanel);
		this.add("Center", _panelBomberman);

		//_panelBomberman.addKeyListener(this);
		

		
	
		//retour a la selection du plateau de jeu apres fermeture du jeu en cour 
		this.addWindowListener(new WindowAdapter() {
			
			 @Override
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				Launcher.unique_instance=null;
				Launcher.getInstanLauncher(); 
			}
			
		});
		
	}
	/**
	 * foncton qui affiche la View (le jeu avec les commande dans une meme) fenetre 
	 */
	public void setVisile(boolean b) {
	
		this.setLocationRelativeTo(null);
		this.setVisible(b);
		this.requestFocus();
	}
	public Map get_map() {
		return _map;
	}


	public void set_map(Map _map) {
		this._map = _map;
	}

	
	public PanelBomberman get_panelBomberman() {
		return _panelBomberman;
	}
	public void set_panelBomberman(PanelBomberman _panelBomberman) {
		this._panelBomberman = _panelBomberman;
	}
	
	
	public void  gestionClavier() {
		//BombermanClavierSeul b = new BombermanClavierSeul(_panelBomberman); 
		
	}


	
	public AgentAction getAction() {
		return action;
	}
	public void setAction(AgentAction action) {
		this.action = action;
	}

	public int getKeypressed() {
		return keypressed;
	}
	public void setKeypressed(int keypressed) {
		this.keypressed = keypressed;
	}
		

	public ViewSimpleGame get_gameOver() {
		return _gameOver;
	}
	public void set_gameOver(ViewSimpleGame _gameOver) {
		this._gameOver = _gameOver;
	}
	@Override
	public void update() {
		BombermanGame a = (BombermanGame) this._controleurBombermanGame.get_bombermanGame(); 
		this._panelBomberman.setInfoGame(a.get_listBreakableWalls() , a.get_agents() , a.get_listItems(), a.get_bombes());
		this._panelBomberman.repaint();
		
	}
	

}
