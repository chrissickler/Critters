package assignment4;

public class CritterD extends Critter{

	private String name;
	private int xD;
	private int yD;
	
	public CritterD(int x, int y){
		xD = x;
		yD = y;
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
