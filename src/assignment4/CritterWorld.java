package assignment4;

import java.util.ArrayList;
import java.util.Random;

public class CritterWorld {
	
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
	public static void addCritter1(int startEnergy){
		
		int numX = Critter.getRandomInt(width);
		int numY = Critter.getRandomInt(height);
		while(isOccupied[numX][numY] == true){
			numX = Critter.getRandomInt(width);
			numY = Critter.getRandomInt(height);
		}
		Critter1 c = new Critter1(numX, numY, startEnergy);
		critterList1.add(c);
	}
	public static void addCritter2(int startEnergy){
		
		int numX = Critter.getRandomInt(width);
		int numY = Critter.getRandomInt(height);
		while(isOccupied[numX][numY] == true){
			numX = Critter.getRandomInt(width);
			numY = Critter.getRandomInt(height);
		}
		Critter2 c = new Critter2(numX, numY, startEnergy);
		critterList2.add(c);
	}
	public static void addCritter3(int startEnergy){
		
		int numX = Critter.getRandomInt(width);
		int numY = Critter.getRandomInt(height);
		while(isOccupied[numX][numY] == true){
			numX = Critter.getRandomInt(width);
			numY = Critter.getRandomInt(height);
		}
		Critter3 c = new Critter3(numX, numY, startEnergy);
		critterList3.add(c);
	}
	public static void addCritter4(int startEnergy){
		
		int numX = Critter.getRandomInt(width);
		int numY = Critter.getRandomInt(height);
		while(isOccupied[numX][numY] == true){
			numX = Critter.getRandomInt(width);
			numY = Critter.getRandomInt(height);
		}
		Critter4 c = new Critter4(numX, numY, startEnergy);
		critterList4.add(c);
	}
	
}
