package assignment4;
/**
 * This Critter is actually a male cat
 * @author Chris
 * */
public class Critter2 extends Critter{
	
	private int dir;
	public int[] genes = new int[8];
	private boolean stepTaken;
	
	public Critter2(){
		for(int i = 0; i < 8; i++){
			genes[i] = Critter.getRandomInt(8);
		}
		stepTaken = false;
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
		int percent = Critter.getRandomInt(100);
		if(percent < 25){
			return;//The cat/critter is asleep because its a cat
		}
		else if(percent < 5){
			run(dir);
		}
		else{
			walk(dir);
			if(stepTaken == false){
				stepTaken = true;
			}
			else{
				dir = (dir + 2) % 8;
				stepTaken = false;
			}
			
		}
		
	}

	@Override
	public boolean fight(String opponent) {
		// TODO Auto-generated method stub
		return false;
	}

}
