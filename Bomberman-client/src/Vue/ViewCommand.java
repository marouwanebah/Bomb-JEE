package Vue;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


import Controleur.InterfaceControleur;

import Moteur.Game;


public class ViewCommand extends JFrame implements Moteur.Observer {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton _boutonInit;
	private JButton _boutonStart;
	private JButton _boutonStep;
	private JButton _boutonStop;
	
	private JSlider _slider; 
	private JLabel _titreSlider; 
	
	
	private JLabel _turn;
	
	
	//Jpanel  positionnement dans les Jpanel
	JPanel _mainContenaire;
	JPanel _panel1 ;
	JPanel _panel2 ;
	
	
	//controleur
	private InterfaceControleur _contoleurSimpleGame; 
	
	private Game _game;  
	
	public ViewCommand(Game g, InterfaceControleur c ) {
		super(); 
		this._game=g; 
		this._game.addObserver(this);
		this._contoleurSimpleGame=c; 
		//_contoleurSimpleGame.addO(this); 
		
		GridLayout _mainLayout = new GridLayout(2, 1);
		GridLayout _firstLayout = new GridLayout(1, 4);
		GridLayout _secondLoayout = new GridLayout(1, 2);
		
		_mainContenaire = new JPanel();
		_mainContenaire.setLayout(_mainLayout);
		
		_panel1 = new JPanel(); 
		_panel1.setLayout(_firstLayout);
		
		_panel2 = new JPanel();
		_panel2.setLayout(_secondLoayout);
			 
		
		//boutons
		Icon iconRun= new ImageIcon("Icones/icon_run.png");
		_boutonStart = new JButton(iconRun);
		_panel1.add(_boutonStart); 
			
		Icon iconRestart= new ImageIcon("Icones/icon_restart.png");
		 _boutonInit = new JButton(iconRestart);
		 _panel1.add(_boutonInit); 
		
		Icon iconStep= new ImageIcon("Icones/icon_step.png");
		_boutonStep = new JButton(iconStep);
		_panel1.add(_boutonStep); 
		
		Icon iconPause= new ImageIcon("Icones/icon_pause.png");
		_boutonStop = new JButton(iconPause);
		_panel1.add(_boutonStop); 
		
		//slider 
		JPanel sliderEtTitre = new JPanel();
		sliderEtTitre.setLayout(new GridLayout(2,1));
		
		_titreSlider =new JLabel("Nombre de tours par secondes");
		_titreSlider.setHorizontalAlignment(JLabel.CENTER);
		sliderEtTitre.add(_titreSlider);
			
		_slider = new JSlider(); 
			_slider.setMaximum(10);
			_slider.setMinimum(1);
			_slider.setValue(1);
			_slider.setPaintTicks(true);
			_slider.setPaintLabels(true);
			_slider.setMajorTickSpacing(1);
		sliderEtTitre.add(_slider);
		_panel2.add(sliderEtTitre);
		
		
		_turn = new JLabel("Tours: 0");
			_turn.setHorizontalAlignment(JLabel.CENTER);
		_panel2.add(_turn); 
		
			
		_mainContenaire.add(_panel1);
		_mainContenaire.add(_panel2);
		
		
		//this.setTitle("Commandes");
		//this.setSize(700, 200);	
		//this.add(_mainContenaire);
		//this.setLocationRelativeTo(null);
		//this.setVisible(true);
		
		
		_boutonStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evenement) {
				_contoleurSimpleGame.run();
				}

			});
		_boutonInit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evenement) {
				_contoleurSimpleGame.start();
				}

			});
		_boutonStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evenement) {
				_contoleurSimpleGame.stop();
				}

			});
		_boutonStep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evenement) {
				_contoleurSimpleGame.step();
				}

			});
		_slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int valeur= _slider.getValue(); 
				System.out.println(valeur);
				_contoleurSimpleGame.setTime(valeur);				
			}
		});
		
	}
	
	
	
	public JPanel get_mainContenaire() {
		return _mainContenaire;
	}



	public JLabel get_turn() {
		return _turn;
	}



	public void set_turn(JLabel _turn) {
		this._turn = _turn;
	}



	@Override
	public void update() {	
		this._turn.setText("tours : " + _game.get_turn());
		//jLabel.setHorizontalAlignment(JLabel.CENTER);
		
	}
	
	

}
