package test;

public class ThrowsEx {

	public static int a;

	public int calculate(int m,int n) throws ArithmeticException{
	
		a = m/n;
		
		System.out.println("value after division "+a);
		return a;
		
	}
	
	public static void main(String[] args) 
	//		throws ArithmeticException
	//JRE will catch and throw exception
	// but its not good practice,instead we should handle exception using try catch
	{
		// TODO Auto-generated method stub
		ThrowsEx d = new ThrowsEx();
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
