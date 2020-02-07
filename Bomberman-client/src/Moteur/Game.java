package Moteur;

import java.util.ArrayList;

public abstract class Game  implements Runnable, Moteur.Observable {
	
	private int _turn;
	private int _maxturn;
	private boolean _isRunning; 
	private Thread _thread; 
	private long _time;
	
	public static int valeurTime = 1000; 
	private ArrayList<Observer> observers = new ArrayList<>();


	public Game(int maxturn) {
		this._maxturn=maxturn; 
		_time = valeurTime;
	}
	
	public void launch() {
		_isRunning = true; 
		this._thread = new Thread(this);
		_thread.start(); 
	}

	public void init() {
		this._turn=0;
		this._isRunning=true; 
		intializeGame();
		notifyObserver();
	}
	
	public void step() {
		if (gameContinue() && _turn<_maxturn) {
			_turn++;
			takeTurn();	
		}
		else 
		{
			this._isRunning=false; 
			gameOver();
		}
		notifyObserver();
	}
	
	public void run() {
		while (this._isRunning!=false)
		{
			step(); 
			try {
				Thread.sleep(_time);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void stop() {
		this._isRunning=false; 
	}
	


	public int get_turn() {
		return _turn;
	}

	public void set_turn(int _turn) {
		this._turn = _turn;
	}

	public int get_maxturn() {
		return _maxturn;
	}

	public void set_maxturn(int _maxturn) {
		this._maxturn = _maxturn;
	}

	public boolean is_isRunning() {
		return _isRunning;
	}

	public void set_isRunning(boolean _isRunning) {
		this._isRunning = _isRunning;
	}

	public Thread get_thread() {
		return _thread;
	}

	public void set_thread(Thread _thread) {
		this._thread = _thread;
	}

	public long get_time() {
		return _time;
	}

	public void set_time(long _time) {
		this._time = 1000/_time;
	}

	public static int getValeurTime() {
		return valeurTime;
	}

	public static void setValeurTime(int valeurTime) {
		Game.valeurTime = valeurTime;
	}

	public abstract void intializeGame();
	public abstract void gameOver();
	public abstract boolean gameContinue();
	public abstract void takeTurn(); 


	
	public void addObserver(Observer observer){
		observers.add(observer);
	}
	
	public void removeObserver(Observer observer){
		observers.remove(observer);
	}
	
	public void notifyObserver(){
		for(int i=0;i<observers.size();i++){
			observers.get(i).update();
		}
	}
	
}