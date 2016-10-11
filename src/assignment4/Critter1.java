package assignment4;
/**
 * This critter takes after a cat. It likes to sleep. 
 * When sleeping, it does not lose energy
 * When it is awake, it moves normally
 * Female Cat
 * @author Chris 
 * */
public class Critter1 extends Critter{
	
	private int dir;
	private int[] genes = new int[8];
	private int[] dadGenes = new int[8];
	private boolean isPregnant;
	
	public Critter1(){
		for(int i = 0; i < 8; i++){
			genes[i] = Critter.getRandomInt(8);
		}
		isPregnant = false;
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
		if(percent < 30){
			return;//The cat/critter is asleep because its a cat
		}
		else if(percent < 15){
			walk(dir);			
			dir = genes[Critter.getRandomInt(8)];
			if(getEnergy() > (8*Params.min_reproduce_energy) && isPregnant == true){
				int numKittens = Critter.getRandomInt(3);
				for(int i = 0; i < numKittens; i++){
					int malePerc = Critter.getRandomInt(2);
					if(malePerc == 0){
						Critter1 kitten = new Critter1();
						for(int k = 0; k < 8; k++){
							kitten.genes[k] = (this.genes[k] + this.dadGenes[k]) / 2;
						}
						reproduce(kitten, Critter.getRandomInt(8));
					}
					else{
						Critter2 kitten = new Critter2();
						for(int k = 0; k < 8; k++){
							kitten.genes[k] = (this.genes[k] + this.dadGenes[k]) / 2;
						}
						reproduce(kitten, Critter.getRandomInt(8));
					}
					Critter1 kitten = new Critter1();
					for(int k = 0; k < 8; k++){
						kitten.genes[k] = (this.genes[k] + this.dadGenes[k]) / 2;
					}
					reproduce(kitten, Critter.getRandomInt(8));
				}
			}
		}
		else{
			run(dir);
			dir = genes[Critter.getRandomInt(8)];
		}
		
	}

	@Override
	public boolean fight(String opponent) {
		// TODO Auto-generated method stub
		return false;
	}

}
