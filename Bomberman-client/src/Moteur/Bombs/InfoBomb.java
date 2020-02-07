package Moteur.Bombs;

public class InfoBomb {
	
	private int x;
	private int y;
	private int range;
		
	StateBomb stateBomb;
	
	int idBombe;

	public InfoBomb(int x, int y, int range, StateBomb stateBomb, int id) {
		this.x=x;
		this.y=y;
		this.range=range;
		this.stateBomb = stateBomb;
		this.idBombe=id;

	}


	
	public int getIdBombe() {
		return idBombe;
	}



	public void setIdBombe(int idBombe) {
		this.idBombe = idBombe;
	}



	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}



	public StateBomb getStateBomb() {
		return stateBomb;
	}



	public void setStateBomb(StateBomb stateBomb) {
		this.stateBomb = stateBomb;
	}



	public int getRange() {
		return range;
	}


	public void setRange(int range) {
		this.range = range;
	}


	
}
	