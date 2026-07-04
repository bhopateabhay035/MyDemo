package list.customArrayList;

import java.util.ArrayList;

public class TeacherRetrive {

	// Declare an instance method. 
	   void fetchStudentData()
	   { 
	   // Create an object of the Studentdata class. 
		   TeacherData stdata = new TeacherData(); 

	   // Call addData() method using reference variable stdata. 
	      ArrayList<Teacher> listst = stdata.addData(); 

	   // Now iterate and display all the student data. 
	   // enhance for loop - for each loop. 
	      for(Teacher student:listst)
	      { 
	        System.out.println("Name: " +student.name); 
	        System.out.println("Physics Marks: " +student.phyMarks); 
	        System.out.println("Maths Marks: " +student.mathsMarks); 
	     
	        System.out.println("Chemistry Marks: " +student.chemMarks); 
	        System.out.println("Total Marks: " +student.total); 
	        System.out.println("Percentage:" +student.per); 
	      } 
	   } 
}
