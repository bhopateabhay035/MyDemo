package comparable$comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class AndThenExample {

    public static void main(String[] args) {
        
        ArrayList<MovieComparator> l = new ArrayList<>();
        l.add(new MovieComparator("ABC", 8.6, 1980));
        l.add(new MovieComparator("XYZ", 8.8, 1977));
        l.add(new MovieComparator("PQR", 8.4, 1983));

        
        // Sort movies by year and then rating
        Comparator<MovieComparator> yr = Comparator.comparing(MovieComparator::getYear);
        Comparator<MovieComparator> rate = Comparator.comparing(MovieComparator::getRating);
        Collections.sort(l,yr.thenComparing(rate));
    
        System.out.println("Movies after sorting by year and then rating: "+l);
        
      
        for (MovieComparator m : l) {
            System.out.println(m.getName() + " " + m.getRating() + " " + m.getYear());
        }
    }

}
