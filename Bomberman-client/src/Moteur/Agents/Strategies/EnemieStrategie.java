package Moteur.Agents.Strategies;


import Moteur.Agents.AgentAction;
import Moteur.Agents.InfoAgent;


public class EnemieStrategie implements Strategie {

	@Override
	public AgentAction getAction(InfoAgent agent) {
		int random = (int) (Math.random() *4);
		if(random ==0)
			return AgentAction.MOVE_DOWN;
		else if(random ==1)
			return AgentAction.MOVE_LEFT;
		else if(random ==2)
			return AgentAction.MOVE_RIGHT;
		else if(random ==1)
			return AgentAction.MOVE_UP;
		else return AgentAction.STOP;
	}

}
