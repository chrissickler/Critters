package assignment4;

public class Critter3 extends Critter{

	private int x;
	private int y;
	private int energy;
	
	public Critter3(int numX, int numY) {
		x = numX;
		y = numY;
	}

	@Override
	public String toString(){
		return "3";
	}
	
	@Override
	public void doTimeStep() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean fight(String oponent) {
		// TODO Auto-generated method stub
		return false;
	}

}
