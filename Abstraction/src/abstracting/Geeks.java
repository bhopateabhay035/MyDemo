package abstracting;

public class Geeks {
	
    public static void main(String[] args) {
    	
    	// Shape s = new Shape(); //we cannot instantiated it directly i.e. we cannot create an object directly from an abstract class
    	
    	//Shape rect1 = new Rectangle(); error as default/implicit constructor is not defined
        Shape rect = new Rectangle(2, 3, "Rectangle");  // as We cannot directly create object from abstract class
        System.out.println("Area of rectangle: " + rect.area());
        rect.moveTo(1, 2);
        //rect.staticM(1, 0);
        //or
        Shape.staticM(1, 0);
        rect.draw();
        
        System.out.println();

        // Creating a Circle object and demonstrating its behavior
        Shape circle = new Circle(2, "Circle"); // as We cannot directly create object from abstract class
        System.out.println("Area of circle: " + circle.area());
        circle.moveTo(2, 4);
    }


}
