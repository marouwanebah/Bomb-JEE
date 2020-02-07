package Moteur.Agents;

import java.util.ArrayList;
import Moteur.Bombs.InfoBomb;
import Moteur.Items.InfoItem;

public class AgentBomberman extends Agent{

	private ArrayList<InfoBomb> _BombesAgent;
	public AgentBomberman(int x, int y, ColorAgent c,  AgentAction agentAction) {
		super(x, y, agentAction, 'B', c, false, false);
		// TODO Auto-generated constructor stub
		this._BombesAgent =  new ArrayList<InfoBomb>();
	}
	public ArrayList<InfoBomb> get_BombesAgent() {
		return _BombesAgent;
	}
	public void add_BombesAgent(InfoBomb Bombes) {
		_BombesAgent.add(Bombes);
	}
	public void clear_BombesAgent() {
		_BombesAgent.clear();
	}
	
	
}
