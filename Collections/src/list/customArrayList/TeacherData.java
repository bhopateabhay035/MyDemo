package list.customArrayList;

import java.util.ArrayList;

public class TeacherData {

	// Declare an ArrayList method of generic type Student. 
	   ArrayList<Teacher> addData()
	   { 
	  // Create two objects s1 and s2 of the student class and initialize the value of variables using reference variable s1 and s2. 
		 Teacher s1 = new Teacher(); 
	     s1.name = "Shubh"; 
	     s1.phyMarks = 95; 
	     s1.mathsMarks = 100; 
	     s1.chemMarks = 90; 
	     s1.total = 95 + 100 + 90; 
	     s1.per = ((s1.total)*100)/300; 

	     Teacher s2 = new Teacher(); 
	     s2.name = "Deep"; 
	     s2.phyMarks = 80; 
	     s2.mathsMarks = 85; 
	     s2.chemMarks = 90; 
	     s2.total = 80 + 85 + 90; 
	     s2.per = ((s2.total)*100)/300; 

	  // Create an ArrayList object of generic type Student. 
	     ArrayList<Teacher> al = new ArrayList<Teacher>(); 

	  // Call add() method to store student class objects in the array list using reference variable al. 
	     al.add(s1); 
	     al.add(s2); 
	     return al; 
	  } 
}
