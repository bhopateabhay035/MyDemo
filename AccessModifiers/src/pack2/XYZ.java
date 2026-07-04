package pack2;

import pack1.ABC;

public class XYZ extends ABC{
	
	void axis() {
		System.out.println("xyz axis");
	}

	public void parentaxis() {
 		System.out.println("child axis");
 	}
	
	private XYZ(){
		super(); // can call parent protected constructor using super
		System.out.println("xyz constructor");
	}
	private XYZ(String i){
		super(i); // can call parent protected constructor using super
		System.out.println("xyz parameter constructor "+i);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		XYZ x1 = new XYZ() ; //is allowed
		XYZ x = new XYZ("hi") ; 
		x.ice = "xice"; // if public or protected in parent then visible here
		x.extra();// alowed using child object
		x.axis();
		
		//we can call parent protected constructor using super as shown above
		ABC y = new XYZ("hi") ; 
		//y.axis();// will give compiler error as axis() is missing in parent
		y.parentaxis(); //if parentaxis() missing in child it will print parent method
		
		//parent class protected data members and methods not visible in child 
		//if we create child object referencing parent
		//y.ice = "xice"; // not visible as we are creating child object referencing parent
		//y.extra(); // not visible as we are creating child object referencing parent
		
		//For parent class protected constructor to be accessed
		//If the child and parent classes are in the same package, you can create a new parent instance 
		//using new keyword within the child class 
		//but if the classes are in different packages it will result in a compilation error
		// ABC z = new ABC() ;// ABC protected constructor not visible in other package
		
	}

}
