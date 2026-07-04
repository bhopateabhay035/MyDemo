package test;

public class Custom {

	public static int a;

	public int calculate(int m,int n) 
	// throws CustomEx need when its checked exception
	{
	
		if(n==0)
				 throw new CustomEx("div cant be zero");
		a = m/n;
		
		System.out.println("value after division "+a);
		return a;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Custom d = new Custom();
		try {
			a = d.calculate(10, 0);
		}
		catch(CustomEx e) {
			//e.printStackTrace();
			System.out.println("cannot divide by zero getMessage "+e.getMessage());
		}
		finally {
			System.out.println("value after division "+a);
		}
	}

}
