package org.example;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

public class App {
    private static final ExecutorService THREAD_POOL = Executors.newFixedThreadPool(4);

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        System.out.println("Lets get the multithreading started!");

        Set<Callable<String>> callableSet = new HashSet<>();
        callableSet.add(new LocalThread("ONE"));
        callableSet.add(new LocalThread("TWO"));
        callableSet.add(new LocalThread("THREE"));
        callableSet.add(new LocalThread("FOUR"));

        List<Future<String>> result_1 = THREAD_POOL.invokeAll(callableSet);
        String result_2 = THREAD_POOL.invokeAny(callableSet);

        Thread.sleep(15_000);
        THREAD_POOL.shutdownNow();

        for (Future<String> task : result_1) {
            System.out.println(task.get());
        }

        System.out.println(result_2);

        System.out.println("Task has been finished. Have a nice day!");
    }
}
