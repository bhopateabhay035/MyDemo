package list.customArrayList;

import java.util.ArrayList;

public class Employee {
	 int eNo; 
	  String name, address; 
	  Employee(int eNo, String name, String address)
	  { 
	     this.eNo = eNo; 
	     this.name = name; 
	     this.address = address; 
	  } 
	  public Employee() 
	  { 

	  } 
	// Display all employees data. 
	   void displayData(ArrayList<Employee> list)
	   { 
	     System.out.println("Employee Detail"); 
	     for(Employee emp: list )
	     { 
	       System.out.println("Employee number: " +emp.eNo); 
	       System.out.println("Employee Name: " +emp.name); 
	       System.out.println("Employee Address: " +emp.address); 
	     } 
	    } 
}
