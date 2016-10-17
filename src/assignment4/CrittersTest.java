package assignment4;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

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
	
	@Test // VERIFIES MAKE CRITTER && REMOVE
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
	public void testClearWorld(){
		try {
			Main.main(new String[] {"make", "Critter1"});
		} catch (InvalidInputError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
