package assignment4;

public class Critter4 extends Critter{

	private int x;
	private int y;
	private int dir;
	private int energy;
		
	public Critter4(int numX, int numY, int startEnergy) {
		x = numX;
		y = numY;
		dir = Critter.getRandomInt(8);
		energy = startEnergy;
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
