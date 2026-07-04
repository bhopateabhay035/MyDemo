package interfacing;

public class Circle implements Drawable, Movable {
    double pi = 3.14; // Value of Pi for circle calculations
    int radius; // Radius of the circle

    // Constructor to initialize the radius of the circle
    Circle(int radius) {
        this.radius = radius;
    }

    // Implementation of the draw method from Drawable interface
    @Override 
    public void draw() {
        System.out.println("Circle has been drawn ");
    }

    // Implementation of the moveTo method from Movable interface
    @Override 
    public void moveTo(int x, int y) {
        System.out.println("Circle has been moved to x = " + x + " and y = " + y);
    }


}
