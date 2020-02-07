package Moteur.Agents.Strategies;



import java.awt.event.KeyEvent;

import Moteur.BombermanGame;
import Moteur.Game;
import Moteur.Agents.AgentAction;
import Moteur.Agents.InfoAgent;
import Vue.PanelBomberman;
import Vue.ViewBombermanGame;
import Vue.VueClavier;



public class BombermanClavierSeul implements Strategie {

	BombermanGame _bonberman; 
	public BombermanClavierSeul(BombermanGame g) {
		// TODO Auto-generated constructor stub
		this._bonberman=g; 
	}
	@Override
	public AgentAction getAction(InfoAgent agent) {
		
		_bonberman.get_controleurBomberman().SetVuClavier();
		VueClavier vu = _bonberman.get_controleurBomberman().getVuClaiver(); 
		vu.addKeyListener(vu);
		
		switch (vu.getKeyPressed())
        {
            case KeyEvent.VK_UP:
                return AgentAction.MOVE_DOWN;
            case KeyEvent.VK_LEFT:
            	return AgentAction.MOVE_LEFT;
            case KeyEvent.VK_RIGHT:
            	return AgentAction.MOVE_RIGHT;
            case KeyEvent.VK_DOWN:
            	return AgentAction.MOVE_UP;
            case KeyEvent.VK_NUMPAD0:
            	return AgentAction.PUT_BOMB;
            case KeyEvent.VK_NUMPAD1:
            	return AgentAction.STOP;
            default:
            	return AgentAction.STOP;
        } 

	}

}
