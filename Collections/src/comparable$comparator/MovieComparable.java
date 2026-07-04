package comparable$comparator;

import java.util.Comparator;

public class MovieComparable implements Comparable<MovieComparable> 
{
    private String name; 
    private double rating;
    private int year; 

    public MovieComparable(String name, double rating, int year) {
        this.name = name;
        this.rating = rating;
        this.year = year;
    }

    // Implementation of the compareTo method for default sorting by rating
    public int compareTo(MovieComparable m) {
                //return this.year - m.year; 
                //OR
               //return Double.compare(this.rating, m.rating);
                //OR for string comparison use compareTo
                return this.name.compareTo(m.name);
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

}
