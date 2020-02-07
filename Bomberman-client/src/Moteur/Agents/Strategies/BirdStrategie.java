package Moteur.Agents.Strategies;


import java.util.ArrayList;

import Moteur.BombermanGame;
import Moteur.Agents.AgentAction;
import Moteur.Agents.AgentBird;

import Moteur.Agents.InfoAgent;

/**
 * les Bird son endormie au départ puis si un bomberman aproche su un rayon de 6  les bird se reveil et va vers la direction du bomberman 
 * @author etudiant
 *
 */
public class BirdStrategie implements Strategie {

	@Override
	public AgentAction getAction(InfoAgent agent) {
		ArrayList<InfoAgent> agentRayon = new ArrayList<>();
		int rayonAction = 6;
		//AgentBird bird = (AgentBird) agent; 
		
		for ( InfoAgent a : BombermanGame._agentPositiontrategie) {
			if ( a.getType()=='B') {
			     if ((Math.abs(agent.getX() - a.getX()) < rayonAction) && (Math.abs(agent.getY() - a.getY()) < rayonAction)) {
			         			agentRayon.add(a);	
			     }
			}	
		}
		
        if (!agentRayon.isEmpty()) {
            int procheDist = rayonAction*2;
            InfoAgent procheBomb = null;

            for (InfoAgent i : agentRayon) {
                int dist = Math.abs(agent.getX() - i.getX()) + Math.abs(agent.getY() - i.getY());
                if (dist < procheDist) {
                    procheDist = dist;
                    procheBomb = i;
                }
            }

            assert procheBomb != null;

            if (Math.abs(agent.getX() - procheBomb.getX()) >= Math.abs(agent.getY() - procheBomb.getY())) {
                if (agent.getX() < procheBomb.getX()) {
                    return AgentAction.MOVE_RIGHT;
                } else {
                    return AgentAction.MOVE_LEFT;
                }
            } else {
                if (agent.getY() < procheBomb.getY()) {
                    return AgentAction.MOVE_UP;
                } else {
                    return AgentAction.MOVE_DOWN;
                }
            }
        } else 
            return AgentAction.STOP;
        
    }
		
}