package comparable$comparator;

import java.util.ArrayList;
import java.util.Collections;

//if there are multiple sorting strategies 
//the result will be based on last Collections.sort(l...)

public class ComparableComparatorMains {
	 public static void main(String[] args) {
    ArrayList<ComparableComparator> l = new ArrayList<>();
    l.add(new ComparableComparator("ABC", 8.6, 1980));
    l.add(new ComparableComparator("XYZ", 8.8, 1977));
    l.add(new ComparableComparator("PQR", 8.4, 1983));

    // Sort movies using Comparator's compare method by year
    Collections.sort(l);
    
    // Sort movies using Comparator's compare method by rating
    Collections.sort(l,new ComparableComparator());
    
    
 // Sort movies in descending using Comparable's compareTo method by year
    //Collections.sort(l,Collections.reverseOrder());
    
    // Display the sorted list of movies
    System.out.println("Movies after sorting by year:");
    for (ComparableComparator m : l) {
        System.out.println(m.getName() + " " + m.getRating() + " " + m.getYear());
    }
}
}

