package assignment4;

import java.util.ArrayList;

public class CritterWorld {
	public static ArrayList<Critter> critterList = new ArrayList<Critter>();
	private static int width = Params.world_width;
	private static int height = Params.world_height;
	private static String[][] world = new String[width][height];

	public static void addCritter(Critter c) {
		critterList.add(c);
	}
	
	public static boolean checkOccupied(int x, int y){
		if(world[x][y] == null){
			return true;
		}else {
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
	
	public static Point getNextAvailableLocation(){
		int numX = Critter.getRandomInt(width);
		int numY = Critter.getRandomInt(height);
		while(world[numX][numY] != null){
			numX = Critter.getRandomInt(width);
			numY = Critter.getRandomInt(height);
		}
		Point p = new Point();
		p.setX(numX);
		p.setY(numY);
		return p;
	}
	
	public static void clearWorld(){
		world = new String[width][height];
		critterList = new ArrayList<Critter>();
	}
	
	public static void printWorld() {
		String top = topBottomRow();		
		StringBuilder sb = new StringBuilder();
		sb.append(top);
		for(int i = 0; i < height; i++) {
			sb.append("|");
			for(int j = 0; j < width; j++) {
				if(world[j][i] == null) {
					sb.append(" ");
				}
				else {
					sb.append(world[j][i]);
				}
			}
			sb.append("|\n");
		}
		//TODO: iterate through the world and print each row
		sb.append(top);
		System.out.println(sb.toString());
	}
	private static String topBottomRow() {
		StringBuilder sb = new StringBuilder();
		sb.append("+");
		for(int i = 0; i < width; i++) {
			sb.append("-");
		}
		sb.append("+");
		return sb.toString();
	}
}
