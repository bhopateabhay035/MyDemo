package synchronization;

public class TestMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UnsynchronizedMethod unsync = new UnsynchronizedMethod();
		SynchronizedMethod sync = new SynchronizedMethod();
		SynchronizedBlock bloc = new SynchronizedBlock();
		
        //RunMethod t1 = new RunMethod(unsync);
       // RunMethod t2 = new RunMethod(unsync);
	   // t1.start();
	   // t2.start();
		
//        RunMethod t3 = new RunMethod(sync);
//        RunMethod t4 = new RunMethod(sync);
//        t3.start();
//        t4.start();

		RunMethod t5 = new RunMethod(bloc);
		RunMethod t6 = new RunMethod(bloc);
		t5.start();
		t6.start();
	}

}
/*
 * o/p of UnsynchronizedMethod 0 0 1 1 2 2
 */

/*
 * o/p of synchronizedmethod 0 1 2 0 1 2
 */
