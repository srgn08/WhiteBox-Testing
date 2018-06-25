package org.jfree.data.test;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.jfree.data.DataUtilities;
import org.jfree.data.DefaultKeyedValues;
import org.jfree.data.Values2D;
import org.jmock.Expectations;
import org.jmock.Mockery;

import static org.junit.Assert.*;

public class DataUtilitiesTest extends TestCase{
	
	/* testing the calculate column function so if input is 8.5,2.5,2.5 and result is 13.5 program runs correctly */
	 public void testCalculateColumnTotalForThreeValuesInputIsTrue() {  
		 Mockery mockingContext = new Mockery();
		 final Values2D values = mockingContext.mock(Values2D.class); 
		 mockingContext.checking(new Expectations() {  
			 {
			 one(values).getRowCount();
			 will(returnValue(3));  
			 one(values).getValue(0, 0); 
			 will(returnValue(8.5));  
			 one(values).getValue(1, 0); 
			 will(returnValue(2.5)); 
			 one(values).getValue(2, 0); 
			 will(returnValue(2.5)); 
			 } 
			 }); 
		 double result = DataUtilities.calculateColumnTotal(values, 0); 
		 assertEquals(result, 13.5, .000000001d);
		 } 
	 
	 
	 
	 /* testing the calculate column function so if input is 8,2.5,2.5 and result is 13.5 program runs not correctly */
	 public void testCalculateColumnTotalForThreeValuesInputIsFalse() {
		 Mockery mockingContext = new Mockery();
		 final Values2D values = mockingContext.mock(Values2D.class); 
		 mockingContext.checking(new Expectations() {  
			 {     one(values).getRowCount();
			 will(returnValue(3));  
			 one(values).getValue(0, 0); 
			 will(returnValue(8));  
			 one(values).getValue(1, 0); 
			 will(returnValue(2.5)); 
			 one(values).getValue(2, 0); 
			 will(returnValue(2.5)); 
			 } 
			 }); 
		 double result = DataUtilities.calculateColumnTotal(values, 0); 
		 assertEquals(result, 13.5, .000000001d);   
		 } 
	 
	 
	 
	 /* testing the calculate row function so if input is 8,2.5,5.5 and result is 16.0 program runs correctly */
	 public void testCalculateRowTotalForThreeValuesInputIsTrue() {
		 Mockery mockingContext = new Mockery();
		 final Values2D values = mockingContext.mock(Values2D.class); 
		 mockingContext.checking(new Expectations() {  
			 {     one(values).getColumnCount();
			 will(returnValue(4));  
			 one(values).getValue(0, 0); 
			 will(returnValue(8.0));  
			 one(values).getValue(0, 1); 
			 will(returnValue(2.5)); 
			 one(values).getValue(0, 2); 
			 will(returnValue(5.5)); 
			 } 
			 });  
		 double result = DataUtilities.calculateRowTotal(values, 0); 
		 assertEquals(result, 16.0, .000000001d);   
		 } 
	 
	 
	 
	 /* testing the calculate row function so if input is 4,2.5,1.5 and result is 9.0 program runs not correctly */

	 public void testCalculateRowTotalForThreeValuesInputIsFalse() {
		 Mockery mockingContext = new Mockery();
		 final Values2D values = mockingContext.mock(Values2D.class); 
		 mockingContext.checking(new Expectations() {  
			 {     one(values).getColumnCount();
			 will(returnValue(4));  
			 one(values).getValue(0, 0); 
			 will(returnValue(4.0));  
			 one(values).getValue(0, 1); 
			 will(returnValue(2.5)); 
			 one(values).getValue(0, 2); 
			 will(returnValue(1.5)); 
			 } 
		 }); 
		 double result = DataUtilities.calculateRowTotal(values, 0); 
		 assertEquals(result, 9.0, .000000001d);  
	 } 
	 
	 /* testing the create number function so 2 array is equals program runs correctly */

	  public void  testCreateNumberArray() 
	  {
		    Number[] expected = {1.0,3.5,5.5};
			Number[] result = {1.0,3.5,5.5};
			assertArrayEquals(expected,result);
	  }
	  
	  
	  
	  
	  /* testing the create number function so 2 array is not equals program runs not correctly */
	  public void  testCreateNumber2ArrayFalse() 
	  {
		   Number[] expected = {1.0,3.5,4.5};
			Number[] result = {1.0,3.5,5.5};
			assertArrayEquals(expected,result);
	  }
	  
	  
	  
	  
	  /* testing the create number array 2d function so 2 array is not equals program runs not correctly */ 
	  public void  testCreateNumberArray2DFalse() 
	  {
		   Number[][] expected = {{1.0,3.5,4.5},{2.0,2.6,3.2}};
			Number[][] result = {{1.0,3.5,4.5},{1.0,2.3,3.2}};
			assertArrayEquals(expected,result);
	  }
	  
	  
	  
	  
	  /* testing the create number array 2d function so 2 array is equals program runs correctly */
	  public void  testCreateNumber2Array2D() 
	  {
		   Number[][] expected = {{1.0,3.6,4.5},{2.0,2.3,3.2}};
			Number[][] result = {{1.0,3.6,4.5},{2.0,2.3,3.2}};
			assertArrayEquals(expected,result);
	  }
	  
	  
	  
	  
	  /*testing the cumulative percentage function*/
	  public void testDataUtilities_getCumulativePercentages_lastKey_expectedHundredPercent(){
	        DefaultKeyedValues values = new DefaultKeyedValues();
	        values.addValue("ONE",1);
	        values.addValue("TWO",2);
	        values.addValue("THREE",3);
	        values.addValue("FOUR",4);
	        values.addValue("FIVE",5);
	        Number data = DataUtilities.getCumulativePercentages(values).getValue("FIVE");
	        Assert.assertEquals(((1.0 + 2.0 + 3.0 + 4.0 + 5.0) / 15.0),data.doubleValue(),0);
	    }
	  
	  
	  
	  /*testing the cumulative percentage function*/
	  public void testDataUtilities_getCumulativePercentages_firstKey_expectedFirstDivideTotal(){
	        DefaultKeyedValues values = new DefaultKeyedValues();
	        values.addValue("ONE",1);
	        values.addValue("TWO",2);
	        values.addValue("THREE",3);
	        values.addValue("FOUR",4);
	        values.addValue("FIVE",5);
	        Number data = DataUtilities.getCumulativePercentages(values).getValue("ONE");
	        Assert.assertEquals(1.0/15.0,data.doubleValue(),0);
	    }
	  
	  
	  
	  
	  /*testing the cumulative percentage function*/
	    public void testDataUtilities_getCumulativePercentages_CallsMiddleKey_expectedTrueValue(){
	        DefaultKeyedValues values = new DefaultKeyedValues();
	        values.addValue("ONE",1);
	        values.addValue("TWO",2);
	        values.addValue("THREE",3);
	        values.addValue("FOUR",4);
	        values.addValue("FIVE",5);
	        Number data = DataUtilities.getCumulativePercentages(values).getValue("THREE");
	        Assert.assertEquals(((1.0 + 2.0 + 3.0) / 15.0),data.doubleValue(),0);
	    }

	  


 }
	 
	 
		 
	        
 

	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
