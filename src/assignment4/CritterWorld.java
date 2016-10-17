package assignment4;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CritterWorld {
	public static Map<Critter, Point> critterMap = new HashMap<Critter, Point>();	//official record of Critters and their location
	public static Map<Critter, Point> babies = new HashMap<>();
	private static int width = Params.world_width;
	private static int height = Params.world_height;
	private static String[][] world = new String[width][height];	// for display purposes only

	public static void addCritter(Critter c, Point p) {
		babies.put(c, p);
	}
	
	/**
	 * Checks all existing Critter locations for the current point
	 * @param p
	 * @return true if another critter has that same location
	 */
	public static boolean isOccupied(Critter me, Point p){
		for(Critter i : critterMap.keySet()){
			if(critterMap.get(i).equals(p)) {
				if(i.equals(me)) continue;
				else return true;
			}
		}
		return false;
	}
	
	public static void makeAlgae() {
		for(int i = 0; i < Params.refresh_algae_count; i++) {
			babies.put(new Algae(), new Point(Critter.getRandomInt(Params.world_width), Critter.getRandomInt(Params.world_height)));
		}
	}
	
	public static boolean tryMove(Critter c, int direction, int distance) {
		Point p1 = critterMap.get(c);
		if(distance == 1) {
			c.walk(direction);
		}
		else if(distance == 2) {
			c.run(direction);
		}
		Point p2 = critterMap.get(c);
		if(p1.equals(p2))return true;
		return false;
	}
	
	/**
	 * Removes all dead critters from the critterMap
	 */
	public static void removeDead(){
		for(Critter i : critterMap.keySet()){
			if(i.getEnergy() <= 0){
				critterMap.remove(i);
			}
		}
	}
	
	public static void doTimeStep(){
		for(Critter i : critterMap.keySet()){
			i.doTimeStep();
		}
		addBabies();
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
	
	public static void addBabies() {
		critterMap.putAll(babies);
		babies = new HashMap<>();
	}
	
	public static void clearWorld(){
		world = new String[width][height];
		critterMap = new HashMap<Critter, Point>();
	}
	
	public static void printWorld() {
		cleanWorld();
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
		sb.append("+\n");
		return sb.toString();
	}
	
	/**
	 * Guarantees that the String[][] world only displays live critters and accurate positions
	 */
	public static void cleanWorld() {
		int x;
		int y;
		world = new String[width][height];		
		for(Critter i : critterMap.keySet()){
			x = critterMap.get(i).getX();
			y = critterMap.get(i).getY();
			world[x][y] = i.toString();
		}
	}
	
}
