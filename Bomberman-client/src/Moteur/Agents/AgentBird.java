package Moteur.Agents;

import Moteur.Agents.Strategies.Strategie;

 

public class AgentBird extends AgentPNJ {
	
	boolean _estEndormi=true;;
	public AgentBird(int x, int y, char type, AgentAction agentAction, Strategie s) {
		super(x, y, type, agentAction, s);
		// TODO Auto-generated constructor stub
		
	
	}
	public boolean is_estEndormi() {
		return _estEndormi;
	}
	public void set_estEndormi(boolean _estEndormi) {
		this._estEndormi = _estEndormi;
	}

}
