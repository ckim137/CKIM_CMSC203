import java.util.Scanner;

public class MovieDriver_Task1 {

	public static void main(String[] args) {
		//initializing variables, scanner, and movie object
		Movie movie1 = new Movie();
		String title = "";
		String rating = "";
		String movieInfo = "";
		int soldTickets = 0;
		Scanner sc = new Scanner(System.in);
		

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
	
		System.out.println("Goodbye! "); //print goodbye message when user is done
		sc.close();
		

	}
}


