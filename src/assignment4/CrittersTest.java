package assignment4;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import assignment4.Critter.TestCritter;

public class CrittersTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	//@Test
	public void testAddCritter() {
		Craig c = new Craig();
		Critter.addCritter(c);
		Critter1 c1 = new Critter1();
		Critter.addCritter(c1);
		Critter2 c2 = new Critter2();
		Critter.addCritter(c2);
		Critter3 c3 = new Critter3();
		Critter.addCritter(c3);
		Critter4 c4 = new Critter4();
		Critter.addCritter(c4);
		
		try {
			CritterWorld.printWorld();
			for(int i = 0; i < 10; i++){
				CritterWorld.doTimeStep();
				CritterWorld.printWorld();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	//@Test // VERIFIES MAKE CRITTER && REMOVE
	public void testRemoveCritter() {
		Craig c = new Craig();
		Critter.addCritter(c);
		try {
			Critter.makeCritter("assignment4.Craig");
		} catch (InvalidCritterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Critter.displayWorld();	// empty
		Critter.worldTimeStep();
		Critter.displayWorld();	// added craig
		c.setEnergy(0);
		Critter.worldTimeStep(); // remove craig
		Critter.displayWorld();	// no craig
	}
	
	//@Test
	public void testFightCritter(){
		int numCritters = 10;
		try {
			for(int i = 0; i < numCritters; i++) {
				Critter.makeCritter("assignment4.Critter1");
				Critter.makeCritter("assignment4.Critter2");
				Critter.makeCritter("assignment4.Critter3");
				Critter.makeCritter("assignment4.Critter4");
			}
		} catch (InvalidCritterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int numCrittersBefore = CritterWorld.babies.keySet().size();
		Critter.worldTimeStep();
		for(TestCritter i : CritterWorld.critterMap.keySet()){
			i.setX_coord(0);
			i.setY_coord(0);
		}
		Critter.worldTimeStep();
		int numCrittersAfter = CritterWorld.critterMap.keySet().size();
		assertTrue(numCrittersBefore == numCritters*4);
		assertTrue(numCrittersAfter < numCrittersBefore);
	}
	
	//@Test
	public void testRunStats() {
		for(int i = 0; i < 3;i++){
			Craig c = new Craig();
			Critter.addCritter(c);
			Critter1 c1 = new Critter1();
			Critter.addCritter(c1);
		}
		
		try{
			CritterWorld.printWorld();
			for(int i = 0; i < 10; i++){
				CritterWorld.doTimeStep();
				Craig.runStats(Critter.getInstances("assignment4.Craig"));
				Critter1.runStats(Critter.getInstances("assignment4.Critter1"));
				CritterWorld.printWorld();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	//@Test
	public void testCritterWalk(){
		Craig c = new Craig();
		c.setX_coord(10);
		c.setY_coord(10);
		c.setEnergy(1000);
		boolean b0 = false;
		boolean b1 = false;
		boolean b2 = false;
		boolean b3 = false;
		boolean b4 = false;
		boolean b5 = false;
		boolean b6 = false;
		boolean b7 = false;
		Critter.addCritter(c);
		Point p1 = new Point(c.getX_coord(), c.getY_coord());
		c.walk(0);
		Point p2 = new Point(c.getX_coord(), c.getY_coord());
		if( (p2.getX() - p1.getX() == 1) && (p1.getY() == p2.getY()) ){
			b0 = true;
		}
		//c.hasMoved = false;
		c.walk(1);
		Point p3 = new Point(c.getX_coord(), c.getY_coord());
		if( (p3.getX() - p2.getX() == 1) && (p2.getY() - p3.getY() == 1) ){
			b1 = true;
		}
		//c.hasMoved = false;
		c.walk(2);
		Point p4 = new Point(c.getX_coord(), c.getY_coord());
		if( (p3.getX() - p4.getX() == 0) && (p3.getY() - p4.getY() == 1) ){
			b2 = true;
		}
		//c.hasMoved = false;
		c.walk(3);
		Point p5 = new Point(c.getX_coord(), c.getY_coord());
		if( (p4.getX() - p5.getX() == 1) && (p4.getY() - p5.getY() == 1) ){
			b3 = true;
		}
		//c.hasMoved = false;
		c.walk(4);
		Point p6 = new Point(c.getX_coord(), c.getY_coord());
		if( (p5.getX() - p6.getX() == 1) && (p5.getY() - p6.getY() == 0) ){
			b4 = true;
		}
		//c.hasMoved = false;
		c.walk(5);
		Point p7 = new Point(c.getX_coord(), c.getY_coord());
		if( (p6.getX() - p7.getX() == 1) && (p7.getY() - p6.getY() == 1) ){
			b5 = true;
		}
		//c.hasMoved = false;
		c.walk(6);
		Point p8 = new Point(c.getX_coord(), c.getY_coord());
		if( (p8.getX() - p7.getX() == 0) && (p8.getY() - p7.getY() == 1) ){
			b6 = true;
		}
		//c.hasMoved = false;
		c.walk(7);
		Point p9 = new Point(c.getX_coord(), c.getY_coord());
		if( (p9.getX() - p8.getX() == 1) && (p9.getY() - p8.getY() == 1) ){
			b7 = true;
		}
		//c.hasMoved = false;
		assertTrue(b0 && b1 && b2 && b3 && b4 && b5 && b6 && b7);
	}
	@Test
	public void testCritterRun(){
		Craig c = new Craig();
		c.setX_coord(10);
		c.setY_coord(10);
		c.setEnergy(1000);
		boolean b0 = false;
		boolean b1 = false;
		boolean b2 = false;
		boolean b3 = false;
		boolean b4 = false;
		boolean b5 = false;
		boolean b6 = false;
		boolean b7 = false;
		Critter.addCritter(c);
		Point p1 = new Point(c.getX_coord(), c.getY_coord());
		c.run(0);
		Point p2 = new Point(c.getX_coord(), c.getY_coord());
		if( (p2.getX() - p1.getX() == 2) && (p1.getY() - p2.getY() == 0) ){
			b0 = true;
		}
		c.run(1);
		Point p3 = new Point(c.getX_coord(), c.getY_coord());
		if( (p3.getX() - p2.getX() == 2) && (p2.getY() - p3.getY() == 2) ){
			b1 = true;
		}
		c.run(2);
		Point p4 = new Point(c.getX_coord(), c.getY_coord());
		if( (p3.getX() - p4.getX() == 0) && (p3.getY() - p4.getY() == 2) ){
			b2 = true;
		}
		c.run(3);
		Point p5 = new Point(c.getX_coord(), c.getY_coord());
		if( (p4.getX() - p5.getX() == 2) && (p4.getY() - p5.getY() == 2) ){
			b3 = true;
		}
		c.run(4);
		Point p6 = new Point(c.getX_coord(), c.getY_coord());
		if( (p5.getX() - p6.getX() == 2) && (p5.getY() - p6.getY() == 0) ){
			b4 = true;
		}
		c.run(5);
		Point p7 = new Point(c.getX_coord(), c.getY_coord());
		if( (p6.getX() - p7.getX() == 2) && (p7.getY() - p6.getY() == 2) ){
			b5 = true;
		}
		c.run(6);
		Point p8 = new Point(c.getX_coord(), c.getY_coord());
		if( (p8.getX() - p7.getX() == 0) && (p8.getY() - p7.getY() == 2) ){
			b6 = true;
		}
		c.run(7);
		Point p9 = new Point(c.getX_coord(), c.getY_coord());
		if( (p9.getX() - p8.getX() == 2) && (p9.getY() - p8.getY() == 2) ){
			b7 = true;
		}
		assertTrue(b0 && b1 && b2 && b3 && b4 && b5 && b6 && b7);
	}
}
