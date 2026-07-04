package interfacing;

public class Timplement extends Tabstract {

	@Override
	public void disp() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void test() {
		// TODO Auto-generated method stub
		
	}
	
	// cannot override static with @Override annotation, gives error
//	@Override
//	static void game() {
//		System.out.println("implement static");
//	}
	
	// can do override without @Override
	static void game() {
		System.out.println("implement static");
	}
	 void gamechange() {
		System.out.println("implement non static");
	}
	 public void small() {
			System.out.println("implement default");
	}
	public static void main(String[] args) {
		Tabstract t = new Timplement();
		
		t.game(); //static methodcant be overriden hence method in the derived class gets hidden by the method in the base class
		t.gamechange(); //method in the derived class printed
		//runtime polymorphism for by method overriding works for non static but static dont get override though no compiler error
		
		// using class name we can call specific static methods
		Timplement.game();
		Tabstract.game();
		
		Tinterface.big();
		t.big();
		t.small();
	}
}
