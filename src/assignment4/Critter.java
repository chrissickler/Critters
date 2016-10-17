/* CRITTERS Critter.java
 * EE422C Project 4 submission by
 * Replace <...> with your actual data.
 * <Student1 Name>
 * <Student1 EID>
 * <Student1 5-digit Unique No.>
 * <Student2 Name>
 * <Student2 EID>
 * <Student2 5-digit Unique No.>
 * Slip days used: <0>
 * Fall 2016
 */
package assignment4;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/* see the PDF for descriptions of the methods and fields in this class
 * you may add fields, methods or inner classes to Critter ONLY if you make your additions private
 * no new public, protected or default-package code or data can be added to Critter
 */


public abstract class Critter {
	private static String myPackage = "assignment4.";
	private Point location = new Point();
	private boolean hasMoved = false;
	// Gets the package name.  This assumes that Critter and its subclasses are all in the same package.
	static {
		myPackage = Critter.class.getPackage().toString().split(" ")[1];
	}
	
	private static java.util.Random rand = new java.util.Random();
	public static int getRandomInt(int max) {
		if(max <= 0) return 0;
		return rand.nextInt(max);
	}
	
	public static void setSeed(long new_seed) {
		rand = new java.util.Random(new_seed);
	}
	
	
	/* a one-character long string that visually depicts your critter in the ASCII interface */
	public String toString() {
		return "";
	}

	private int energy = 0;
	protected int getEnergy() {
		return this.energy;
	}
	
	//private int x_coord;
	//private int y_coord;
	protected final void walk(int direction) {
		energy -= Params.walk_energy_cost;
		if (!hasMoved && energy > 0) {
			direction = direction % 8;
			location.update(direction);
			hasMoved = true;
		}
	}
	
	protected final void run(int direction) {
		energy -= Params.run_energy_cost;
		if (!hasMoved && energy > 0) {
			direction = direction % 8;
			location.update(direction);
			location.update(direction);
			hasMoved = true;
		}
	}
	
	protected final void reproduce(Critter offspring, int direction) {
		if(this.energy >= Params.min_reproduce_energy) {
			offspring.energy = this.energy/2;
			this.energy += this.energy %2;
			this.energy /= 2;
			offspring.location.update(direction);
			CritterWorld.babies.put((TestCritter) offspring, offspring.location);
		}
	}
	

	public abstract void doTimeStep();
	public abstract boolean fight(String oponent);	//can't have >1 critter on a given location
	
	/**
	 * create and initialize a Critter subclass.
	 * critter_class_name must be the unqualified name of a concrete subclass of Critter, if not,
	 * an InvalidCritterException must be thrown.
	 * (Java weirdness: Exception throwing does not work properly if the parameter has lower-case instead of
	 * upper. For example, if craig is supplied instead of Craig, an error is thrown instead of
	 * an Exception.)
	 * @param critter_class_name
	 * @throws InvalidCritterException
	 */	
	public static void makeCritter(String critter_class_name) throws InvalidCritterException{
		//TODO need to go over this
		Critter critter = null;
		try{
			Class<?> c = Class.forName(critter_class_name);
			Constructor<?> newCon = c.getConstructor();
			Object obj = newCon.newInstance();
			critter = (Critter)obj;
			
		}catch(ClassNotFoundException|NoSuchMethodException|SecurityException|InstantiationException|IllegalAccessException|IllegalArgumentException|InvocationTargetException e){
			throw new InvalidCritterException(critter_class_name);
		}
		addCritter(critter);
	}
	
	public static void addCritter(Critter critter) {
		if(critter != null) {
			critter.location = CritterWorld.getRandomLocation();
			CritterWorld.addCritter(critter, critter.location);
			critter.energy = Params.start_energy;
		}
	}
	
	/**
	 * Gets a list of critters of a specific type.
	 * @param critter_class_name What kind of Critter is to be listed.  Unqualified class name.
	 * @return List of Critters.
	 * @throws InvalidCritterException
	 */
	public static List<Critter> getInstances(String critter_class_name) throws InvalidCritterException {
		List<Critter> result = new java.util.ArrayList<Critter>();
		Critter critter;
		try{
			Class<?> c = Class.forName(critter_class_name);
			Constructor<?> newCon = c.getConstructor();
			Object obj = newCon.newInstance();
			critter = (Critter)obj;
			String s = critter.toString();
			
			for(Critter i : CritterWorld.critterMap.keySet()) {
				if(i.toString() == s) { 	
					result.add(i);
				}
			}
		}catch(ClassNotFoundException|NoSuchMethodException|SecurityException|InstantiationException|IllegalAccessException|IllegalArgumentException|InvocationTargetException e){
			throw new InvalidCritterException(critter_class_name);
		}
		
		return result;
	}
	
	
	
