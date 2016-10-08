package assignment4;

import java.util.ArrayList;
import java.util.Random;

public class CritterWorld {
	
	private ArrayList<Critter1> critterList1;
	private ArrayList<Critter2> critterList2;
	private ArrayList<Critter3> critterList3;
	private ArrayList<Critter4> critterList4;
	private int width;
	private int height;
	
	public CritterWorld(){
		critterList1 = new ArrayList<Critter1>();
		critterList2 = new ArrayList<Critter2>();
		critterList3 = new ArrayList<Critter3>();
		critterList4 = new ArrayList<Critter4>();
		width = Params.world_width;
		height = Params.world_height;
	}
	public void addCritter1(){
		Random r = new Random();
		int numX = r.nextInt((width)) + 1;
		int numY = r.nextInt((height)) + 1;
		Critter1 c = new Critter1(numX, numY);
		critterList1.add(c);
	}
	public void addCritter2(){
		Random r = new Random();
		int numX = r.nextInt((width)) + 1;
		int numY = r.nextInt((height)) + 1;
		Critter2 c = new Critter2(numX, numY);
		critterList2.add(c);
	}
	public void addCritter3(){
		Random r = new Random();
		int numX = r.nextInt((width)) + 1;
		int numY = r.nextInt((height)) + 1;
		Critter3 c = new Critter3(numX, numY);
		critterList3.add(c);
	}
	public void addCritter4(){
		Random r = new Random();
		int numX = r.nextInt((width)) + 1;
		int numY = r.nextInt((height)) + 1;
		Critter4 c = new Critter4(numX, numY);
		critterList4.add(c);
	}
	
}
