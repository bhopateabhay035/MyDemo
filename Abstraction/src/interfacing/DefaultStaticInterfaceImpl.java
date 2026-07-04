package interfacing;

public class DefaultStaticInterfaceImpl implements DefaultStaticInterface{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DefaultStaticInterface d = new DefaultStaticInterfaceImpl();
		d.abstractMethod();
		d.defaultMethod();
		DefaultStaticInterface.staticMethod();
	}

	@Override
	public void abstractMethod() {
		
		System.out.println("abstract impl");
	}

}
