package interfacing;

abstract public class Tabstract implements Tinterface{

	abstract protected void test();
	
	static void game() {
		System.out.println("in static");
	}
	void gamechange() {
		System.out.println("in non static");
	}
	@Override
	public void add() {
		// TODO Auto-generated method stub
		
	}

	static void big() {
		System.out.println("in inter abstract static");
	}
	
	//@Override
	public void small() {
		System.out.println("in abstract default");
	}
}
