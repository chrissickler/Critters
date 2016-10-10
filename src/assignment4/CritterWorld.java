package assignment4;

import java.util.ArrayList;
import java.util.Random;

public class CritterWorld {
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
	
	public static Pair getNextAvailableLocation(){
		int numX = Critter.getRandomInt(width);
		int numY = Critter.getRandomInt(height);
		while(isOccupied[numX][numY] == true){
			numX = Critter.getRandomInt(width);
			numY = Critter.getRandomInt(height);
		}
		Pair p = new Pair();
		p.setX(numX);
		p.setY(numY);
		return p;
	}
	
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
}
