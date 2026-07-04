package basic;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

//From a list of students, find the top 3 by score.
//From a list of students, find the top 3 by name.

public class StudentExample {

	String name;
    int score;
    
    StudentExample(String name, int score) { 
    	this.name = name; 
    	this.score = score; 
    	}
    
    
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getScore() {
		return score;
	}


	public void setScore(int score) {
		this.score = score;
	}


	@Override
	public String toString() {
		return "StudentExample [name=" + name + ", score=" + score + "]";
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<StudentExample> students = Arrays.asList(
			    new StudentExample("Alice", 85),
			    new StudentExample("Bob", 92),
			    new StudentExample("Charlie", 88),
			    new StudentExample("Dave", 78),
			    new StudentExample("Eve", 91)
			);

		//find the top 3 by score.
			List<StudentExample> topStudents = students.stream()
			    //.sorted(Comparator.comparingInt((StudentExample s) -> s.getScore()).reversed())
			    //or
			    .sorted((m,n) -> Integer.compare(n.getScore(), m.getScore()))
			    //.map(s -> s.getName()) //since List<StudentExample> is used than no need of this map
			    .limit(3)
			    .collect(Collectors.toList());
			
			System.out.println("List of top 3 student object based on score "+topStudents); // Output: [Bob, Eve, Charlie]
			
			List<String> topStudents1 = students.stream()
				    .sorted((m,n) -> m.getName().compareTo(n.getName()))
				    .map(s -> s.getName())
				    .limit(3)
				    .collect(Collectors.toList());
				
				System.out.println("List of top 3 student based on name "+topStudents1);
	}

	
}
