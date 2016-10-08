package assignment4;

public class Critter4 extends Critter{

	private int x;
	private int y;
	private int energy;
	
	public Critter4(int numX, int numY) {
		x = numX;
		y = numY;
	}

	@Override
	public String toString(){
		return "4";
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
