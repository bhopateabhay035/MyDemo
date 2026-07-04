package callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class WordLengthCallable implements Callable<Integer> {
    private final String word;

    public WordLengthCallable(String word) {
        this.word = word;
    }

    @Override
    public Integer call() {
        return word.length();
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();
        
        WordLengthCallable w = new WordLengthCallable("Hello World");
        
        Future<Integer> futureResult = executor.submit(w);
        System.out.println("Length of the word is: " + futureResult.get());
        executor.shutdown();
    }


}
