package Moteur.Factory;

import Moteur.Agents.AgentAction;
import Moteur.Agents.AgentBomberman;
import Moteur.Agents.ColorAgent;
import Moteur.Agents.InfoAgent;

public class BombermanFactory extends AgentFactory {


	@Override
	public InfoAgent makeAgent(int x, int y,char type, ColorAgent c,  AgentAction agentAction) {

				return new AgentBomberman(x, y,c, agentAction);

			
	}

}
