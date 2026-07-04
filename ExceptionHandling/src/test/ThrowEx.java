package test;

public class ThrowEx {
	public static int a;

	public int calculate(int m,int n){
	
		if(n==0)
				 throw new ArithmeticException("div cant be zero");
		a = m/n;
		
		System.out.println("value after division "+a);
		return a;
		
	}
	
	public static void main(String[] args) 
	// weneed to catch and handle the throw exception else jre will catch throw exception
	// which user will not understand
	{
		// TODO Auto-generated method stub
		ThrowEx d = new ThrowEx();
		try {
			a = d.calculate(10, 0);
		}
		catch(ArithmeticException e) {
			//e.printStackTrace();
			System.out.println("cannot divide by zero getMessage "+e.getMessage());
		}
		finally {
			System.out.println("value after division "+a);
		}
	}
}
