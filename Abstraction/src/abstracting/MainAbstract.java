package abstracting;

//abstract can have main() without compiler error. 
//it is just like any other normal static method
abstract public class MainAbstract {

	abstract public void disp();
	
    static void fun(int i)
    {
    	
//        try {
//            System.out.println("inside try");
            if(i<0)
        		throw new NullPointerException("demo");
            // or u can uncomment these statements and print Caught inside null fun()
            // u can also print Caught in main by rethowing exception
//        }
//        catch (ArithmeticException e ) {
//           System.out.println("Caught inside arith fun().");
//            throw e;     // rethrowing the exception
//        }
//        catch (NullPointerException e) {
//            System.out.println("Caught inside null fun().");
//            //throw e;     // rethrowing the exception
//        }
    }

    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Shape rect = new Rectangle(2, 3, "Rectangle");
		rect.draw();
		
		//MainAbstract m  = new MainAbstract() ; // cant create instance
		MainAbstract m  = new MainAbstractImpl() ;
		m.disp();
		
        try {
            fun(-1);
        }
        catch (NullPointerException e) {
            System.out.println("Caught in main.");
        }

	}

}
