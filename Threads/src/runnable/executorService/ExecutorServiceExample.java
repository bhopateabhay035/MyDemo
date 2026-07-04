package runnable.executorService;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceExample {

    public static void main(String[] args) throws Exception {

        // Create a fixed-size thread pool with 2 threads
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // Submit a Runnable task
        executor.submit(() -> System.out.println("Runnable task executed by thread: " + Thread.currentThread().getName()));

        // Submit a Callable task
        Callable<String> callableTask = () -> {
            Thread.sleep(1000); // Simulate some work
            return "Callable task result from thread: " + Thread.currentThread().getName();
        };

        Future<String> future = executor.submit(callableTask);
        // Retrieve the result of the Callable task
        System.out.println(future.get()); // Blocks until the result is available
        // Shut down the executor service
  executor.shutdown();
    }

}
