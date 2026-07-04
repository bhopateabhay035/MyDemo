package interthreadcomm;

public class Wait2 extends Thread {
	Wait1 wait1;
	
	Wait2(Wait1 wait1){ 
      this.wait1 = wait1; 
    }
	
    public void run()
    {
        synchronized (this.wait1)
        {
            System.out.println(Thread.currentThread().getName()+ "...starts");
            try {
                this.wait1.wait();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+ "...notified");
        }
    }

}
