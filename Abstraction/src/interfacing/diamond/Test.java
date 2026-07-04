package interfacing.diamond;

public class Test implements A,B{

//two or more interface having same abstract method is not a problem in implementing class
//as anyway we have to provide our implementation to them
	@Override
	public void write() {
		System.out.println("wrinting in test");
	}

//but if we dont override duplicate default method than its a problem and will give compiler error
	//telling to override atleast from one interface
// hence we need to override it and add below code
	@Override
	public void disp() {
		// TODO Auto-generated method stub
		//A.super.disp();
		// or below
		B.super.disp();
		// or both
	}
	
	public void writeA() {
		System.out.println("wrinting A in test");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test t = new Test();
		t.disp();
		t.write();
		
		A a = new Test();
		a.writeA();
		// if writeA is overriden in implementing class it will execute that method 
		// else will execute the method of parent
	}

}
