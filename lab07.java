import java.util.*;
import java.io.*;
public class Lab07
{
	public static void main(String [] args) throws IOException
	{
		MovieDB movies = new MovieDB(10); // Create MovieDB object.  The
					// size is set at 10, meaning it can hold up to 10
					// movies.  If we wanted (as discussed in lecture) we
					// could allow for it to be resized so it could hold
					// an arbitrary number of movies.
		loadData(movies);		// input movie data from file
		getCommands(movies);	// interact with user 
		saveData(movies);		// save movie data back to file
	}

	public static void loadData(MovieDB movies) throws IOException
	{
		// Note the syntax below for creating a Scanner to a file
		Scanner S = new Scanner(new FileInputStream("movieFile.txt"));
	
		
		
	       int numMovies;

	       try (BufferedReader br = new BufferedReader(new FileReader("movieFile.txt"))) {
	       String title = new String();
	       String director = new String();
	       String studio = new String();
	       double gross;
	       numMovies = Integer.parseInt(S.nextLine());
	      MovieDB movieDB = new MovieDB(numMovies);
	          for(int i=0; i<numMovies; i++){
	           title = S.nextLine();
	           director = S.nextLine();
	           studio = S.nextLine();
	           gross = Double.parseDouble(S.nextLine());
	           Movie movie = new Movie(title, director, studio, gross);
	           movies.addMovie(movie);
	       }
	       }
	}

	public static void getCommands(MovieDB movies)
	{
		Scanner inScan = new Scanner(System.in);
		System.out.println("Enter your choice:");
		System.out.println("1. List movies");
		System.out.println("2. Add new movie");
		System.out.println("3. Find movie");
		System.out.println("4. Quit");
		String choice = inScan.nextLine();
		while (true)
		{
			Movie temp;
			if (choice.equals("1"))
			{
				System.out.println(movies.toString());
			}
			else if (choice.equals("2"))
			{
				System.out.println("Movie name?");
	               String title = inScan.nextLine();
	               System.out.println("Director?");
	               String director = inScan.nextLine();
	               System.out.println("Studio?");
	               String studio = inScan.nextLine();
	               System.out.println("Gross?");
	               Double gross = Double.parseDouble(inScan.nextLine());
	               temp = new Movie(title, director, studio, gross);
	               movies.addMovie(temp);
			}
			else if (choice.equals("3"))
			{
				System.out.println("Movie name?");
	               String title = inScan.nextLine();
	               temp = movies.findMovie(title);
	               if (temp==null){
	                   System.out.println("The movie " + title+" was not found.");
	               }
	               else{
	                   System.out.println(temp.toString());
	               }
	           
			}
			else
			{
				System.out.println("Good-bye");
				break;  // any other value -- quit
			}
			System.out.println("Enter your choice:");
			System.out.println("1. List movies");
			System.out.println("2. Add new movie");
			System.out.println("3. Find movie");
			System.out.println("4. Quit");
			choice = inScan.nextLine();
		}
	}

	public static void saveData(MovieDB movies) throws IOException
	{
		PrintWriter P = new PrintWriter("movieFile.txt");
		// Note that we are printing the entire DB to the file with
		// one statement.  This is because the toStringFile() method
		// of the MovieDB class calls the toStringFile() method of
		// each Movie within the DB.
		P.print(movies.toStringFile());
		P.close();
	}
}