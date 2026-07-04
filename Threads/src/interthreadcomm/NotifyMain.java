package interthreadcomm;

public class NotifyMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Wait1 waits1 = new Wait1();
        Wait2 waits2 = new Wait2(waits1);
        Wait3 waits3 = new Wait3(waits1);
        
        Notify not = new Notify(waits1);
        Thread t1 = new Thread(waits1, "Thread-1");
        Thread t2 = new Thread(waits2, "Thread-2");
        Thread t3 = new Thread(waits3, "Thread-3");
        Thread t4 = new Thread(not, "Thread-4");
        t1.start();
        t2.start();
        t3.start();
        try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        t4.start();

	}

}
