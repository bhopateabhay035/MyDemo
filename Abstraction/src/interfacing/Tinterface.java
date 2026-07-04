package interfacing;

//class extending abstract class which inturns imlement or maynot implement interface methods
public interface Tinterface {

	public abstract void disp();
	
	//public abstract is default, not necesarry to write
	 void add();
	
	static void big() {
		System.out.println("interface static");
	}
	 default void small() {
		 System.out.println("small inter");
	 }
}
