package abstracting;

public class Circle extends Shape {
    // Value of pi for circle area calculation
    double pi = 3.14; 
    // Radius of the circle
    int radius; 

    // Constructor to initialize the circle's radius and name
    Circle(int radius, String name) {
        super(name); // since implicit super constructor Shape()is undefined , we need to explicitly invoke another constructor
        this.radius = radius;
    }

    // Implementation of draw method for circle
    @Override 
    public void draw() {
        System.out.println("Circle has been drawn ");
    }

    // Implementation of area method for circle
    @Override 
    public double area() {
        return (double)(pi * radius * radius);
    }
}
