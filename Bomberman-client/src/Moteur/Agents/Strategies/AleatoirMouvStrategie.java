package Moteur.Agents.Strategies;

import java.util.Random;

import Moteur.Agents.AgentAction;
import Moteur.Agents.InfoAgent;


public class AleatoirMouvStrategie  implements Strategie{

	@Override
	public AgentAction getAction(InfoAgent agent) {
		AgentAction[] action = {AgentAction.STOP, AgentAction.PUT_BOMB,AgentAction.MOVE_UP, AgentAction.MOVE_UP,AgentAction.MOVE_RIGHT, AgentAction.MOVE_DOWN, AgentAction.MOVE_LEFT,  }; 
		int random = new  Random().nextInt(action.length); 
		
		return action[random];
	}

}
