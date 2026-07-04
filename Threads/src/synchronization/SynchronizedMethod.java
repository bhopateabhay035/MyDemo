package synchronization;

public class SynchronizedMethod {
	
	public synchronized void getLine() {
        for (int i = 0; i < 3; i++) {
            System.out.println(i);
            try { 
            	Thread.sleep(100); 
            } 
            catch (Exception e) { 
            	System.out.println(e); }
        }
    }
}
