/* 
* EE422C Project 4 submission by
 * Karl Solomon
 * Kws653
 * 16445
 * Christopher Sickler
 * cbs2468
 * 16445
 * Slip days used: 0
 * Fall 2016
 */
package assignment4;

import assignment4.Critter.TestCritter;

/**
 * This critter takes after a cat.  
 * It spends its days as follows:
 * 18 hours a day sleeping
 * 5 hours looking for food (a.k.a. walking)
 * 1 hour playing (a.k.a. running)
 * The initial cats genes are random.
 * Any kittens will have the same genes as parent
 * Genes decide what direction the cat will move when it wakes up
 * When 2 cats fight, both cats become pregnant 
 * So, when the cat reaches the minimum energy, the kittens will be born
 * @author Chris 
 * */
public class Critter1 extends TestCritter{
	
	private int dir; //direction the critter goes
	private int[] genes = new int[8]; //genes of the critter
	private boolean isPregnant;//if it has fought another critter1 and had any babies
	private boolean isAwake;//if the critter is awake or not
	private static final int playing = 1;// 1/24 chance that the critter is playing
	private static final int lookingForFood = 5;// 5/24 chance that the critter is searching for food
	private static final int sleeping = 18;// 18/24 chance that the critter is sleeping
	
	private static final int awake = playing + lookingForFood;
	/**
	 * Constructor
	 */
	public Critter1(){
		for(int i = 0; i < 8; i++){
			genes[i] = Critter.getRandomInt(8);
		}
		isPregnant = false;
		isAwake = true;
		dir = Critter.getRandomInt(8);
	}
	
	public int getDir() {
		return dir;
	}

	public void setDir(int dir) {
		this.dir = dir;
	}
	/**
	 * @return 1, this is how critter is displayed on screen
	 */
	public String toString(){
		return "1";
	}
	
	/**
	 *First we must see if the cat is asleep
	 *If it is, then we must determine if it wakes up.
	 * - If it doesn't wake up, then it does nothing this turn
	 * - If it does, then it chooses a new direction
	 *If it is awake,
	 * - It will either look for food
	 * 		- walking in random directions
	 * - or play
	 * 		- running in the set direction
	 *Now we must check to see if the cat is pregnant
	 * - If it isn't, nothing happens
	 * - If it is,
	 * 		- Checks to see if enough energy to have kittens
	 * 		- if enough, kittens are had
	 * 		- if not, then stays pregnant until it can reproduce safely
	 */
	@Override
	public void doTimeStep() {
		if(!isAwake){//Is the cat asleep?
			isAwake = willWakeUp();//Will it wake up?
			if(isAwake){//Wakes up and gets new direction from genes
				dir = getDirection();
			}
		}
		if(isAwake){//Cat either is awake or just woke up
			int num = Critter.getRandomInt(awake);
			if(num < lookingForFood){
				//cat will look for food in random directions
				walk(dir);
				dir = Critter.getRandomInt(8);
			}else{
				//cat will play in a set direction
				run(dir);
			}
		}
		if(isPregnant){
			if(getEnergy() > (8*Params.min_reproduce_energy)){
				int numKittens = Critter.getRandomInt(3);
				for(int i = 0; i < numKittens; i++){					
					Critter1 kitten = new Critter1();
					kitten.genes = this.genes;
					reproduce(kitten, Critter.getRandomInt(8));
				}
				isPregnant = false;
			}
		}
	}
	
	private boolean willWakeUp(){
		int num = Critter.getRandomInt(24);
		if(num > sleeping){
			return true;
		}
		else return false;
	}
	
	private int getDirection(){
		return genes[Critter.getRandomInt(8)];
	}
	/**
	 * If the cat is woken up, it will fight
	 * else
	 * if the cat is pregnant, itll try to avoid fighting
	 * but if not pregnant, it will just fight
	 * @param opponent is the toString of the opponent, so if there are special interactions, you can code them
	 * @return if the critter will fight
	 */
	@Override
	public boolean fight(String opponent) {
		if(opponent.equals("1")){
			isPregnant = true;
			return CritterWorld.tryMove(this,dir, 1);
		}
		else if(opponent.equals("@")){
			return true;
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
