package comparable$comparator;

import java.util.Comparator;

public class MovieComparatorByName implements Comparator<MovieComparator>{

	@Override
	public int compare(MovieComparator o1, MovieComparator o2) {
		// TODO Auto-generated method stub
		return o1.getName().compareTo(o2.getName());
	}
}
