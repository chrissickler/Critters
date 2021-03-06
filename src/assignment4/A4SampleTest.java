package assignment4;

import static org.junit.Assert.*;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import org.junit.Test;


import assignment4.Critter.TestCritter;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import static org.hamcrest.CoreMatchers.containsString;

public class A4SampleTest{

	private static String TESTSRCDIR = "test_sample/";
	private static  ByteArrayOutputStream outContent;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		TestCritter.clearWorld();
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
	}

	@After
	public void tearDown() throws Exception {
	}

	
	/*
	 * 4. KillCritters
	 * Test: killCritters
     * Test for make critter and stats, and step
     * Creates large number of make critters and compare stats after 500 steps
     * Expects all Critters to be dead
     */

	//PASSED
	//@Test 
	public void KillCritters(){		
		//Uncomment Following Codeblock to test 
		//Remove final keyword from Params.java

		Params.world_width = 20;
		Params.world_width = 20;
		Params.walk_energy_cost = 2;
		Params.run_energy_cost = 5;
		Params.rest_energy_cost = 1;
		Params.min_reproduce_energy = 20;
		Params.refresh_algae_count = (int)Math.max(1, Params.world_width*Params.world_height/1000);
		Params.photosynthesis_energy_amount = 1;
		Params.start_energy = 5;
		
		String fileFolder = "kill_all_critter_";
		String[] inputs = {fileFolder + "input.txt", "test"};
		
		Main.main(inputs);
		outContent = Main.testOutputString;
		
		Scanner scanner = null;
		try {
			scanner = new Scanner( new File(fileFolder + "expected_output.txt") );
		} catch (FileNotFoundException e) {
		
			e.printStackTrace();
		}
		String text = scanner.useDelimiter("\\A").next().trim();
		String output =outContent.toString().replace("critters> ","").trim();
		scanner.close();
		
		assertEquals(text,output);
	}
	
	
	
	
	/*
	 * 6. ParseErrors
	 * 	
     * Test: ParseErrors
     * Test for errors within valid inputs
     * Expects errors to be printed
	 */
	//passed
	//@Test 
	public void ParseErrors(){
		
	
		//Uncomment following codeblock to test with parameters
		//Remove final keyword in Params.java
			
		Params.world_width = 20;
		Params.world_width = 20;
		Params.walk_energy_cost = 2;
		Params.run_energy_cost = 5;
		Params.rest_energy_cost = 1;
		Params.min_reproduce_energy = 20;
		Params.refresh_algae_count = (int)Math.max(1, Params.world_width*Params.world_height/1000);
		Params.photosynthesis_energy_amount = 1;
		Params.start_energy = 100;		
		
		
		String fileFolder = "error_processing_";
		String[] inputs = {fileFolder + "input.txt", "test"};
		
		Main.main(inputs);
		outContent = Main.testOutputString;
		
		Scanner scanner = null;
		try {
			scanner = new Scanner( new File(fileFolder + "expected_output.txt") );
		} catch (FileNotFoundException e) {
		
			e.printStackTrace();
		}
		String text = scanner.toString();//useDelimiter("\\A").next().replace("\n","").replace("\r", "").trim();
		String output = outContent.toString().replace("critters> ","").replace("\n","").trim();
		scanner.close();
		assertThat(text, containsString(output));
		
	}
	//passed
	//@Test
	public void EmptyWorld() {
		String fileFolder = "empty_world_";
		String[] inputs = {fileFolder + "input.txt"};
		Main.main(inputs);
		outContent = Main.testOutputString;
		Scanner scanner = null;
		try {
			scanner = new Scanner( new File(fileFolder + "expected_output.txt") );
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String text = scanner.useDelimiter("\\A").next().trim();
		String output = outContent.toString().replace("critters> ","").trim();
		scanner.close();
		assertThat(text, containsString(output));
	}
	
	@Test
	public void LargeCritter() {
		String fileFolder = "make_large_critter_";
		String[] inputs = {fileFolder + "input.txt"};
		Main.main(inputs);
		outContent = Main.testOutputString;
		Scanner scanner = null;
		try {
			scanner = new Scanner( new File(fileFolder + "expected_output.txt") );
		} catch (FileNotFoundException e) {
		
			e.printStackTrace();
		}
		String text = scanner.useDelimiter("\\A").next().trim();
		String output = outContent.toString().replace("critters> ","").trim();
		scanner.close();
		assertThat(text, containsString(output));
	}
	
	
}