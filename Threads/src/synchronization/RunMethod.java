package synchronization;

public class RunMethod extends Thread{
	
	UnsynchronizedMethod unsynchronizedMethod;
	SynchronizedMethod synchronizedMethod;
	SynchronizedBlock synchronizedBlock;
	
	//when running unsynchronizedMethod
	RunMethod(UnsynchronizedMethod unsynchronizedMethod) { 
    	this.unsynchronizedMethod = unsynchronizedMethod; 
   }
	
	//when running synchronizedMethod
	RunMethod(SynchronizedMethod synchronizedMethod) { 
    	this.synchronizedMethod = synchronizedMethod; 
   }
	
	//when running synchronizedMethod
	RunMethod(SynchronizedBlock synchronizedBlock) { 
	    this.synchronizedBlock = synchronizedBlock; 
	}
		
    public void run() { 
    	//unsynchronizedMethod.getLine();
    	//synchronizedMethod.getLine();
    	synchronizedBlock.getLine(3);
   }

}
