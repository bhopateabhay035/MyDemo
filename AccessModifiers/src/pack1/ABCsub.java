package pack1;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ABCsub extends ABC{
	public void disp() {
   	 System.out.println("in child");
    }
	
	private void privacy() {
	   	 System.out.println("in child privacy");
	    }
	
	 void another() {
	   	 System.out.println("another in child");
	    }
	 
	 protected void extra() {
    	 System.out.println("abcsub extra");
     }
	
	public static void main(String[] args) {
	ABCsub a = new ABCsub();
	a.ice ="aice";
	a.disp();
	a.another();
	a.extra();
	a.privacy();
	
	
	ABC c = new ABCsub();
	c.ice = "cice";
	//c.privacy(); //not visible for this kind of reference
	//c.another();  // will give compiler error as another() is missing in parent
	c.extra();
			
	//For parent class protected constructor to be accessed
    //If the child and parent classes are in the same package, you can create a new parent instance 
	//using new keyword within the child class 
	//but if the classes are in different packages it will result in a compilation error
	ABC b = new ABC() ; 
	b.ice = "bice";
	//b.privacy(); //will not be visible from child
	b.disp();
	b.extra();
	}
}
