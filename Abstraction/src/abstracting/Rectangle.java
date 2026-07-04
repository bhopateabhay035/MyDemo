package abstracting;

class Rectangle extends Shape {
    // Dimensions of the rectangle
   int length, width;

   
   // Constructor to initialize the rectangle's dimensions and name
   Rectangle(int length, int width, String name) {
       super(name); // if parent constructor not invoked will give compiler error bcoz 
       // since implicit super constructor Shape()is undefined , we need to explicitly invoke another constructor
       this.length = length;
       this.width = width;
       System.out.println("Rectangle constructor ");
   }

   // Implementation of draw method for rectangle
  // @Override 
   public void draw() {
       System.out.println("Rectangle has been drawn ");
   }

   // Implementation of area method for rectangle
   @Override 
   protected double area() {
       return length * width;
   }
   
// overriding shape method to move the shape to a new position
   public void moveTo(int x, int y) {
       System.out.println("move method overriden in rect "+objectName + " has been moved to x = " + x + " and y = " + y);
   }
}
