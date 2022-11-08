/*
 * Class: CMSC203 
 * Instructor: Kujit
 * Description: This class utilizes several different methods to read a ragged array from a file, write a ragged array to a file
 * and find the highest, lowest, values in each column, row, and total. Also finds the total number in each column, row, total,
 * and finds the average of all values
 * Due: 11/07/2022
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Charles Kim
*/

import java.io.*;
import java.util.Scanner;

public class TwoDimRaggedArrayUtility 
{
	public static double getHighestInArray(double[][] array)
	{
		double highest = -9999;
		//loop through each row
		for (int i = 0; i < array.length; i++)
		{
			//loop through each column, in each row
			for (int j = 0; j < array[i].length; j++)
			{
				//if current element is greater than (highest), set highest to current element
				if(array[i][j] > highest)
					highest = array[i][j];
			}
		}
		return highest;
	}
	public static double getHighestInColumn (double[][] array, int col)
	{
		double highest = -9999;
		//loop through each row 
		for (int i = 0; i < array.length; i++)
		{
			//check whether row has column index, if not, skip over that row
			if(col >= array[i].length)
				continue;
			
			//check whether column index is greater than highest, if so set highest to column index element
			if (array[i][col] > highest)
				highest = array[i][col];
		}
		return highest;
	}
	public static int getHighestInColumnIndex(double[][] array, int col)
	{
		//variables
		double highest = -9999;
		int index = -1;
		//loop through each row
		for (int i = 0; i < array.length; i++)
		{
			//check whether row has column index
			if(col >= array[i].length)
				continue;
			//check whether column index is greater than highest, if so set highest to column index element, and 
			//set index variable to i
			if (array[i][col] > highest)
			{
				//
				highest = array[i][col];
				index = i;
			}
		}
		return index;
	}
	public static double getHighestInRow (double[][] array, int row)
	{
		double highest = -9999;
		//loop through each row
		for (int i = 0; i < array[row].length; i++)
		{
			//if (row, i) in array > highest, set highest to element in (row, i)
			if(array[row][i] > highest)
			{
				highest = array[row][i];
			}
		}
		return highest;
	}
	public static double getHighestInRowIndex (double[][] array, int row)
	{
		//variables
		double highest = -9999;
		int index = -1;
		//loop through each row
		for (int i = 0; i < array[row].length; i++)
		{
			//if (row, i) in array > highest, set highest to element in (row, i) and set index to i
			if(array[row][i] > highest)
			{
				highest = array[row][i];
				index = i;
			}
		}
		return index;
	}
	public static double getLowestInArray (double[][] array)
	{
		//variable for lowest element
		double lowest = 9999;
		//loop through each row
		for(int i = 0; i < array.length; i++)
		{
			//loop through each column
			for (int j = 0; j < array[i].length; j++)
			{
				//if (i, j) in array < lowest, set lowest to element in (i, j) of array
				if(array[i][j] < lowest)
				{
					lowest = array[i][j];
				}
			}
		}
		return lowest;
	}
	public static double getLowestInColumn(double[][] array, int col)
	{
		double lowest = 9999;
		//loop through each row
		for(int i = 0; i < array.length; i++)
		{
			//if current row doesn't have column index, skip over that row
			if(col >= array[i].length)
				continue;
			//if (i, col) in array < lowest, set lowest to element in (i, col)
			if(array[i][col] < lowest)
			{
				lowest = array[i][col];
			}
		}
		return lowest;
	}
	public static int getLowestInColumnIndex(double[][] array, int col) 
	{
		//variable for lowest element, index where lowest element is
	    double lowest = 9999;
	    int index = -1;
	    //loop through each row
	    for (int i = 0;i < array.length;i++) 
	    {
	    	//if current row doesn't have column index, skip over that row
	      if (col >= array[i].length) 
	        continue;
	      //if (i, col) in array < lowest, set lowest to element in (i, col) and set index to i
	      if (array[i][col] < lowest) 
	      {
	        lowest = array[i][col];
	        index = i;
	      }
	    }
	    return index;
	  }
	public static double getLowestInRow(double[][] array, int row)
	{
		//variable for lowest element
		double lowest = 9999;
		//loop through each column
		for(int i = 0; i < array[row].length; i++)
		{
			//if (row, i) in array < lowest, set lowest to element in (row, i)
			if(array[row][i] < lowest)
				lowest = array[row][i];
		}
		return lowest;
	}
	public static int getLowestInRowIndex(double[][] array, int row)
	{
		//variable for lowest element and index of lowest element
		double lowest = 9999;
		int index = -1;
		//loop through each column
		for(int i = 0; i < array[row].length; i++)
		{
			//if (row, i) in array < lowest, set lowest to element in (row, i)
			if(array[row][i] < lowest)
			{
				lowest = array[row][i];
				index = i;
			}
		}
		return index;
	}
	public static double getColumnTotal (double[][]array, int col)
	{
		//variable for total of one column
		double total = 0; 
		//loop through each row
		for(int i = 0; i < array.length; i++)
		{
			//check whether row has col index, if not, skip
			if(col >= array[i].length)
				continue;
			//add element in (i, col) to total
			total += array[i][col];
		}
		return total;
	}
	public static double getRowTotal(double[][]array, int row)
	{
		//variable for total of all elements in one row
		double total = 0; 
		//loop through each column
		for(int i = 0; i < array[row].length; i++)
		{
			//add element in (row, i) of array to sum 
			total += array[row][i];
			
		}
		return total;
	}
	public static double getTotal (double[][] array)
	{
		//variable for total of all elements
		double total = 0;
		//loop through each row
		for(int i = 0; i < array.length; i++)
		{
			//loop through each column
			for (int j = 0; j < array[i].length; j++)
			{
				//add element in (i, j) to total
				total+= array[i][j];
			}
		}
		return total;
	}
	public static double getAverage (double[][] array) 
	{
		//variables
		int count = 0;
		double total = 0;
		
		for(int i = 0; i < array.length; i++) 
		{
			for(int j = 0; j < array[i].length; j++)
			{
				//add element in (row, column) to total, then add 1 to count. (count = number of elements)
				total += array[i][j];
				count++;
			}
		}
		return total/count; 
	}
	public static double[][] readFile (File file) throws FileNotFoundException
	{
		//starting variables: scanner to read file, numRows to count # of rows in file, rowIndex to track current row
		int numRows = 0;
		Scanner sc = new Scanner(file);
		int rowIndex = 0;
		
		//counting rows using sc
		while(sc.hasNextLine())
		{
			numRows++;
			sc.nextLine();
		}
		sc.close();
		
		//create new array based on # of rows, new scanner to read from file again, but this time to read each number
		double array[][] = new double[numRows][];
		Scanner sc2 = new Scanner(file);
		
		//until sc2 reaches end of file
		while(sc2.hasNextLine())
		{
			//initialize string with each line in file, then create columns of numbers by splitting line by spaces
			String line = sc2.nextLine();
			String col[] = line.split(" ");
			array[rowIndex] = new double[col.length];
			
			//loop for each element in each column
			for(int i = 0; i < col.length; i++)
				//parse string to double, save in array
				array[rowIndex][i] = Double.parseDouble(col[i]);
			rowIndex++;
		}
		sc2.close();
		return array;
	}
	public static void writeToFile(double[][] array, File outFile) throws FileNotFoundException
	{
		//file to write array to, string builder
		PrintWriter result = new PrintWriter(outFile);
		StringBuilder sb = new StringBuilder();
		
		//loop through each row/column in array
		for(int i = 0; i < array.length; i++)
		{
			for(int j = 0; j < array[i].length; j++)
			{
				//write element in (i, j) of array to StringBuilder, separated by spaces
				sb.append(array[i][j] + " ");
			}
			//newline
			sb.append("\n");
		}
		//turn sb to String using toString, write that to result, then close result
		result.print(sb.toString());
		result.close();
	}
}
