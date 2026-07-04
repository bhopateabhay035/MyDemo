package comparable$comparator;

import java.util.Comparator;

//class can implement both Comparable Comparator interface without any compile time or runtime issue
// but its not good practice 
public class ComparableComparator implements Comparator<ComparableComparator>, Comparable<ComparableComparator>{
    private String name; 
    private double rating;
    private int year; 

    public ComparableComparator(String name, double rating, int year) {
        this.name = name;
        this.rating = rating;
        this.year = year;
    }

    public ComparableComparator() {
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

  //Comparable imlementation
  	@Override
  	public int compareTo(ComparableComparator o) {
  		return Integer.compare(this.getYear(), o.getYear());
  	}
  	
    //Comparator implementations
    @Override
	public int compare(ComparableComparator o1, ComparableComparator o2) {
		return Double.compare(o1.getRating(), o2.getRating());
	}
}
