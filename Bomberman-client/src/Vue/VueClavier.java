package Vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * class utilisé pour faire bouger les agent bomberman et afficher les touches 
 * @author etudiant
 *
 */
public class VueClavier extends JFrame implements KeyListener{

	private static final long serialVersionUID = 1L;
	private static VueClavier uniqueInstance = null;
	int codeKeyPressed;
	
	private VueClavier() {
		setTitle("Fenêtre de commande");
		setSize(new Dimension(300,400));

	
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setLayout(new GridLayout(8,1));
		
		JLabel labelJoueur1 = new JLabel("Touches Joueur 1 : ", JLabel.CENTER);
		labelJoueur1.setForeground(Color.BLUE);
		panelPrincipal.add(labelJoueur1);
		
		JPanel panelCommandeJ1 = new JPanel();
		panelCommandeJ1.setLayout(new GridLayout(2,3));
		
		
		panelCommandeJ1.add(new JLabel(""));
		panelCommandeJ1.add(createLabelTouche("Haut"));
		panelCommandeJ1.add(new JLabel(""));
		panelCommandeJ1.add(createLabelTouche("Bas"));
		panelCommandeJ1.add(createLabelTouche("Gauche"));
		panelCommandeJ1.add(createLabelTouche("Droite"));
		
		panelPrincipal.add(panelCommandeJ1);
		
		JLabel labelBombeJ1 = new JLabel("Poser Bombe : Touche 0");
		panelPrincipal.add(labelBombeJ1);

		JLabel labelStopJ1 = new JLabel("Ne rien faire : Touche 1");
		panelPrincipal.add(labelStopJ1);
		


		
		setContentPane(panelPrincipal);
		setVisible(true);
	}
	
	public static VueClavier getInstance() {
		if(uniqueInstance == null) {
			uniqueInstance = new VueClavier();
		}
		return uniqueInstance;
	}
	
	public JLabel createLabelTouche(String nom) {
		JLabel label = new JLabel(nom, JLabel.CENTER);
		label.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		
		return label;
	}

	@Override
	public void keyPressed(KeyEvent key) {
		this.codeKeyPressed = key.getKeyCode();
	}

	@Override
	public void keyReleased(KeyEvent key) {	
	}

	@Override
	public void keyTyped(KeyEvent key) {
	}
	
	public int getKeyPressed() {
		return this.codeKeyPressed;
	}
}
