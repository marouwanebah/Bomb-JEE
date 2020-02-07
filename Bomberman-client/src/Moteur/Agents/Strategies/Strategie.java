package Moteur.Agents.Strategies;

import Moteur.Agents.AgentAction;
import Moteur.Agents.InfoAgent;

public interface Strategie {
	public AgentAction getAction(InfoAgent agent );
}
