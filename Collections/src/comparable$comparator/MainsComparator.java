package comparable$comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


//if there are multiple sorting strategies the result will be based on last Collections.sort(l,...)
public class MainsComparator {
    public static void main(String[] args) {
        
        ArrayList<MovieComparator> l = new ArrayList<>();
        l.add(new MovieComparator("ABC", 8.6, 1980));
        l.add(new MovieComparator("XYZ", 8.8, 1977));
        l.add(new MovieComparator("PQR", 8.4, 1983));

        // Sort movies using Comparator's compare method by rating
        Collections.sort(l,new MovieComparator());
        
        // Sort movies using Comparator's compare method by name
        Collections.sort(l,new MovieComparatorByName());
        
     // Sort movies using Comparator's compare method by year
     // or using anonymous inner class//////////////////////
        Collections.sort(l,new MovieComparator(){

    		@Override
    		public int compare(MovieComparator o1, MovieComparator o2) {
    			return Integer.compare(o1.getYear(), o2.getYear());
    		}
    	});
        //or
        Comparator<MovieComparator> yr = new MovieComparator(){

    		@Override
    		public int compare(MovieComparator o1, MovieComparator o2) {
    			return Integer.compare(o1.getYear(), o2.getYear());
    		}
    	};
    	Collections.sort(l,yr);  //or
    	l.sort(yr);
       //////////////////////////////////////////////////////
     // Sort movies in descending using Comparable's compareTo method by year
        Collections.sort(l,Collections.reverseOrder()); /// cannot reverse with comparator
        Collections.sort(l,yr.reversed());   /// need to use reversed
       //l.sort((m,n) -> Integer.compare(m.getYear(), n.getYear()).reversed());
        l.sort((m,n) -> Integer.compare(n.getYear(), m.getYear()));

        
        // Display the sorted list of movies
        System.out.println("Movies after sorting by year:");
        for (MovieComparator m : l) {
            System.out.println(m.getName() + " " + m.getRating() + " " + m.getYear());
        }
        
        Comparator<MovieComparator> rate = Comparator.comparing(MovieComparator::getRating);
        Collections.sort(l,yr.thenComparing(rate));
        System.out.println("sorting by year and then by rate:");
        for (MovieComparator m : l) {
            System.out.println(m.getName() + " " + m.getRating() + " " + m.getYear());
        }
    }
}
