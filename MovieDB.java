public class MovieDB
{
	
	private Movie [] theMovies;
	private int numMovies;

	// Initialize this MovieDB
	public MovieDB(int size)
	{
		theMovies = new Movie[size];
		numMovies = 0;
	}

	
	public void addMovie(Movie m)
	{
		if (numMovies < theMovies.length)
		{
			theMovies[numMovies] = m;
			numMovies++;
		}
		else
			System.out.println("No room to add movie");
			
	}


	public Movie findMovie(String title)
	{
		for (int i = 0; i < numMovies; i++)
		{
			if (theMovies[i].getTitle().equals(title))
				return theMovies[i];
		}
		return null;
	}

	
	public String toString()
	{
		StringBuffer B = new StringBuffer();
		B.append("Movie List: \n\n");
		for (int i = 0; i < numMovies; i++)
			B.append(theMovies[i].toString() + "\n");
		return B.toString();
	}

	
	public String toStringFile()
	{
		StringBuffer B = new StringBuffer();
		B.append(numMovies + "\n");
		for (int i = 0; i < numMovies; i++)
			B.append(theMovies[i].toStringFile());
		return B.toString();
	}

}