/* CRITTERS Main.java
 * EE422C Project 4 submission by
 * Replace <...> with your actual data.
 * <Student1 Name>
 * <Student1 EID>
 * <Student1 5-digit Unique No.>
 * <Student2 Name>
 * <Student2 EID>
 * <Student2 5-digit Unique No.>
 * Slip days used: <0>
 * Fall 2016
 */
package assignment4; // cannot be in default package
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;
import java.lang.reflect.*;


/*
 * Usage: java <pkgname>.Main <input file> test
 * input file is optional.  If input file is specified, the word 'test' is optional.
 * May not use 'test' argument without specifying input file.
 */
public class Main {

    static Scanner kb;	// scanner connected to keyboard input, or input file
    private static String inputFile;	// input file, used instead of keyboard input if specified
    static ByteArrayOutputStream testOutputString;	// if test specified, holds all console output
    private static String myPackage;	// package of Critter file.  Critter cannot be in default pkg.
    private static boolean DEBUG = false; // Use it or not, as you wish!
    static PrintStream old = System.out;	// if you want to restore output to console
    private static ArrayList<String> validCommands = new ArrayList<String>();


    // Gets the package name.  The usage assumes that Critter and its subclasses are all in the same package.
    static {
        myPackage = Critter.class.getPackage().toString().split(" ")[1];
        validCommands.add("quit");
        validCommands.add("show");
        validCommands.add("step");
        validCommands.add("seed");
        validCommands.add("make");
        validCommands.add("stats");
    }

    /**
     * Main method.
     * @param args args can be empty.  If not empty, provide two parameters -- the first is a file name, 
     * and the second is test (for test output, where all output to be directed to a String), or nothing.
     * @throws InvalidInputError 
     */
    public static void main(String[] args) { 
        if (args.length != 0) {
            try {
                inputFile = args[0];
                kb = new Scanner(new File(inputFile));			
            } catch (FileNotFoundException e) {
                System.out.println("USAGE: java Main OR java Main <input file> <test output>");
                e.printStackTrace();
            } catch (NullPointerException e) {
                System.out.println("USAGE: java Main OR java Main <input file>  <test output>");
            }
            if (args.length >= 2) {
                if (args[1].equals("test")) { // if the word "test" is the second argument to java
                    // Create a stream to hold the output
                    testOutputString = new ByteArrayOutputStream();
                    PrintStream ps = new PrintStream(testOutputString);
                    // Save the old System.out.
                    old = System.out;
                    // Tell Java to use the special stream; all console output will be redirected here from now
                    System.setOut(ps);
                }
            }
        } else { // if no arguments to main
            kb = new Scanner(System.in); // use keyboard and console
        }

        /* Do not alter the code above for your submission. */
        /* Write your code below. */
        String input;
        String[] inputs;
        while(true) {
        	if(kb.equals(System.in)){
        		System.out.println("critters> ");
        	}
        	input = kb.nextLine();
        	inputs = input.split(" ");
        	
        	if(inputs[0].equalsIgnoreCase("quit") && inputs.length == 1) {//DONE
        		break;//breaking the loop and ending the program
        	}
        	else if (inputs[0].equalsIgnoreCase("show") && inputs.length == 1) {//DONE
        		Critter.displayWorld();//displaying the world     		
        	}
        	else if (inputs[0].equalsIgnoreCase("step") && inputs.length < 3) {//DONE
        		int numSteps = 1;
        		if(inputs.length == 2) {
        			try {
        				numSteps = Integer.parseInt(inputs[1]);
        			} catch (NumberFormatException e) {
        				printError(input);
        				continue;
        			}
        		}
        		for(int i = 0; i < numSteps; i++) {
        			Critter.worldTimeStep();
        		}
        	}
        	else if (input.equalsIgnoreCase("seed") && inputs.length == 2) {//DONE
        		try{
        			Long l = Long.parseLong(inputs[1]);//getting the long number to pass to seed
        			Critter.setSeed(l);
        		}catch(NumberFormatException e){//if error was found in the input
        			printError(input);
        		}        		
        	}
        	else if (input.equalsIgnoreCase("make") && inputs.length > 1 && inputs.length < 4) {//DONE
        		String packageName = "assignment4.";//tag to add to beginning of class name
        		int numMake = 1;
        		String name = inputs[1];
        		if(inputs.length == 3) {
        			try {
        				numMake = Integer.parseInt(inputs[2]); 
        				for(int i = 0; i < numMake; i++) {
        					Critter.makeCritter(packageName + name); 
        				}
        			} catch (InvalidCritterException | NumberFormatException  e) {
        				printError(input);
        			}
        		}
        	}
        	else if (input.equalsIgnoreCase("stats") && inputs.length == 2) {//DONE
        		String packageName = "assignment4.";//tag to add to class name
        		if(kb.hasNext()){
        			String name = kb.next();//getting name of class to get stats for
        			try{
        				List <Critter> list = Critter.getInstances(packageName + name);
        				//^^Retrieving the list of specific critters present in the world
        				Class<?> myClass = Class.forName(packageName + name);
        				//^^Creating Class object of the type of Critter input
        				Method method = myClass.getMethod("runStats", List.class);
        				//^^Retrieving the method runStats from the specific Class object
        				method.invoke(null, list);//null because static, list is parameter
        				//running the runStats method
        			}catch(Exception e){
        				printError(input);
        			}
        		}        		
        	}
        	else {
        		if(validCommands.contains(inputs[0])) {
            		printError(input);
        		} else {
        			System.out.println("invalid command: " + input);
        		}
        	}
        }
        /* Write your code above */
        System.out.flush();

    }
    /**
     * Prints out that an error has occured while processing and gives the input that caused the error
     * @param s is string that caused error
     */
    public static void printError(String s){
    	System.out.println("error processing: " + s);
    }
}
