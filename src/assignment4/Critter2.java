package assignment4;

public class Critter2 extends Critter{
	
	private int dir;
	
	public Critter2(){}

	public int getDir() {
		return dir;
	}


	public void setDir(int dir) {
		this.dir = dir;
	}


	@Override
	public String toString(){
		return "2";
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
