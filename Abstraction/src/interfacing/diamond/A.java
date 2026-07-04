package interfacing.diamond;

@FunctionalInterface
public interface A {

	void write();
	
	default void writeA() {
		System.out.println("wrinting A");
	} 
	
	default void disp() {
		System.out.println("in A");
	}
}
