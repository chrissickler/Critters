/* 
* EE422C Project 4 submission by
 * Karl Solomon
 * Kws653
 * 16445
 * Christopher Sickler
 * cbs2468
 * 16445
 * Slip days used: 0
 * Fall 2016
 */
package assignment4;

import static org.junit.Assert.*;

import org.junit.Test;

public class CritterSystemTest {

	@Test
	public void testSystem1() {
		//FIXME: INPUT NEXTLINE INTO MAIN, NOT NEXT
		String inputFile = "mainTest2.txt";
		String[] args = {inputFile};
		Main.main(args);
		
		/*	EXPECTED OUTPUT
		 * 	error processing: seed 10 abcdefghij
			error processing: make Craig 10 throwerror
			error processing: make Craig wrongstuff
			error processing: make Craig 10dontcountme
			error processing: step javaiscool
			error processing: show morewrongstuff
		 */
	}
	
	//@Test
	public void testSystem2() {
		String inputFile = "mainTest3.txt";
		String[] args = {inputFile};
		Main.main(args);
		/** EXPECTED OUTPUT
		 * 	1000 total Craigs    12.5% straight   12.5% back   37.5% right   37.5% left   
			0 total Craigs    NaN% straight   NaN% back   NaN% right   NaN% left
		 */
		
	}
	
	//@Test
	public void testSystem3() {
	}
	
	//@Test
	public void testSystem4() {
	}
}
