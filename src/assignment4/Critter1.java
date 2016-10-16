package assignment4;

import assignment4.Critter.TestCritter;

/**
 * This critter takes after a cat. It likes to sleep. 
 * When sleeping, it does not lose energy
 * When it is awake, it moves normally
 * @author Chris 
 * */
public class Critter1 extends TestCritter{
	
	private int dir;
	private int[] genes = new int[8];
	private boolean isPregnant;
	private boolean isAwake;
	
	public Critter1(){
		for(int i = 0; i < 8; i++){
			genes[i] = Critter.getRandomInt(8);
		}
		isPregnant = false;
		isAwake = true;
	}

	public int getDir() {
		return dir;
	}

	public void setDir(int dir) {
		this.dir = dir;
	}

	public String toString(){
		return "1";
	}
	
	@Override
	public void doTimeStep() {
		int percent = Critter.getRandomInt(100);
		if(percent > 30){
			isAwake = false;
			return;//The cat/critter is asleep because its a cat
		}
		else{
			isAwake = true;
			if(percent < 15){
				walk(dir);			
				dir = genes[Critter.getRandomInt(8)];
				if(getEnergy() > (8*Params.min_reproduce_energy) && isPregnant == true){
					int numKittens = Critter.getRandomInt(3);
					for(int i = 0; i < numKittens; i++){					
						Critter1 kitten = new Critter1();
						for(int k = 0; k < 8; k++){
							kitten.genes[k] = (this.genes[k] * 2) / 2;
						}
						reproduce(kitten, Critter.getRandomInt(8));					
						isPregnant = false;
					}
				}
			}
			else{
				run(dir);
				dir = genes[Critter.getRandomInt(8)];
			}
		}
		
		
	}

	/**
	 * If the cat is woken up, it will fight
	 * else
	 * if the cat is pregnant, itll try to avoid fighting
	 * but if not pregnant, it will just fight
	 */
	@Override
	public boolean fight(String opponent) {
		if(opponent.equals("1")){
			isPregnant = true;
			return CritterWorld.tryMove(this,dir, 1);
		}
		else if(opponent.equals("@")){
			return false;
		}
		else if(!isAwake){
			isAwake = true;
			return true;
		}else{
			if(!isPregnant){
				return true;
			}			
			else{
				return CritterWorld.tryMove(this,dir, 1);
			}
		}		
	}

}
