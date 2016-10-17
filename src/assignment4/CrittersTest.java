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
	
	//@Test
	public void testCraigRunStats() {
		for(int i = 0; i < 3;i++){
			Craig c = new Craig();
			Critter.addCritter(c);
		}
		
		try{
			CritterWorld.printWorld();
			for(int i = 0; i < 10; i++){
				CritterWorld.doTimeStep();
				Craig.runStats(Critter.getInstances("assignment4.Craig"));
				CritterWorld.printWorld();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	@Test
	public void testCritter1RunStats() {
		for(int i = 0; i < 2;i++){
			Critter1 c = new Critter1();
			Critter.addCritter(c);
		}
		
		try{
			CritterWorld.printWorld();
			for(int i = 0; i < 5; i++){
				CritterWorld.doTimeStep();
				Critter.runStats(Critter.getInstances("assignment4.Critter1"));
				CritterWorld.printWorld();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
