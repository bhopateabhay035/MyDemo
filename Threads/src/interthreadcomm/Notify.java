package interthreadcomm;

public class Notify extends Thread {
	Wait1 wait1;
	
	Notify(Wait1 wait1){ 
      this.wait1 = wait1; 
    }
	
    public void run()
    {
        synchronized (this.wait1)
        {
            System.out.println(Thread.currentThread().getName()+ "...starts");
            this.wait1.notify();
            //or
            //this.wait1.notifyAll();
            System.out.println(Thread.currentThread().getName()+ "...notified");
        }
    }
}
