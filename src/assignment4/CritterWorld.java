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
	}
	public static void addCraig(Craig cr){
		craigList.add(cr);
	}
	public static void addAlgae(Algae a){
		algaeList.add(a);		
	}
	public static boolean checkOccupied(int x, int y){
		if(isOccupied[x][y] == true){
			return true;
		}else{
			return false;
		}
	}
	public static void removeDead(){
		for(Critter1 i : CritterWorld.critterList1){
			if(i.getEnergy() == 0){
				CritterWorld.critterList1.remove(i);
			}
		}
		for(Critter2 i : CritterWorld.critterList2){
			if(i.getEnergy() == 0){
				CritterWorld.critterList2.remove(i);
			}
		}
		for(Critter3 i : CritterWorld.critterList3){
			if(i.getEnergy() == 0){
				CritterWorld.critterList3.remove(i);
			}
		}
		for(Critter4 i : CritterWorld.critterList4){
			if(i.getEnergy() == 0){
				CritterWorld.critterList4.remove(i);
			}
		}
		for(Craig i : CritterWorld.craigList){
			if(i.getEnergy() == 0){
				CritterWorld.craigList.remove(i);
			}
		}
		for(Algae i : CritterWorld.algaeList){
			if(i.getEnergy() == 0){
				CritterWorld.algaeList.remove(i);
			}
		}
	}
	public static void doTimeSteps(){
		for(Critter1 i : CritterWorld.critterList1){
			i.doTimeStep();
		}
		for(Critter2 i : CritterWorld.critterList2){
			i.doTimeStep();
		}
		for(Critter3 i : CritterWorld.critterList3){
			i.doTimeStep();
		}
		for(Critter4 i : CritterWorld.critterList4){
			i.doTimeStep();
		}
		for(Craig i : CritterWorld.craigList){
			i.doTimeStep();
		}
		for(Algae i : CritterWorld.algaeList){
			i.doTimeStep();
		}
	}
	public static Point getNextAvailableLocation(){
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
	
}
