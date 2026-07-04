package synchronization;

public class SynchronizedBlock {

	void getLine(int n){ 
		
		System.out.println("thread name before is "+Thread.currentThread().getName());
		
		synchronized(this){ 
		//synchronized block
		   for(int i=1;i<=n;i++){ 
		        System.out.println("thread name is "+Thread.currentThread().getName()+" count is " + i);
		     try{  
		      Thread.sleep(500);  
		     }catch(Exception e){
		    	 System.out.println(e);
		     }  
		   }  
		 }  
		System.out.println("thread name after is "+Thread.currentThread().getName());
		}  

}
