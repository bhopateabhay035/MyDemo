package interfacing;

public interface DefaultStaticInterface {

    // Abstract method (implicitly public abstract)
    void abstractMethod();
    
    // Default method (Java 8)
    public default void defaultMethod() {
        System.out.println("Default implementation.");
        privateHelper(); // Can call private methods
        privateStaticHelper(); // Can call private static methods
    }
    
    // Static method (Java 8)
    public static void staticMethod() {
        System.out.println("Utility method belonging to the interface.");
        privateStaticHelper(); // Can call private static methods
        //privateHelper(); // but cannot call private method from static method
    }
    
    // Private method (Java 9) - used by default methods
    private void privateHelper() {
        System.out.println("Helper method for internal use.");
        //Can call both default and private static methods
        //defaultMethod();
        //privateStaticHelper();
    }
    
    // Private static method (Java 9) - used by static or default methods
    private static void privateStaticHelper() {
        System.out.println("Static helper for internal use.");
    }

}
