package Moteur.Agents;

import Moteur.Agents.Strategies.Strategie;

public abstract class Agent extends InfoAgent {
	
	private static int _idAgent=1; 
	private int identifiant; 
	private Strategie _strategie; 
	
	public Agent(int x, int y, AgentAction agentAction, char type, ColorAgent color, boolean isInvincible,
			boolean isSick) {
		super(x, y, agentAction, type, color, isInvincible, isSick);
		// TODO Auto-generated constructor stub7
		this.identifiant=_idAgent; 
		_idAgent++; 
	

	}

	public int getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(int identifiant) {
		this.identifiant = identifiant;
	}

	public Strategie get_strategie() {
		return _strategie;
	}

	public void set_strategie(Strategie _strategie) {
		this._strategie = _strategie;
		AgentAction action = _strategie.getAction(this);
		this.setAgentAction(action);
	}

	


	
}
