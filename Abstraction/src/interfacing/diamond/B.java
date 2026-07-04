package interfacing.diamond;

@FunctionalInterface
public interface B extends A{

	void write();
	
	default void writeB() {
		System.out.println("wrinting B");
	} 
	
	default void disp() {
		System.out.println("in B");
	}
}
