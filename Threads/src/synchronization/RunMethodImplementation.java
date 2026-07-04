package synchronization;

public class RunMethodImplementation {

	public static void main(String[] args) {
		UnsynchronizedMethod unsync = new UnsynchronizedMethod();
		SynchronizedMethod syn = new SynchronizedMethod();
		SynchronizedBlock bloc = new SynchronizedBlock();
		
		Runnable r = () -> {
			System.out.println("UnsynchronizedMethod");
			unsync.getLine();
			System.out.println("synchronizedMethod");
			syn.getLine();
			System.out.println("synchronizedblock");
			bloc.getLine(3);
		};
		Thread t1 = new Thread(r);
		Thread t2 = new Thread(r);
		t1.start();
		t2.start();
	}
}
