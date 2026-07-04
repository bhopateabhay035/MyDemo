package comparable$comparator;

import java.util.Comparator;

public class MovieComparator implements Comparator<MovieComparator> {
    private String name; 
    private double rating;
    private int year; 

    public MovieComparator(String name, double rating, int year) {
        this.name = name;
        this.rating = rating;
        this.year = year;
    }

    public MovieComparator() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
        return name;
    }
    public double getRating() {
        return rating;
    }
    public int getYear() {
        return year;
    }

	@Override
	public int compare(MovieComparator o1, MovieComparator o2) {
		return Double.compare(o1.getRating(), o2.getRating());
	}

	


}
