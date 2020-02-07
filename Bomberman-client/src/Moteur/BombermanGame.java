package Moteur;

import java.awt.Desktop.Action;
import java.util.ArrayList;
import java.util.Random;

import Controleur.ControleurBombermanGame;
import Moteur.Agents.Agent;
import Moteur.Agents.AgentAction;
import Moteur.Agents.AgentBird;
import Moteur.Agents.AgentBomberman;
import Moteur.Agents.AgentPNJ;
import Moteur.Agents.InfoAgent;
import Moteur.Agents.Strategies.AleatoirMouvStrategie;
import Moteur.Agents.Strategies.BirdStrategie;
import Moteur.Agents.Strategies.BombermanClavierSeul;
import Moteur.Bombs.InfoBomb;
import Moteur.Bombs.StateBomb;
import Moteur.Factory.AgentPNJFactory;
import Moteur.Factory.BombermanFactory;
import Moteur.Items.InfoItem;
import Moteur.Items.ItemType;
import Vue.Launcher;
import Vue.ViewSimpleGame;

public class BombermanGame extends Game {

	public static ArrayList<InfoAgent> _agentPositiontrategie; 
	
	private ArrayList<InfoAgent> _agents; 
	private ArrayList<InfoAgent> _agentDebut; 
	private ArrayList<InfoBomb> _bombes= new ArrayList<>(); 
	private boolean[][] _listBreakableWalls;
	private ArrayList<InfoItem> _listItems = new ArrayList<>();
	
	private ArrayList<InfoBomb> SuprimeBombeExploded = new ArrayList<>();

	private ControleurBombermanGame _controleurBomberman; 
	
	private final static int PROBABILITE_Item = 10;
	
	
	  
	public BombermanGame(int maxturn) {
		super(maxturn);
		
	}


	
	public boolean[][] get_listBreakableWalls() {
		return _listBreakableWalls;
	}


	public void set_listBreakableWalls(boolean[][] _listBreakableWalls) {
		this._listBreakableWalls = _listBreakableWalls;
	}
	
	public ArrayList<InfoBomb> get_bombes() {
		return _bombes;
	}


	public void set_bombes(ArrayList<InfoBomb> _bombes) {
		this._bombes = _bombes;
	}


	public ArrayList<InfoItem> get_listItems() {
		return _listItems;
	}


	public void set_listItems(ArrayList<InfoItem> _listItems) {
		this._listItems = _listItems;
	}


	public void set_agents(ArrayList<InfoAgent> _agents) {
		this._agents = _agents;
	}


	public ArrayList<InfoAgent> get_agents() {
		return _agents;
	}

/**
 * fonction qui initialise le jeu avec les agent et les coordonée des diffirent elements  du map charger 
 */