	/**
	 * Prints out how many Critters of each type there are on the board.
	 * @param critters List of Critters.
	 */
	public static void runStats(List<Critter> critters) {
		System.out.print("" + critters.size() + " critters as follows -- ");
		java.util.Map<String, Integer> critter_count = new java.util.HashMap<String, Integer>();
		for (Critter crit : critters) {
			String crit_string = crit.toString();
			Integer old_count = critter_count.get(crit_string);
			if (old_count == null) {
				critter_count.put(crit_string,  1);
			} else {
				critter_count.put(crit_string, old_count.intValue() + 1);
			}
		}
		String prefix = "";
		for (String s : critter_count.keySet()) {
			System.out.print(prefix + s + ":" + critter_count.get(s));
			prefix = ", ";
		}
		System.out.println();		
	}
	
	/* the TestCritter class allows some critters to "cheat". If you want to 
	 * create tests of your Critter model, you can create subclasses of this class
	 * and then use the setter functions contained here. 
	 * 
	 * NOTE: you must make sure that the setter functions work with your implementation
	 * of Critter. That means, if you're recording the positions of your critters
	 * using some sort of external grid or some other data structure in addition
	 * to the x_coord and y_coord functions, then you MUST update these setter functions
	 * so that they correctly update your grid/data structure.
	 */
	static abstract class TestCritter extends Critter {
		protected void setEnergy(int new_energy_value) {
			super.energy = new_energy_value;
		}
		
		protected void setX_coord(int new_x_coord) {
			super.location.setX(new_x_coord);
		}
		
		protected void setY_coord(int new_y_coord) {
			super.location.setY(new_y_coord);
		}
		
		protected int getX_coord() {
			return super.location.getX();
		}
		
		protected int getY_coord() {
			return super.location.getY();
		}
		

		/*
		 * This method getPopulation has to be modified by you if you are not using the population
		 * ArrayList that has been provided in the starter code.  In any case, it has to be
		 * implemented for grading tests to work.
		 */
		@SuppressWarnings("unchecked")
		protected static List<Critter> getPopulation() {
			return (List<Critter>) (Critter) CritterWorld.critterMap.keySet();
		}
		
		/*
		 * This method getBabies has to be modified by you if you are not using the babies
		 * ArrayList that has been provided in the starter code.  In any case, it has to be
		 * implemented for grading tests to work.  Babies should be added to the general population 
		 * at either the beginning OR the end of every timestep.
		 */
		protected static List<Critter> getBabies() {
			return (List<Critter>) (Critter) CritterWorld.babies.keySet();
		}
	}

	/**
	 * Clear the world of all critters, dead and alive
	 */
	public static void clearWorld() {
		CritterWorld.clearWorld();
	}
	
	public static void worldTimeStep() {
		CritterWorld.doTimeStep();
		handleInteractions();
		CritterWorld.makeAlgae();
		CritterWorld.addBabies();
		CritterWorld.removeDead();
	}
	
	public static void displayWorld() {
		CritterWorld.printWorld();
	}
	
	private static void handleInteractions(){
		boolean aFight;
		boolean bFight;
		int aRoll = 0;
		int bRoll = 0;
		for(Critter a : CritterWorld.critterMap.keySet()) {
			for(Critter b : CritterWorld.critterMap.keySet()) {
				if(!a.equals(b)) {
					if(a.location.equals(b.location)) {
						aFight = a.fight(b.toString());
						bFight = b.fight(a.toString());
						if(aFight){
							aRoll = Critter.getRandomInt(a.getEnergy());
						}else{
							aRoll = 0;
						}
						if(bFight){
							bRoll = Critter.getRandomInt(b.getEnergy());
						}else{
							bRoll = 0;
						}
						if (a.location.equals(b.location)) {	// neither moved
							if (aRoll > bRoll) {
								a.energy += b.energy / 2;
								b.energy = 0;
								b.location = new Point(-1, -1);
							} else {
								b.energy += a.energy / 2;
								a.energy = 0;
								a.location = new Point(-1, -1);
							} 
						}
					}
				}
			}
		}
	}
	
}
