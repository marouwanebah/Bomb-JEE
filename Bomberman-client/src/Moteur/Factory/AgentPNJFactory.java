package Moteur.Factory;

import Moteur.Agents.AgentAction;
import Moteur.Agents.AgentBird;
import Moteur.Agents.AgentPNJ;
import Moteur.Agents.ColorAgent;
import Moteur.Agents.InfoAgent;
import Moteur.Agents.Strategies.BirdStrategie;
import Moteur.Agents.Strategies.EnemieStrategie;
import Moteur.Agents.Strategies.RajionStrategie;
import Moteur.Agents.Strategies.Strategie;

public class AgentPNJFactory extends AgentFactory {


	@Override
	public InfoAgent makeAgent(int x, int y, char type,ColorAgent c,  AgentAction agentAction) {
		if(type=='V') {
			Strategie a = new BirdStrategie(); 
		return new AgentBird(x, y, type, agentAction,a);
		}
		if(type=='E') {
			Strategie a = new EnemieStrategie(); 
		return new AgentPNJ(x, y, type,  agentAction, a);
		}
		
		else {
			return new AgentPNJ(x, y, type,  agentAction, new RajionStrategie() ); 
		}
	}

}
