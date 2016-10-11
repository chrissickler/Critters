package assignment4;

/**
 * This Critter's name is Donald. He doesn't like being labeled as a number. He thinks its unfair.
 * This is unfair treatment. He has more money than any other critter who has ever been simulated.
 * We are never really know what he is going to do or where he is going to go
 * @author KSolomon
 *
 */

public class Critter3 extends Critter{
	
	@Override
	public String toString(){ return "3";}
	
	private static final double oddsOfActingAccoringToGenetics = 0.17;
	private static final int GENE_TOTAL = 24;
	private int[] genes = new int[8];
	private int dir;
	
	public Critter3(){}

	public int getDir() {
		return dir;
	}

	public void setDir(int dir) {
		this.dir = dir;
	}

		
	@Override
	public void doTimeStep() {
		dir = Critter.getRandomInt(8);
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean fight(String oponent) {
		// TODO Auto-generated method stub
		return false;
	}

}
