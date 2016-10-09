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
	public static void addCritter1(Critter1 c1){
		int numX = Critter.getRandomInt(width);
		int numY = Critter.getRandomInt(height);
		while(isOccupied[numX][numY] == true){
			numX = Critter.getRandomInt(width);
			numY = Critter.getRandomInt(height);
		}
		c1.setX(numX);
		c1.setY(numY);
		c1.setDir(Critter.getRandomInt(8));
		c1.setEnergy(Params.start_energy);
	}
	public static void addCritter2(Critter2 c2){
		int numX = Critter.getRandomInt(width);
		int numY = Critter.getRandomInt(height);
		while(isOccupied[numX][numY] == true){
			numX = Critter.getRandomInt(width);
			numY = Critter.getRandomInt(height);
		}
		c2.setX(numX);
		c2.setY(numY);
		c2.setDir(Critter.getRandomInt(8));
		c2.setEnergy(Params.start_energy);
	}
	public static void addCritter3(Critter3 c3){
		int numX = Critter.getRandomInt(width);
		int numY = Critter.getRandomInt(height);
		while(isOccupied[numX][numY] == true){
			numX = Critter.getRandomInt(width);
			numY = Critter.getRandomInt(height);
		}
		c3.setX(numX);
		c3.setY(numY);
		c3.setDir(Critter.getRandomInt(8));
		c3.setEnergy(Params.start_energy);
	}
	public static void addCritter4(Critter4 c4){
		int numX = Critter.getRandomInt(width);
		int numY = Critter.getRandomInt(height);
		while(isOccupied[numX][numY] == true){
			numX = Critter.getRandomInt(width);
			numY = Critter.getRandomInt(height);
		}
		c4.setX(numX);
		c4.setY(numY);
		c4.setDir(Critter.getRandomInt(8));
		c4.setEnergy(Params.start_energy);
	}
	public static void addCraig(Craig cr){
		int numX = Critter.getRandomInt(width);
		int numY = Critter.getRandomInt(height);
		while(isOccupied[numX][numY] == true){
			numX = Critter.getRandomInt(width);
			numY = Critter.getRandomInt(height);
		}
		
	}
	public static void addAlgae(Algae a){
		int numX = Critter.getRandomInt(width);
		int numY = Critter.getRandomInt(height);
		while(isOccupied[numX][numY] == true){
			numX = Critter.getRandomInt(width);
			numY = Critter.getRandomInt(height);
		}
		
	}
}
