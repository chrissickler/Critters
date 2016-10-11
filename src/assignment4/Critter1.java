package assignment4;
/**
 * This critter takes after a cat. It likes to sleep. 
 * When sleeping, it does not lose energy
 * When it is awake, it moves normally
 * @author Chris 
 * */
public class Critter1 extends Critter{
	
	private int dir;
	
	public Critter1(){}

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
		if(percent < 25){
			return;
		}
		else{
			walk(dir);
		}
		
	}

	@Override
	public boolean fight(String oponent) {
		// TODO Auto-generated method stub
		return false;
	}

}
