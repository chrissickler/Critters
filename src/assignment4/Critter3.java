package assignment4;

public class Critter3 extends Critter{

	private int x;
	private int y;
	private int dir;
	private int energy;
	
	public Critter3(){}

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

	public int getDir() {
		return dir;
	}

	public void setDir(int dir) {
		this.dir = dir;
	}

	public int getEnergy() {
		return energy;
	}

	public void setEnergy(int energy) {
		this.energy = energy;
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
