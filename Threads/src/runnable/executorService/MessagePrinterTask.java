package runnable.executorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//ExecutorService to execute a Runnable task that prints a message multiple times, 
//with a brief pause between each message
public class MessagePrinterTask implements Runnable {
    private final String message;
    private final int times;

    public MessagePrinterTask(String message, int times) {
        this.message = message;
        this.times = times;
    }

    @Override
    public void run() {
        for (int i = 0; i < times; i++) {
            System.out.println("[" + Thread.currentThread().getName() + "] " + message);
            try {
                Thread.sleep(1000); // Pause for a second
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Set the interrupt flag
                System.out.println("Task was interrupted.");
                break;
            }
        }
    }

    public static void main(String[] args) {
    	
    	// Create an ExecutorService with a pool of 2 threads
        ExecutorService executor = Executors.newFixedThreadPool(2); 
        
        //initialize object
        MessagePrinterTask  mprint1 = new MessagePrinterTask("Hello from Task 1", 2);
        MessagePrinterTask  mprint2 = new MessagePrinterTask("Hello from Task 2", 5);
        MessagePrinterTask  mprint3 = new MessagePrinterTask("Hello from Task 3", 2);

        // Submit three tasks to be executed by the thread pool having 2 threads
        //executor.submit(mprint1);
        //executor.submit(mprint2);
//OR
        executor.execute(mprint1);
        executor.execute(mprint2);
        executor.execute(mprint3);

        executor.shutdown(); 
        // Initiates an orderly shutdown in which previously submitted tasks are executed, but no new tasks will be accepted
    }

}
