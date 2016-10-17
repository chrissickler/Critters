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
	
	@Test
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

}
