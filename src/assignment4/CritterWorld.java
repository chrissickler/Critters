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

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import assignment4.Critter.TestCritter;

public class CritterWorld {
	public static Map<Critter, Point> critterMap = new HashMap<Critter, Point>();	//official record of Critters and their location
	public static Map<Critter, Point> babies = new HashMap<>();
	private static int width = Params.world_width;
	private static int height = Params.world_height;
	private static String[][] world = new String[width][height];	// for display purposes only

	public static void addCritter(Critter c, Point p) {
		critterMap.put((TestCritter) c, p);
	}
	
	/**
	 * Checks all existing Critter locations for the current point
	 * @param p
	 * @return true if another critter has that same location
	 */
	public static boolean isOccupied(Point p){
		for(Critter i : critterMap.keySet()){
			if(critterMap.get(i).equals(p)) {
				if(i.getEnergy() > 0) { 	// ignore dead critters
					continue;
				}
				else return true;
			}
		}
		return false;
	}
	
	public static void makeAlgae() {
		for(int i = 0; i < Params.refresh_algae_count; i++) {
			try {
				Critter.makeCritter("Algae");
			} catch (InvalidCritterException e) {
				Main.printError("Algae");
			}
		}
	}
	
	public static boolean tryMove(Critter c, int direction, int distance) {
		Point p1 = critterMap.get(c); 
		for(int i = 0; i < distance; i++) {
			p1.update(direction);			// p1 is desired location
		}		
		
		if(isOccupied(p1)) {
			return false;
		}
		else {
			if(distance == 1) {
				c.walk(direction);
			}
			else if(distance == 2) {
				c.run(direction);
			}
			Point p2 = critterMap.get(c); 	// updated if run/walk are successful (hasn't already been done this timestep
			if(p1.equals(p2)) {
				return true;
			}
			else {
				return false;
			}
		}
	}
	
	/**
	 * Removes all dead critters from the critterMap
	 */
	public static void removeDead(){
		for(Iterator<Critter> iterator = critterMap.keySet().iterator(); iterator.hasNext();){
			Critter c = iterator.next();
			if(c.getEnergy() < 1) {
				iterator.remove();
			}
		}		
		
//		critterMap.keySet().removeIf(filter)
//		for(Critter i : critterMap.keySet().remo){
//			critterMap
//			if(i.getEnergy() <= 0){
//				critterMap.remove(i).;
//			}
//		}
//		
//		for(int i = 0; i < critterMap.keySet().)
	}
	
	public static void doTimeStep(){
		for(Critter i : critterMap.keySet()){
			i.doTimeStep();
		}
	}
	
	/**
	 * Calculate the next available location 
	 * FIXME: May not be legal to use
	 * @return next unoccupied location
	 */
	public static Point getNextAvailableLocation(){
		int numX = Critter.getRandomInt(width);
		int numY = Critter.getRandomInt(height);
		while(world[numX][numY] != null){
			numX = Critter.getRandomInt(width);
			numY = Critter.getRandomInt(height);
		}
		return new Point(numX, numY);
	}
	
	/**
	 * Get random location on map to put newly generated Critter via Make Critter
	 * @return random point location on the world map
	 */
	public static Point getRandomLocation() {
		int x = Critter.getRandomInt(width);
		int y = Critter.getRandomInt(height);
		return new Point(x,y);
	}
	
	/**
	 * At the end of the world time step add babies to the world map
	 */
	public static void addBabies() {
		critterMap.putAll(babies);
		babies = new HashMap<>();
	}
	
	/**
	 * Deletes all world data
	 */
	public static void clearWorld(){
		world = new String[width][height];
		critterMap = new HashMap<Critter, Point>();
	}
	
	/**
	 * Prints world to System.out
	 */
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
		sb.append(top);
		System.out.println(sb.toString());
	}
	
	/**
	 * Returns the top/bottom borders of the world
	 * @return Top and bottom row borders
	 */
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
