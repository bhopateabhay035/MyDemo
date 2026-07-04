package interthreadcomm;

public class JoinDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Runnable r1 = () -> System.out.println("Thread 1 finished");
		Thread t1 = new Thread(r1);
		//or
	    //Thread t1 = new Thread(() -> System.out.println("Thread 1 finished"));
		
		//Runnable r2 = () -> System.out.println("Thread 3 finished");
		Thread t3 = new Thread(() -> {
	        try {
	            Thread.sleep(5000);
	            System.out.println("Thread 3 finished");
	        } catch (InterruptedException e) {
	            // Handle interruption
	        }
	    });
			
		//similarly create other thread and join to 1st thread
	    Thread t2 = new Thread(() -> {
	        try {
	            t1.join(); // t2 waits for t1 to finish
	            System.out.println("Thread 2 finished after Thread 1");
	        } catch (InterruptedException e) {
	            // Handle interruption
	        }
	    });
	    
	   
		
	    t2.start();
	    t1.start();
	    t3.start();
	}

}
