package assignment4;

import java.util.ArrayList;
import java.util.Random;

public class CritterWorld {
<<<<<<< HEAD
	public static ArrayList<Critter> critterList = new ArrayList<Critter>();
	private static int width = Params.world_width;
	private static int height = Params.world_height;
	private static boolean[][] isOccupied = new boolean[width][height];

	public static void addCritter(Critter c) {
		Pair p = CritterWorld.getNextAvailableLocation();
		c.setX(p.getX());
		c.setY(p.getY());
		c.setDir(Critter.getRandomInt(8));
		c.setEnergy(Params.start_energy);
		critterList.add(c);
=======
	
	public static ArrayList<Critter1> critterList1;
	public static ArrayList<Critter2> critterList2;
	public static ArrayList<Critter3> critterList3;
	public static ArrayList<Critter4> critterList4;
	public static ArrayList<Craig> craigList;
	public static ArrayList<Algae> algaeList;
	private static boolean[][] isOccupied;
	private static int width;
	private static int height;
	
	
	public CritterWorld(){
		critterList1 = new ArrayList<Critter1>();
		critterList2 = new ArrayList<Critter2>();
		critterList3 = new ArrayList<Critter3>();
		critterList4 = new ArrayList<Critter4>();
		craigList = new ArrayList<Craig>();
		algaeList = new ArrayList<Algae>();
		width = Params.world_width;
		height = Params.world_height;
		isOccupied = new boolean[width][height];
	}
	public static void addCritter1(Critter1 c1){
		Point p = CritterWorld.getNextAvailableLocation();
		c1.setX(p.getX());
		c1.setY(p.getY());
		c1.setDir(Critter.getRandomInt(8));
		c1.setEnergy(Params.start_energy);
		critterList1.add(c1);
	}
	public static void addCritter2(Critter2 c2){
		Point p = CritterWorld.getNextAvailableLocation();
		c2.setX(p.getX());
		c2.setY(p.getY());
		c2.setDir(Critter.getRandomInt(8));
		c2.setEnergy(Params.start_energy);
		critterList2.add(c2);
	}
	public static void addCritter3(Critter3 c3){
		Point p = CritterWorld.getNextAvailableLocation();
		c3.setX(p.getX());
		c3.setY(p.getY());
		c3.setDir(Critter.getRandomInt(8));
		c3.setEnergy(Params.start_energy);
		critterList3.add(c3);
	}
	public static void addCritter4(Critter4 c4){
		Point p = CritterWorld.getNextAvailableLocation();
		c4.setX(p.getX());
		c4.setY(p.getY());
		c4.setDir(Critter.getRandomInt(8));
		c4.setEnergy(Params.start_energy);
		critterList4.add(c4);
>>>>>>> origin/master
	}
	
	public static void addCraig(Craig cr){
		critterList.add(cr);
	}
	public static void addAlgae(Algae a){
		critterList.add(a);		
	}
	public static boolean checkOccupied(int x, int y){
		if(isOccupied[x][y] == true){
			return true;
		}else{
			return false;
		}
	}
	public static void removeDead(){
		for(Critter i : CritterWorld.critterList){
			if(i.getEnergy() == 0){
				CritterWorld.critterList.remove(i);
			}
		}
	}
	public static void doTimeStep(){
		for(Critter i : CritterWorld.critterList){
			i.doTimeStep();
		}
	}
	
	public static void doTimeSteps(int numSteps){
		for(int i = 0; i < numSteps; i++) {
	 		doTimeStep();
		}
	}
<<<<<<< HEAD
	
	public static Pair getNextAvailableLocation(){
=======
	public static Point getNextAvailableLocation(){
>>>>>>> origin/master
		int numX = Critter.getRandomInt(width);
		int numY = Critter.getRandomInt(height);
		while(isOccupied[numX][numY] == true){
			numX = Critter.getRandomInt(width);
			numY = Critter.getRandomInt(height);
		}
		Point p = new Point();
		p.setX(numX);
		p.setY(numY);
		return p;
	}
	
<<<<<<< HEAD
	public static void clearWorld(){
		isOccupied = new boolean[width][height];
		critterList = new ArrayList<Critter>();
	}
	
	public static void printWorld() {
		String top = topBottomRow();
		System.out.println(top);
		
		System.out.println(top);
	}
	private static String topBottomRow() {
		StringBuilder sb = new StringBuilder();
		sb.append("+");
		for(int i = 0; i < width; i++) {
			sb.append("-");
		}
		return sb.toString();
	}
	
	
	
	
	
	static class Pair{
		int x;
		int y;
		public int getX() {
			return x;
		}
		public void setX(int x) {
			this.x = x;
		}
		public int getY() {
			return y;
		}
		public void setY(int y) {
			this.y = y;
		}
	}
=======
>>>>>>> origin/master
}