	@Override
	public void intializeGame() {
		System.out.println("initialisation du jeu test");
		this._agents = new ArrayList<InfoAgent>();
		this._agentDebut = new ArrayList<InfoAgent>();

		try {
			_controleurBomberman = new ControleurBombermanGame(this, Launcher.mapString);
			//_controleurBomberman.get_viewBomberman().getDefaultCloseOperation();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		_agentDebut = _controleurBomberman.get_viewBomberman().get_map().getStart_agents(); 
		
		for(InfoAgent agent : _agentDebut)
		{

			if(agent.getType()=='B') {
				System.out.println("Bomboberman player");
				BombermanFactory b = new BombermanFactory(); 
				_agents.add(b.makeAgent(agent.getX(), agent.getY(), 'B',agent.getColor(), agent.getAgentAction() ));  
			}
			else {
				System.out.println("Enn");
				AgentPNJFactory a = new AgentPNJFactory(); 
				_agents.add(a.makeAgent(agent.getX(), agent.getY(), agent.getType(), agent.getColor(),   agent.getAgentAction()));
			}
		}
		
		
		/*
		boolean[][] breakableWalls =  this._controleurBomberman.get_viewBomberman().get_map().getStart_brokable_walls() ; 
		this._listBreakableWalls = new boolean[breakableWalls.length][breakableWalls[0].length];
		int i=0, j=0; 
		for(boolean[] tableau : breakableWalls ) {
			for (boolean element : tableau) {
				this._listBreakableWalls[i][j]=element; 
				j++;
			}
			++i; 
			j=0; 
		}
		
		*/

		int tailleX = this._controleurBomberman.get_viewBomberman().get_map().getStart_brokable_walls().length;
		int tailleY = this._controleurBomberman.get_viewBomberman().get_map().getStart_brokable_walls()[0].length;
		//int tailleY = ViewBombermanGame.getMap_jeu().getStart_brokable_walls()[0].length;
		this._listBreakableWalls = new boolean[tailleX][tailleY];
		
		for(int i = 0 ; i < tailleX ; i++) {
			for(int j = 0 ; j < tailleY ; j++) {
				this._listBreakableWalls[i][j] = this._controleurBomberman.get_viewBomberman().get_map().getStart_brokable_walls()[i][j];
			}
		}
		
		this._bombes=new ArrayList<InfoBomb>();
		this._listItems= new ArrayList<InfoItem>();
		_agentPositiontrategie = new ArrayList<InfoAgent>();
	}
	

	
	

	public ControleurBombermanGame get_controleurBomberman() {
		return _controleurBomberman;
	}



	public void set_controleurBomberman(ControleurBombermanGame _controleurBomberman) {
		this._controleurBomberman = _controleurBomberman;
	}

	/**
	 * fonction qui permet de verifier le coodoner d'une bombe pour que les agent bomberman ne puissent pas aller sur les bombe 
	 * @param x
	 * @param y
	 * @return
	 */
	public boolean positionBomberVerif(int x, int y) {
		for(InfoBomb bomb : this._bombes) {
			if(bomb.getX() == x && bomb.getY() == y) {
				return true;
			}
		}
		return false;
	}
	


	@Override
	public void gameOver() {
		System.out.println("GameOver");
		int test = 0, testPNJ=0; 
		for (InfoAgent a :  _agents) {
			if (a instanceof AgentBomberman) {
				test++; 
			}
			if (a instanceof AgentPNJ) {
				testPNJ++; 
			}
		}
		if(testPNJ==0 && test==1) {
			ViewSimpleGame a = _controleurBomberman.get_viewBomberman().get_gameOver();  
				a = new ViewSimpleGame(this, _controleurBomberman, "Fin du jeu - Victoir de l'agent Bomberman");
		}else
		if(testPNJ>0 && test==0) {
			ViewSimpleGame a = _controleurBomberman.get_viewBomberman().get_gameOver();  
			a = new ViewSimpleGame(this, _controleurBomberman, "Fin du jeu - Victoir ds agents PNJ");
		}else {
			ViewSimpleGame a = _controleurBomberman.get_viewBomberman().get_gameOver();  
			a = new ViewSimpleGame(this, _controleurBomberman, "Fin du jeu ");
		}
		System.out.println(test +"  " + testPNJ);
			
	}

	/**
	 * condition de fin jeu si il ya plus de bombemran victoire de PNJ et si il ya qu'un Agent victoir de l'agent 
	 */
	@Override
	public boolean gameContinue() {
		ArrayList<AgentBomberman> agentBomberman = new ArrayList<AgentBomberman>(); 
		ArrayList<AgentPNJ> agentPNJ = new ArrayList<AgentPNJ>(); 
		for (InfoAgent a : _agents ) {
			if (a instanceof AgentBomberman) {
				agentBomberman.add((AgentBomberman) a);
			}
			
			if(a instanceof AgentPNJ) {
				agentPNJ.add( (AgentPNJ) a); 
			}
				
		}
		if (agentBomberman.size()==0)
			return false; 
		if(agentBomberman.size()==1 && agentPNJ.size()==0)
			return false; 
			
		return true;
	}

	@Override
	public void takeTurn() {
		System.out.println("take turn ---------");
		for (InfoAgent agent : this._agents) {
			if (agent instanceof AgentBird) {
				((AgentBird) agent).set_strategie( new BirdStrategie());
				if (isLegalMove( ((AgentBird) agent), agent.getAgentAction())){
					moveAgent( ((AgentBird) agent), agent.getAgentAction() );
		/*			AgentBomberman agenbomberman = getAgentBombermanByCoord(agent.getX(), agent.getY());
					if(agenbomberman != null) {
						_agents.remove(agenbomberman);
					}
			*/	}
				
			}
			else
			if (agent instanceof AgentPNJ) {
				((AgentPNJ) agent).set_strategie( new AleatoirMouvStrategie());		    		 
				if (isLegalMove( ((AgentPNJ) agent), agent.getAgentAction())){
					moveAgent( ((AgentPNJ) agent), agent.getAgentAction() );
					//System.out.println(action[random]);

				}	
			}
			
			else 
			{
				if( Launcher.modeJeud==1 ) {
					BombermanClavierSeul a = new BombermanClavierSeul(this); 
					((AgentBomberman) agent).set_strategie( a);
					if (isLegalMove( ((AgentBomberman) agent), agent.getAgentAction())){
						if (agent.getAgentAction()==AgentAction.PUT_BOMB) {
							InfoBomb b = new InfoBomb(agent.getX(), agent.getY(), 2, StateBomb.Step1, agent.get_identifiantAgent()); 
							_bombes.add(b);
						}
						else	
						moveAgent( ((AgentBomberman) agent), agent.getAgentAction() );
					}
				}
				if (Launcher.modeJeud==0) {

					((AgentBomberman) agent).set_strategie( new AleatoirMouvStrategie());
					if (isLegalMove( ((AgentBomberman) agent), agent.getAgentAction())){
						if (agent.getAgentAction()==AgentAction.PUT_BOMB) {
							System.out.println("info BOoooooooooooooooooooooooommmB");
							InfoBomb b = new InfoBomb(agent.getX(), agent.getY(), 2, StateBomb.Step1, agent.get_identifiantAgent()); 
							_bombes.add(b);
						}else
						moveAgent( ((AgentBomberman) agent), agent.getAgentAction() );
						//System.out.println(action[random]);
					}					
				}
				
			}
			_agentPositiontrategie.add(agent);
				
		}

		TourBom();
		removeAgentSiToucherParPNJ();
		
	}
	
	/**
	 * fonction qui tue un bomberman tu toucje un agent PNJ 
	 */
	public void removeAgentSiToucherParPNJ() {
		int test =0,positon=0; 
		
		for(int i= 0; i<_agents.size(); i++) {
			if(_agents.get(i) instanceof AgentBomberman) {
				for (InfoAgent enemie : _agents ) {
					if(enemie instanceof AgentPNJ) {
						if(_agents.get(i).getX()==enemie.getX() && _agents.get(i).getY()==enemie.getY() ) {
							test=i;  
							positon=1; 
							System.out.println("agent toucher++++++++++++++++++++++++++");
						}
					}
				}
			}	
		 
		}
		if ( positon !=0) {
			_agents.remove(test); 
			test=0;
		}

	}
	
/**
 * fonction qui verifie que la nouvelle position de l'agent peut etre correct avant sont déplacement 
 * @param agent
 * @param action
 * @return
 */
	public boolean isLegalMove(Agent agent, AgentAction action) {
		int x = agent.getX();
		int y = agent.getY();
		
		if (action== AgentAction.MOVE_DOWN) {
			y--;
		}
		if (action== AgentAction.MOVE_UP) {
			y++;
		}
		if (action== AgentAction.MOVE_LEFT) {
			x--;
		}
		if (action== AgentAction.MOVE_RIGHT) {
			x++;
		}
		if(agent instanceof AgentBomberman && action==AgentAction.PUT_BOMB) {
			return true;
		}


		//aucun agent ne peut aller au dela des murs non cassable
		if(this._controleurBomberman.get_viewBomberman().get_map().get_walls()[x][y]) {
			return false; 
		}
		//pour les agents bomberman impossibilité d'aller sur les mur non cassables  ou sur les bombes ou sur les autres agent
		if ( agent instanceof AgentBomberman) {
		if(this._listBreakableWalls[x][y] || positionBombe(x, y) || positionAutreAgentBomberman(x, y))
			return false; 
		}
		//les agents bird peuvent aller sur les murs cassable
		if (agent instanceof  AgentBird  ) {
			return true;
		}
		if (agent instanceof AgentPNJ) {
			if(this._listBreakableWalls[x][y])
				return false;
			
		}
		
		return true;
	}
	
/**
 * fonction qui déplace un agent 
 * @param agent
 * @param action
 */
	public void moveAgent(Agent agent, AgentAction action) {
		int x = agent.getX();
		int y = agent.getY();
		
		switch(action) {
		case MOVE_UP: 
			y++;
			break;
		case MOVE_DOWN:
			y--;
			break;
		case MOVE_LEFT:
			x--;
			break;
		case MOVE_RIGHT:
			x++;
			break;
		case STOP:
			break;
		default :
			break;
		}
			agent.setX(x);
			agent.setY(y);
		
	}

/**	
 * verifier si il ya une bombe sur une position donnée 
 * @param x
 * @param y
 * @return
 */
	public boolean positionBombe(int x , int y) {
		for (InfoBomb a : _bombes) {
			if(a.getX()==x && a.getY()==y)
				return true; 
		}
		return false ;
			
	}
	/**
	 * fonction qui verifier si il ya un autre agent bomberman sur une coordonée utiliser pour faire un sorte qu'un bomberman ne puisse pas aller sur un autre 
	 * @param x
	 * @param y
	 * @return
	 */
	public boolean positionAutreAgentBomberman(int x , int y) {
		for (InfoAgent a : _agents) {
			if (a instanceof AgentBomberman) {
				if(a.getX()==x && a.getY()==y)
					return true; 
			}
		}
		return false ;
	}
	
/**
 * fonction qui retour un agent bomberman si il est sur une position donnée ou null sinon 	
 * @param x
 * @param y
 * @return
 */
	public AgentBomberman getAgentBombermanByCoord(int x, int y) {
		for(InfoAgent agent : this._agents) {
			if ( agent instanceof AgentBomberman) {
				if(agent.getX() == x && agent.getY() == y) {
					System.out.println("non");
					return  (AgentBomberman) agent;
					
				}
			}
		}
		return null;
	}
	
	
	/**
	 * fonction qui fait evoluer l'état des bombe de step 1 a boom et supression des bombes qui on fait boom 
	 */
	public void TourBom(){
		for(InfoBomb bomb : _bombes) {
			switch(bomb.getStateBomb()) {
			case Step1 :
				bomb.setStateBomb(StateBomb.Step2);
				break;
			case Step2 :
				bomb.setStateBomb(StateBomb.Step3);
				break;
			case Step3 :
				bomb.setStateBomb(StateBomb.Boom);
				break;
			case Boom :
				SuprimeBombeExploded.add(bomb);
				Explosion(bomb);		
				break;
			default :
				break;
			}
		}
		/**
		 * suppresion des bombes apres explosion 
		 */
		for(InfoBomb bomb : SuprimeBombeExploded) {
			_bombes.remove(bomb);
		}
		SuprimeBombeExploded.clear();
		

	}
	/**
	 * 
	 * fonction qui fai exploser un bomber en faison appraitre sur 1 chanche sur 10 un item 
	 * @param bomb
	 */
	
	public void Explosion(InfoBomb bomb) {
		int x = bomb.getX();
		int y = bomb.getY();
		int range = bomb.getRange();
		int RadomItemp = (int) (Math.random() * PROBABILITE_Item); 
		ItemType[] listItems = { ItemType.BOMB_DOWN, ItemType.BOMB_UP,  ItemType.FIRE_DOWN,  ItemType.FIRE_SUIT, ItemType.FIRE_UP, ItemType.SKULL  }; 
		
		for(int i = x; i <= x+range; i++ ) {
			
			if( i > 0 && i < _controleurBomberman.get_viewBomberman().get_map().getSizeX() ) {
				if(_controleurBomberman.get_viewBomberman().get_map().get_walls()[i][y]) {
					break;
				}
				if(this._listBreakableWalls[i][y]) {
					this._listBreakableWalls[i][y] =false;
					if(RadomItemp==5) {
						int index= new Random().nextInt(listItems.length); 
						InfoItem item = new InfoItem(i, y, listItems[index] ); 
						_listItems.add(item);
					}
					break;
				}
				Degat(i,y,bomb);
			}
			
		}
		
		for(int i = x; i >= x-range; i--) {
			
			if( i > 0 && i < _controleurBomberman.get_viewBomberman().get_map().getSizeX() ) {
				if(_controleurBomberman.get_viewBomberman().get_map().get_walls()[i][y]) {
					break;
				}
				if(this._listBreakableWalls[i][y]) {
					this._listBreakableWalls[i][y] =false;
					if(RadomItemp==5) {
						int index= new Random().nextInt(listItems.length); 
						InfoItem item = new InfoItem(i, y, listItems[index] ); 
						_listItems.add(item);
					}
					break;
				}
				Degat(i,y,bomb);
			}
		}
		
		for(int i = y; i <= y+range; i++ ) {
			
			if( i > 0 && i < _controleurBomberman.get_viewBomberman().get_map().getSizeY() ) {
				if(_controleurBomberman.get_viewBomberman().get_map().get_walls()[i][y]) {
					break;
				}
				if(this._listBreakableWalls[x][i]) {
					this._listBreakableWalls[x][i] =false;
					if(RadomItemp==5) {
						int index= new Random().nextInt(listItems.length); 
						InfoItem item = new InfoItem(i, y, listItems[index] ); 
						_listItems.add(item);
					}
					break;
				}
				Degat(x,i,bomb);
			}
		}
		
		for(int i = y; i >= y-range; i-- ) {
			
			if( i > 0 && i < _controleurBomberman.get_viewBomberman().get_map().getSizeY() ) {
				if(_controleurBomberman.get_viewBomberman().get_map().get_walls()[i][y]) {
					break;
				}
				if(this._listBreakableWalls[x][i]) {
					this._listBreakableWalls[x][i] =false;
					if(RadomItemp==5) {
						int index= new Random().nextInt(listItems.length); 
						InfoItem item = new InfoItem(i, y, listItems[index] ); 
						_listItems.add(item);
					}
					break;
				}
				Degat(x,i,bomb);
			}
		}
	}
	/**
	 * fonction qui elimine les agent Emenie toucjer par une explossion de bomse seul l'agent qui est porprietaire de la bombe qui n'est pas impacté 
	 * @param x
	 * @param y
	 * @param bomb
	 */
		public void Degat(int x, int y,InfoBomb bomb) {
			for(InfoAgent agent : _agents) {
				if (agent instanceof AgentBomberman) {
					if(agent.getX()==x && agent.getY()==y && !agent.isInvincible() && agent.get_identifiantAgent()!=bomb.getIdBombe() ) {
				//		for(InfoBomb a : ((AgentBomberman) agent).get_BombesAgent()) {
				//			if(a==bomb) {
								
				//			}
				//			else
								_agents.remove(agent);
				//		}
					}
					break;
				}
				if (agent instanceof AgentPNJ)
				if(agent.getX()==x && agent.getY()==y && !agent.isInvincible()) {
					_agents.remove(agent);
					break;
				}
			}
		}
		
		
	}	

