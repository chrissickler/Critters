package assignment4;

public class Critter1 extends Critter{
	
	private int x;
	private int y;
	
	public Critter1(int numX, int numY) {
		x = numX;
		y = numY;
	}

	@Override 
	public String toString(){
		return "1";
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
