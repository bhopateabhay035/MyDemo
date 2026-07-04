package interfacing;

public class Geeks {
	
	//method overloading achieved by differing in the type or number of parameters and order of parameters
	//You cannot overload a method by changing only its return type or access modifier.
	public int add() {
		int i = 0;
		return i;
	}
	
	public void add(int m, int n) {
		
	}
	
	//public void add(int n, int m) { just shuffling variable of same type is not overloading and will give error
	public void add(int n, double m) {	
		
	}
	public void add(double m, int n) {	
		
	}
	public double add(double m) {
		
		return m;
	}
	
	public static void main(String[] args) {
        // Create a Circle object
		//Circle circle = new Circle(2);
		//or create specific object
		Drawable circle1 = new Circle(2);
		Movable circle2 = new Circle(2);
        
        // Call the draw method
        circle1.draw();
        
        // Call the moveTo method
        circle2.moveTo(2, 4);
    }

}
