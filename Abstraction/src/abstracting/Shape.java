package abstracting;

import interfacing.I1;

//abstract class cannot be final in Java. Making them final will stop the abstract class from being extended.

abstract public class Shape // implements I1
{

	// Name of the shape
    String objectName = " "; 

//since we are not defining this implicit/default Shape constructor here
//    Shape(){
//    	
//    }  
    // the below constructor should be explicitly invoke in child class constructor
    
    // Constructor to initialize the name of the shape
    Shape(String objectName) {
        this.objectName = objectName;
        System.out.println("Shape constructor ");
    }

    // Concrete method to move the shape to a new position
    public void moveTo(int x, int y) {  //can be protected or private but for private it will give error in main class if child object is created with reference of abstarct class
        System.out.println(objectName + " has been moved to x = " + x + " and y = " + y);
    }
    
 // abstract class can have static methods but with implementation
    public static void staticM(int x, int y) {
       // System.out.println("name is "+objectName);// cannot make nonstatic reference from static method
    	System.out.println("inside static method x = " + x + " and y = " + y);
    }

    // Abstract method to calculate the area of the shape
    protected abstract  double area(); // it cant be private only public or protected

    // Abstract method to draw the shape
    abstract public void draw();

}
