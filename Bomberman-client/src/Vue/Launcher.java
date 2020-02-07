package Vue;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import Controleur.ControleurBombermanGame;
import Moteur.BombermanGame;

public class Launcher extends JFrame {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static String mapString; 
	public static int modeJeud=1; 
	public static Launcher unique_instance=null; 
	Map carte ; 
	JPanel ApercuCarte;
	
	private Launcher() {
		
		createMenu(); 
	}
	
	public static Launcher getInstanLauncher() {
		if (unique_instance==null)
			unique_instance = new Launcher(); 
		
		return unique_instance;
	}
	/**
	 * fonction qui crée le menu avec de selection du type de jeu et  du mode de jeu 
	 */
	
	public void createMenu() {
		this.setTitle("Selection Map Bomberman");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		JPanel parti1 = new JPanel(); 
		parti1.setLayout(new BorderLayout());
		
		File dossier = new File("./layouts/");
	    File[] fichiers =dossier.listFiles();
	    JComboBox<File> liste_layout = new JComboBox<File>(fichiers); 
	    
	    String CarteSelectioner = liste_layout.getSelectedItem().toString(); 
	    JButton boutonPlay = new JButton("Start"); 
	     
	     this.carte = null; 
	   
	    try {
			carte = new Map(CarteSelectioner);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	    
	   	ButtonGroup boutons = new ButtonGroup();
	    JRadioButton br1 = new JRadioButton("1 Joueurs");
	    JRadioButton br2 = new JRadioButton("Random Game");
	    br1.isSelected();
	    //JRadioButton br3 = new JRadioButton("Duel");

	    boutons.add(br1);
	    boutons.add(br2);
	    //boutons.add(br3);
	    
	    JLabel typeGame = new JLabel("Type de Jeu    :  "); 
	    
	   
	    parti1.add(liste_layout, BorderLayout.NORTH); 
	    parti1.add(typeGame, BorderLayout.WEST);
	    parti1.add(br1);
	    parti1.add( br2, BorderLayout.EAST );
	    parti1.add(boutonPlay, BorderLayout.SOUTH );
	    this.add("North", parti1);
	    
	 
	    ApercuCarte= new PanelBomberman(carte); 
	    this.add("Center",ApercuCarte);
		
		setSize(carte.getSizeX()*45, carte.getSizeY()*45+100);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		boutonPlay.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				String CarteSelectioner = liste_layout.getSelectedItem().toString();
				BombermanGame g = new BombermanGame(1000);
				try {
					ControleurBombermanGame a = new ControleurBombermanGame(g, CarteSelectioner);
					a.get_viewBomberman().setVisile(true); 
					mapString=CarteSelectioner;
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
				Launcher.this.dispose();
				//pas fini a gerer après 
			}
		});
		
		liste_layout.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			    String CarteSelectioner = liste_layout.getSelectedItem().toString(); 
			    Launcher.this.remove(ApercuCarte);
			    try {
					Launcher.this.ApercuCarte = new PanelBomberman(new Map(CarteSelectioner));
				    Launcher.this.add("Center",ApercuCarte);
					Launcher.this.revalidate();
					UpdateSize();
				   // Launcher.this.revalidate();	
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 

			}

			
		});
		br1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
					modeJeud=1; 
			}
		});
		br2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
					modeJeud=0; 
			}
		});
	}
	/**
	 * Fonction qui met a jour la la taille de la carte utiliser quand la carte est changer 
	 */
	void UpdateSize() {
		int random = (int) ((Math.random()*3)+1); 
		this.setSize(carte.getSizeX()*45+random, carte.getSizeY()*50+100+random);
		System.out.println("resized "+ random );
	}

}



