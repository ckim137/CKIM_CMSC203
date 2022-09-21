import java.util.Scanner;

public class MovieDriver_Task2 {

	public static void main(String[] args) {
		//initializing variables, scanner, and movie object
		Movie movie1 = new Movie();
		String title = "";
		String rating = "";
		String movieInfo = "";
		int soldTickets = 0;
		char playAgain = 'y';
		Scanner sc = new Scanner(System.in);
		
		do
		{
		//getting inputs and reading them into movie1 object
		System.out.println("Enter the name of a movie");
		title = sc.nextLine();
		movie1.setTitle(title);
		
		System.out.println("Enter the rating of a movie");
		rating = sc.nextLine();
		movie1.setRating(rating);
		
		System.out.println("Enter the number of tickets sold for this movie");
		soldTickets = sc.nextInt();
		movie1.setSoldTickets(soldTickets);
		
		//reading all movie info into movieInfo variable, then displaying it
		movieInfo = movie1.toString();
		System.out.println(movieInfo);
		
		//asking whether user wants to play again
		System.out.println("Do you want to enter another? (y or n)");
		playAgain = sc.next().charAt(0);
		sc.nextLine();
		playAgain = Character.toLowerCase(playAgain);
		}while(playAgain == 'y'); //repeat until user doesn't want to enter any more movies
		
		System.out.println("Goodbye! "); //print goodbye message when user is done
		sc.close();
		

	}
}


