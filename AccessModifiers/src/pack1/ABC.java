package pack1;

// the class can only be default, public, abstract or final
// it cannot be protected or private else gives compiler error
 public class ABC {
	// private String ice; not visible to child even in same package
	 protected String ice;
	 
//	   if child class tries to inherit parent having private constructor 
// it will show compiler error as in child as parent contructor gets implicitly 
	 //called using super() during child object creation 
//	    private ABC()
//	 {
//	        //First Constructor
//	    }
//	 
	 // if private than will show compiler error in child constructor as it gets implicitly called
   protected  ABC()  // can be default , public, protected
    {
	   System.out.println("abc constructor");
	}
     
   protected ABC(String i)
    {
        this.ice = i;
        System.out.println("abc constructor "+i);
    }
     
    // parent's private method can be overriden without @Override annotation in child but it cannot be called in 
     //child using parent object as it will be invisible in child
     // with @Override private method of parent cannot be overridden as public method in child
      void disp() {
    	 System.out.println("in parent");
     }

      protected void extra() {
    	 System.out.println("abc extra");
     }
     
     private void privacy() {
	   	 System.out.println("in parent privacy");
	    }
     
     public void parentaxis() {
 		System.out.println("parent axis");
 	}
}
