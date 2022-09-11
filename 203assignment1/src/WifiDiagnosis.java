/*  Class: CMSC203 CRN 22889
 Program: Assignment #1
 Instructor: Kujit
 Summary of Description: 
 Due Date: 9/9/2022
 Integrity Pledge: I pledge that I have completed the programming assignment independently.
 I have not copied the code from a student or any source.
Charles Kim */
import java.util.Scanner;

public class WifiDiagnosis {

	public static void main(String[] args) {
		//initializing scanner, list of questions, and string to check whether user inputted yes or no
		Scanner sc = new Scanner(System.in);
		String check = "NO";
		String questionsList[] = {"Reboot the computer and try to connect", "Reboot the computer and try to connect", 
				"Make sure the cables connecting the router are firmly plugged in and power is getting to the router",
				"Move the computer closer to the router and try again", "Contact your ISP. "};
		final int QUESTIONS_SIZE = 5;
		
		System.out.println("If you have a problem with internet connectivity, this WiFi diagnosis might work. \n");
		
		//For each suggestion in the list, print the suggestion and ask the user whether it worked
		for (int i = 0; i < QUESTIONS_SIZE; i++)
		{
			System.out.println(questionsList[i]); //printing suggestion, asking user whether it worked
			System.out.println("Did that fix the problem? YES/NO"); 
			check = sc.next();
			check = check.toUpperCase(); //reading input, setting input to all caps
			
			//checking whether input is YES, NO, or INVALID
			if(check.equals("YES"))
			{
				i = QUESTIONS_SIZE;
				System.out.println("Done"); //if suggestion works, stops the loop and prints "done"
			}
			
			else if(!check.equals("NO"))
			{
				i = QUESTIONS_SIZE;
				System.out.println("Invalid Input; try again. ");
			}
		}
		sc.close();
		System.out.println("Programmer: Charles Kim");
		
	}

}
