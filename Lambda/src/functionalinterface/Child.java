package functionalinterface;

@FunctionalInterface
public interface Child extends Parent{

	void display2();
	default void display() {
		
	}
}
