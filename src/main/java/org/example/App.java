package org.example;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

public class App {
    private static final int POOL_SIZE = 4;
    private static final ExecutorService THREAD_POOL = Executors.newFixedThreadPool(POOL_SIZE);

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        System.out.println("Lets get the multithreading started!");

        Set<Callable<String>> callableSet = new HashSet<>();
        callableSet.add(new LocalThread("ONE"));
        callableSet.add(new LocalThread("TWO"));
        callableSet.add(new LocalThread("THREE"));
        callableSet.add(new LocalThread("FOUR"));

        List<Future<String>> result_1 = THREAD_POOL.invokeAll(callableSet);

        Thread.sleep(15_000);
        THREAD_POOL.shutdownNow();

        for (Future<String> task : result_1) {
            System.out.println(task.get());
        }

        String result_2 = THREAD_POOL.invokeAny(callableSet);
        THREAD_POOL.shutdownNow();

        System.out.println(result_2);

        System.out.println("All tasks has been finished. Have a nice day!");
    }
}
