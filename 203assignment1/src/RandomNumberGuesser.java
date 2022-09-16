/*
 * Class: CMSC203 
 * Instructor: Kujit
 * Description: (Give a brief description for each Class)
 * Due: 09/19/2022
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Charles Kim
*/

import java.util.Scanner;
public class RandomNumberGuesser {
  public static void main(String[] args) {
	  
    //variables
    Scanner sc = new Scanner(System.in);
    int randNum = 0, numGuesses = 0, guess = 0, lowGuess = 0, highGuess = 101;
    char tryAgain = 'y';

    //welcome message
    System.out.println("This application generates a random integer between 1 and 100 asks the user to guess repeatedly until they guess correctly.");

    do
    {
      //setting count to 0 and random number, other variables
      RNG.resetCount();
      numGuesses = RNG.getCount();
      randNum = RNG.rand();
      lowGuess = 0;
      highGuess = 101;
      do
      {
        //getting input for first guess
        if(numGuesses == 0)
        {
          do
          {
            System.out.println("Enter your first guess: ");
            guess = sc.nextInt();
          }while(!RNG.inputValidation(guess, lowGuess, highGuess));
        }
        //getting input for every guess after first guess
        else 
        {
          do
          {
            System.out.println("Enter your next guess between " +       
                                lowGuess + " and " + highGuess + "(exclusive)");
            guess = sc.nextInt();
          }while(!RNG.inputValidation(guess, lowGuess, highGuess));
        }
        
        //printing congratulatory message if guess is correct
        if(guess == randNum)
        {
          System.out.println("Congratulations, you guessed correctly.");
          numGuesses = 7;
        }
          
        //setting variables if guess is low
        else if(guess < randNum)
        {
          System.out.println("Your guess is too low");
          lowGuess = guess;
        }

        //setting variables if guess is high
        else 
        {
          System.out.println("Your guess is too high");
          highGuess = guess;
        }
        
        //getting current # of guesses if guess is incorrect
        if(guess != randNum)
        	numGuesses = RNG.getCount();
        
      }while (numGuesses < 7); //stop when # of guesses exceeds 7
      
      //congratulatory message if guess was correct, ask to play again
      if(guess == randNum)
    	  System.out.println("Try again? y/n ");
      
      //disappointed message if guess was incorrect, ask to play again
      else
    	  System.out.println("You have exceeded the maximum number of guesses, 7. Play again? y/n");
      tryAgain = sc.next().charAt(0);  //getting input to play again
      tryAgain = Character.toLowerCase(tryAgain);
      
    }while (tryAgain == 'y');

    sc.close();
  }
}