package comparable$comparator;

import java.util.ArrayList;
import java.util.Collections;

public class MainsComparable {
    public static void main(String[] args) {
        
        ArrayList<MovieComparable> l = new ArrayList<>();
        l.add(new MovieComparable("Star Wars", 8.7, 1977));
        l.add(new MovieComparable("Empire Strikes Back", 8.8, 1980));
        l.add(new MovieComparable("Return of the Jedi", 8.4, 1983));

        // Sort movies using Comparable's compareTo method by year
        Collections.sort(l);
        l.sort(null);
        
     // Sort movies in descending using Comparable's compareTo method by year
        Collections.sort(l,Collections.reverseOrder());
        
        // Display the sorted list of movies
        System.out.println("Movies after sorting by year:");
        for (MovieComparable m : l) {
            System.out.println(m.getName() + " " + m.getRating() + " " + m.getYear());
        }
    }

}
