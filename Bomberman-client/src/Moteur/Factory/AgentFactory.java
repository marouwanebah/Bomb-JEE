package Moteur.Factory;

import Moteur.Agents.AgentAction;
import Moteur.Agents.ColorAgent;
import Moteur.Agents.InfoAgent;

public abstract class AgentFactory {
	public abstract InfoAgent makeAgent(int x, int y, char type, ColorAgent c, AgentAction agentAction); 
}
