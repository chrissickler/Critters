package assignment4;

import java.util.ArrayList;
import java.util.Random;

public class CritterWorld {
	
	private ArrayList<CritterA> critterListA;
	private ArrayList<CritterB> critterListB;
	private ArrayList<CritterC> critterListC;
	private ArrayList<CritterD> critterListD;
	private int width;
	private int height;
	
	public CritterWorld(){
		critterListA = new ArrayList<CritterA>();
		critterListB = new ArrayList<CritterB>();
		critterListC = new ArrayList<CritterC>();
		critterListD = new ArrayList<CritterD>();
		width = Params.world_width;
		height = Params.world_height;
	}
	public void addCritterA(){
		Random r = new Random();
		int numX = r.nextInt((width)) + 1;
		int numY = r.nextInt((height)) + 1;
		CritterA c = new CritterA(numX, numY);
		critterListA.add(c);
	}
	public void addCritterB(){
		Random r = new Random();
		int numX = r.nextInt((width)) + 1;
		int numY = r.nextInt((height)) + 1;
		CritterB c = new CritterB(numX, numY);
		critterListB.add(c);
	}
	public void addCritterC(){
		Random r = new Random();
		int numX = r.nextInt((width)) + 1;
		int numY = r.nextInt((height)) + 1;
		CritterC c = new CritterC(numX, numY);
		critterListC.add(c);
	}
	public void addCritterD(){
		Random r = new Random();
		int numX = r.nextInt((width)) + 1;
		int numY = r.nextInt((height)) + 1;
		CritterD c = new CritterD(numX, numY);
		critterListD.add(c);
	}
	
}
