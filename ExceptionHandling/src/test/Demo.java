package test;

public class Demo {

	public void calculate(int m,int n) {
		int a = 0 ;
	
		try {
			a = m/n;
		}
		catch(NullPointerException e) {
			e.printStackTrace();
			System.out.println("value null");
		}
		catch(ArithmeticException e) {
			//e.printStackTrace();
			System.out.println("cannot divide by zero getMessage "+e.getMessage());
		}
		finally {
			System.out.println("value after division "+a);
		}
	}
	
	public void total(int m,int n) {
		int a = 0 ;
		a = m+n;
		System.out.println("value after adding "+a);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Demo d = new Demo();
		d.calculate(10, 0);
		d.total(10, 0);
	}

}
