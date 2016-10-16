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
	
	private static final int truth = 3;
	private static final int mostlyTruth = 11 + truth;
	private static final int halfTruth = 14 + mostlyTruth;
	private static final int mostlyFalse = 18 + halfTruth;
	private static final int pantsOnFire = 52 + mostlyFalse;
	private static final int[] truthTable = {truth, mostlyTruth, halfTruth, mostlyFalse, pantsOnFire};

	private static final int active = 4;	// active on average 4 hours per week to maintain BMI = 30;
	private static final int awake = 168-49;	//sleep 7 hours per day
	
	private static final int GENE_TOTAL = 24000;
	private int[] genes = new int[GENE_TOTAL];
	
	private int dir;
	
	public Critter3() {
		for (int k = 0; k < 8; k += 1) {
			genes[k] = Critter.getRandomInt(8);
		}
		dir = Critter.getRandomInt(8);
	}

	public int getDir() {
		return dir;
	}

	public void setDir(int dir) {
		this.dir = dir;
	}
		
	@Override
	public void doTimeStep() {
		dir = toDirection();
		int activity = Critter.getRandomInt(168);
		if(activity < active) {
			run(dir);
		}
		else if(activity < awake) {
			walk(dir);
		}
		if(getEnergy() > 8*Params.start_energy/(Params.min_reproduce_energy)){
			Critter3 newDonald = new Critter3();
			newDonald.genes = this.genes;	//asexual reproduction
			reproduce(newDonald, activity);
		}
	}

	@Override
	public boolean fight(String opponent) {
		if(opponent.equals("@")){
			return true;
		}
		return true;
	}
	
	/**
	 * Move in a direction that is as close to the expected direction as Trump is to telling the truth.
	 * @return
	 */
	private int toDirection() {
		int statement = Critter.getRandomInt(pantsOnFire+1);
		for(int i = 0; i < truthTable.length; i++) {
			if(statement < truthTable[i]) {
				dir += i;
			}
		}
		return dir %= 8;
	}
	
	public static void runStats(java.util.List<Critter> critter3s) {
		int total_straight = 0;
		int total_left = 0;
		int total_right = 0;
		int total_back = 0;
		for (Critter critter : critter3s) {
			Critter3 c = (Critter3) critter;
			total_straight += c.genes[0];
			total_right += c.genes[1] + c.genes[2] + c.genes[3];
			total_back += c.genes[4];
			total_left += c.genes[5] + c.genes[6] + c.genes[7];
		}
		System.out.print("" + critter3s.size() + " total Craigs    ");
		System.out.print("" + total_straight / (GENE_TOTAL * 0.01 * critter3s.size()) + "% straight   ");
		System.out.print("" + total_back / (GENE_TOTAL * 0.01 * critter3s.size()) + "% back   ");
		System.out.print("" + total_right / (GENE_TOTAL * 0.01 * critter3s.size()) + "% right   ");
		System.out.print("" + total_left / (GENE_TOTAL * 0.01 * critter3s.size()) + "% left   ");
		System.out.println();
	}

}
