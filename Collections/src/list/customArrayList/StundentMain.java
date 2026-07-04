package list.customArrayList;

import java.util.ArrayList;

public class StundentMain {

	public static void main(String[] args) 
	{ 
	// Call AddingData class by creating an object of that class. 
	   AddingData data = new AddingData(); 

	// Call studentData() method using reference variable data. 
	   ArrayList<Student> listst = data.studentData(); 

	// Now iterate and display all the Student data. 
	   for(Student st:listst)
	   { 
	     System.out.println("Student's name: " +st.name); 
	     System.out.println("Student ID " +st.id); 
	     System.out.println("Roll number: " +st.rollNo); 
	   } 
	  } 
}
