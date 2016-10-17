package assignment4;

import assignment4.Critter.TestCritter;

/**
 * This Critter takes after a normal human
 * Day:
 * 8 hours sleeping
 * 16 hours awake
 * 	3 hours active(running)
 * 	3 hours searching for food(walking in random directions)
 * 	10 hours otherwise(walking in ordered fashion)
 * @author Chris
 * */
public class Critter2 extends TestCritter{
	
	private static final int sleeping = 8;
	private static final int active = 3 + sleeping;
	private static final int searchingForFood = 3 + active;
	private static final int otherwise = 10 + searchingForFood;
	
	private int dir;
	private int[] genes = new int[8];
	private boolean isAwake;
	
		
	public Critter2(){
		for(int i = 0; i < 8; i++){
			genes[i] = Critter.getRandomInt(8);
		}
		isAwake = true;
		dir = Critter.getRandomInt(8);
	}

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
		int num = Critter.getRandomInt(24);
		if(num < sleeping){
			isAwake = false;
		}
		else if(num < active){
			isAwake = true;
			run(dir);
		}
		else if(num < searchingForFood){
			isAwake = true;
			walk(dir);
			dir = Critter.getRandomInt(8);
		}
		else{
			isAwake = true;
			walk(dir);
		}
		if(getEnergy() > (8*Params.min_reproduce_energy)){
			int numChildren = Critter.getRandomInt(2);
			for(int i = 0; i < numChildren; i++){
				Critter2 child = new Critter2();
				child.genes = this.genes;
				reproduce(child,dir);
			}
		}
	}

	@Override
	public boolean fight(String opponent) {
		if(opponent.equals("@")){
			return true;
		}
		else if(opponent.equals("1")){
			return CritterWorld.tryMove(this, dir, 1);
		}
		else if(opponent.equals("3")){
			return CritterWorld.tryMove(this, dir, 2);
		}else return true;
	}
}
