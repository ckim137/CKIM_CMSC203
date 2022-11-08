import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Scanner;
import java.io.*;

class TwoDimmedRaggedArrayUtilityTestStudent {
	private double[][] dataSet1 = {{9.0, 8.0, 7.0}, {6.0, 5.0, 4.0}, {3.0}};


	@Test
	public void testGetHighestInArray() {
		assertEquals(9.0, TwoDimRaggedArrayUtility.getHighestInArray(dataSet1), .001);	
	}
	
	@Test
	public void testGetHighestInColumn() {
		assertEquals(9.0, TwoDimRaggedArrayUtility.getHighestInColumn(dataSet1, 0), .001);	
		assertEquals(8.0, TwoDimRaggedArrayUtility.getHighestInColumn(dataSet1, 1), .001);
		assertEquals(7.0, TwoDimRaggedArrayUtility.getHighestInColumn(dataSet1, 2), .001);
	}
	
	@Test
	public void testGetHighestInColumnIndex() {
		assertEquals(0, TwoDimRaggedArrayUtility.getHighestInColumnIndex(dataSet1, 0));	
		assertEquals(0, TwoDimRaggedArrayUtility.getHighestInColumnIndex(dataSet1, 1));
		assertEquals(0, TwoDimRaggedArrayUtility.getHighestInColumnIndex(dataSet1, 2));
	}
	
	@Test
	public void testGetHighestInRow() {
		assertEquals(9.0, TwoDimRaggedArrayUtility.getHighestInRow(dataSet1, 0), .001);	
		assertEquals(6.0, TwoDimRaggedArrayUtility.getHighestInRow(dataSet1, 1), .001);
		assertEquals(3.0, TwoDimRaggedArrayUtility.getHighestInRow(dataSet1, 2), .001);
	}
	
	@Test
	public void testGetHighestInRowIndex() {
		assertEquals(0, TwoDimRaggedArrayUtility.getHighestInRowIndex(dataSet1, 0));	
		assertEquals(0, TwoDimRaggedArrayUtility.getHighestInRowIndex(dataSet1, 1));
		assertEquals(0, TwoDimRaggedArrayUtility.getHighestInRowIndex(dataSet1, 2));
	}
	
	@Test
	public void testGetLowestInArray() {
		assertEquals(3.0, TwoDimRaggedArrayUtility.getLowestInArray(dataSet1), .001);	
	}
	
	@Test
	public void testGetLowestInColumn() {
		assertEquals(3.0, TwoDimRaggedArrayUtility.getLowestInColumn(dataSet1, 0), .001);	
		assertEquals(5.0, TwoDimRaggedArrayUtility.getLowestInColumn(dataSet1, 1), .001);
		assertEquals(4.0, TwoDimRaggedArrayUtility.getLowestInColumn(dataSet1, 2), .001);
	}
	
	@Test
	public void testGetLowestInColumnIndex() {
		assertEquals(2, TwoDimRaggedArrayUtility.getLowestInColumnIndex(dataSet1, 0));	
		assertEquals(1, TwoDimRaggedArrayUtility.getLowestInColumnIndex(dataSet1, 1));
		assertEquals(1, TwoDimRaggedArrayUtility.getLowestInColumnIndex(dataSet1, 2));
	}
	
	@Test
	public void testGetLowestInRow() {
		assertEquals(7.0, TwoDimRaggedArrayUtility.getLowestInRow(dataSet1, 0), .001);	
		assertEquals(4.0, TwoDimRaggedArrayUtility.getLowestInRow(dataSet1, 1), .001);
		assertEquals(3.0, TwoDimRaggedArrayUtility.getLowestInRow(dataSet1, 2), .001);
	}
	
	@Test
	public void testGetLowestInRowIndex() {
		assertEquals(2, TwoDimRaggedArrayUtility.getLowestInRowIndex(dataSet1, 0));	
		assertEquals(2, TwoDimRaggedArrayUtility.getLowestInRowIndex(dataSet1, 1));
		assertEquals(0, TwoDimRaggedArrayUtility.getLowestInRowIndex(dataSet1, 2));
	}
	
	@Test 
	public void testGetColumnTotal() {
		assertEquals(18.0, TwoDimRaggedArrayUtility.getColumnTotal(dataSet1, 0), .001);	
		assertEquals(13.0, TwoDimRaggedArrayUtility.getColumnTotal(dataSet1, 1), .001);
		assertEquals(11.0, TwoDimRaggedArrayUtility.getColumnTotal(dataSet1, 2), .001);
	}
	
	@Test 
	public void testGetRowTotal() {
		assertEquals(24.0, TwoDimRaggedArrayUtility.getRowTotal(dataSet1, 0), .001);	
		assertEquals(15.0, TwoDimRaggedArrayUtility.getRowTotal(dataSet1, 1), .001);
		assertEquals(3.0, TwoDimRaggedArrayUtility.getRowTotal(dataSet1, 2), .001);
	}
	
	@Test
	public void testGetTotal() {
		assertEquals(42.0, TwoDimRaggedArrayUtility.getTotal(dataSet1), .001);
	}
	
	public void testGetAverage() {
		assertEquals(6.0, TwoDimRaggedArrayUtility.getAverage(dataSet1), .001);
	}
	
}
