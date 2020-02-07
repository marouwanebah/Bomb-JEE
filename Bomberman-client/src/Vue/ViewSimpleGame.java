package Vue;

import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Point;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


import Controleur.InterfaceControleur;

import Moteur.Game;
import Moteur.Observer;

public class ViewSimpleGame extends JFrame implements Observer {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private InterfaceControleur _controleurSimpleGame; 
	private Game _game;  

	
	public ViewSimpleGame(Game g, InterfaceControleur c, String v ) {
		super();
		this._game=g; 
		this._game.addObserver(this); 
		this._controleurSimpleGame=c; 
		//_controleurSimpleGame.addOS(this);
		
		this.setTitle("Fin du JEU");
		this.setSize(new Dimension(400,100));
		Dimension windowSize = this.getSize();
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		Point centerPoint = ge.getCenterPoint();
		int dx = centerPoint.x - windowSize.width / 2;
		int dy = centerPoint.y - windowSize.height / 2 - 350;
		this.setLocation(dx,dy);
		
		
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setLayout(new GridLayout(2,1));
		
		JLabel labelJoueur1 = new JLabel(v, JLabel.CENTER);
		panelPrincipal.add(labelJoueur1);
		
		JPanel panelButton = new JPanel();
		panelButton.setLayout(new GridLayout(1,2));
		
		JButton buttonRecommencer = new JButton("Recommencer");
		JButton buttonFermer = new JButton("Fermer le jeu");
		
		panelButton.add(buttonRecommencer);
		panelButton.add(buttonFermer);
		panelPrincipal.add(panelButton);
		
		setContentPane(panelPrincipal);
		setVisible(true);
		
		buttonRecommencer.addActionListener(e -> {
			_controleurSimpleGame.start();
			ViewSimpleGame.this.dispose();
		});
		
		buttonFermer.addActionListener(e-> {
			_controleurSimpleGame.get_viewBomberman().getDefaultCloseOperation();
			_controleurSimpleGame.get_viewBomberman().setVisile(false);
			ViewSimpleGame.this.dispose();
		});
		
	}
	
	
	
	@Override
	public void update() {
		//this._tours.setText("tours : " + _game.get_turn());
		
	}

}
