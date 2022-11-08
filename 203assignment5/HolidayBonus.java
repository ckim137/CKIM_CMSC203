/*
 * Class: CMSC203 
 * Instructor: Kujit
 * Description: This class utilizies TwoDimRaggedArrayUtility to calculate an array of bonuses for each store and calculate the 
 * total bonus. 
 * Due: 11/07/2022
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Charles Kim
*/
public class HolidayBonus {
	public static double[] calculateHolidayBonus(double[][] array)
	{
		//array to hold bonuses, constants for bonus amount
		double[] bonus = new double[array.length];
		final int HIGH_BONUS = 5000;
		final int LOW_BONUS = 1000;
		final int OTHER_BONUS = 2000;
		//find max number of columns
		int maxCol = 0;
		for(int i = 0; i < array.length; i++)
		{
			if(maxCol < array[i].length)
				maxCol = array[i].length;
		}
		
		for(int i = 0; i < maxCol; i++)
		{
			//calculating highest and lowest bonuses
			int highIndex = TwoDimRaggedArrayUtility.getHighestInColumnIndex(array, i);
			int lowIndex = TwoDimRaggedArrayUtility.getLowestInColumnIndex(array, i);
			double highest = TwoDimRaggedArrayUtility.getHighestInColumn(array, i);
			double lowest = TwoDimRaggedArrayUtility.getLowestInColumn(array, i);
			
			//validate whether bonuses are correct: check whether highest sales are positive
			if(highest > 0)
				bonus[highIndex] += HIGH_BONUS;
			
			//check whether lowest sales are positive, different from highest sales
			if(lowest > 0 && highIndex!=lowIndex)
				bonus[lowIndex] += LOW_BONUS;
		
			//for stores that didn't get lowest or highest bonus but sold something, add 'other' bonus to their index
			for(int j = 0; j < array.length; j++)
			{
				if(j >= array[i].length || i == highIndex || i == lowIndex || array[i][j] < 1)
					continue;
				bonus[i] += OTHER_BONUS;
			}
		}
		return bonus;
	}
	
	public static double calculateTotalHolidayBonus(double[][] array)
	{
		//variables for total and bonus array
		double total = 0;
		double bonus[] = HolidayBonus.calculateHolidayBonus(array);
		
		//add each element in bonus to total
		for(int i = 0; i < bonus.length; i++)
		{
			total+= bonus[i];
		}
		return total;
	}
}
