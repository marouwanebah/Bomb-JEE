package Moteur;

public class SimpleGame extends Game {
	
	

	public SimpleGame(int maxturn) {
		super(maxturn);
		
	}

	@Override
	public void intializeGame() {
		System.out.println("Initialisation du jeu");
		
	}

	@Override
	public void gameOver() {
		System.out.println("Game Over");
		
	}

	@Override
	public boolean gameContinue() {
		return true;
	}

	@Override
	public void takeTurn() {
		System.out.println("Tour Courant "+ get_turn()+ " du jeu en cours"   );
	}

}
