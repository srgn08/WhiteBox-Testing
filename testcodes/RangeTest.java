package org.jfree.data.test; 

import junit.framework.TestCase;
import org.jfree.data.Range;
import org.junit.*;  
public class RangeTest extends TestCase {  

	/* testing the lower bound function range is (-4,4) so if lower bound input is -4 , program runs correctly */
 	public void testlowerBoundInputIsTrueValue(){          
 		Range exampleRange = new Range(-4, 4);
 		assertEquals("The lower bound is -4",  -4, exampleRange.getLowerBound(), .000000001d);
 			
 		}
 	
 	
 	/* testing the lower bound function range is (6,9) so if lower bound input is 8 , program runs not correctly */
 	public void testlowerBoundInputIsIntoTheRange(){
 		Range exampleRange2 = new Range(6, 9);
 		assertEquals("The lower bound is 6", 8, exampleRange2.getLowerBound(), .000000001d);
 			
 		}
 	
 	
 	/* testing the lower bound function range is (0,1) so if lower bound input is 10 , program runs not correctly */
 	public void testlowerBoundInputIsGreaterThanUpperBound(){
 		Range exampleRange3 = new Range(0,1);
 		assertEquals("The lower bound is 0",  10, exampleRange3.getLowerBound(), .000000001d);
 			
 		}
 	
 	public void testlowerBoundInputIsUpperBound(){
 		Range exampleRange3 = new Range(0,1);
 		assertEquals("The lower bound is 0",  1, exampleRange3.getLowerBound(), .000000001d);
 			
 		}
 	

 	
 	
 	
 	/* testing the length function range is (-4,4) so if length input is 8 , program runs correctly */
 	public void testlenghtInputIsTrue(){
 		Range exampleRange = new Range(-4, 4);
 		assertEquals("The length is 8",  8, exampleRange.getLength(), .000000001d);
 			
 		}
 	
 	
 	/* testing the length function range is (6,9) so if length input is 4 , program runs not correctly */
 	public void testlengthInputIsFalse(){
 		Range exampleRange2 = new Range(6, 9);
 		assertEquals("The length is 3", 4, exampleRange2.getLength(), .000000001d);
 			
 		}
 	
 	/* testing the central value function range is (0,10) so if central value input is 5 , program runs correctly */
 	public void testCentralValueInputIsTrue(){
 		Range exampleRange = new Range(0, 10);
 		assertEquals("The central value is 5", 5, exampleRange.getCentralValue(), .000000001d);
 			
 		}
 	
 	
 	/* testing the length function range is (-1,1) so if central values input is 1, program runs not correctly */
 	public void testCentralValueInputIsFalse(){
 		Range exampleRange2 = new Range(-1, 1);
 		assertEquals("The central value is 0", 1, exampleRange2.getCentralValue(), .000000001d);
 			
 		}
 	
 	/* testing the contains function range is (0,10) so if contains input is 8 , program runs correctly */
 	public void testContainsInputIsTrue(){
 		Range exampleRange = new Range(0, 10);
 		assertTrue( exampleRange.contains(8));
 			
 		}
 	
 	
 	/* testing the contains function range is (-1,1) so if contains input is 5 , program runs not correctly */
 	public void testContainsInputIsFalse(){
 		Range exampleRange2 = new Range(-1, 1);
 		assertTrue(exampleRange2.contains(5));
 			
 		}
 	
 	/* testing the equals function range1 is (0,10) and range2 is (0,10) so program runs correctly */
 	public void testEqualsInputIsTrue(){
 		Range exampleRange = new Range(0, 10);
 		Range exampleRange2 = new Range(0, 10);
 		assertTrue( exampleRange.equals(exampleRange2));
 			
 		}
 	
 	
 	/* testing the equals function range1 is (0,10) and range2 is (4,10) so program runs not correctly */
 	public void testEqualsInputIsFalse(){
 		Range exampleRange = new Range(0, 10);
 		Range exampleRange2 = new Range(4, 10);
 		assertTrue(exampleRange2.equals(exampleRange));
 			
 		} 	
 	
 	
 	/*testing the equals function is true input */
 	public void testEqualsInputIsTrue2(){
 		Range exampleRange = new Range(1, 3);
 		Range exampleRange2 = new Range(1, 3);
 		assertTrue(exampleRange2.equals(exampleRange));
 			
 		} 
 	
 	
 	
 	
 	
 
 } 