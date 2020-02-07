package Moteur.Agents;

import Moteur.Agents.Strategies.Strategie;

public class AgentPNJ  extends Agent{
	
	
	public AgentPNJ(int x, int y, char type, AgentAction agentAction, Strategie s ) {
		super(x, y, agentAction, type , ColorAgent.DEFAULT, false, false);
		// TODO Auto-generated constructor stub
		
	}
	
	

	/*
	public boolean isLegalMove(Agent agent, AgentAction action) {
		int x = this.getX();
		int y = this.getY();
		
		if (action== AgentAction.MOVE_DOWN) {
			y++;
		}
		if (action== AgentAction.MOVE_UP) {
			y--;
		}
		if (action== AgentAction.MOVE_LEFT) {
			x++;
		}
		if (action== AgentAction.MOVE_RIGHT) {
			x--;
		}
		
		//les bird peuvent aller au dela des murs cassable
		if (this._strategie instanceof BirdStrategie)
		{
			if (!game.appartientMap(x,y) || game.get_controleurBomberman().get_viewBomberman().get_map().get_walls()[x][y]
			|| game.positionBomberVerif(x, y) ) {
				return false; 
			}
			else 
				return true;
		}
		else {
			//verification si il ya pas de mur, bombe et que la position appartient au map 
		
			if (!game.appartientMap(x,y) || game.get_controleurBomberman().get_viewBomberman().get_map().get_walls()[x][y]
					|| game.get_controleurBomberman().get_viewBomberman().get_map().getStart_brokable_walls()[x][y] || game.positionBomberVerif(x, y) ) {
				return false; 
			}
			else 
				return true;
	
		}
	}
	



*/
	

}
