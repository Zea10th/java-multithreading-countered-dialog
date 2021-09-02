package org.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {
    private static final ExecutorService THREAD_POOL = Executors.newFixedThreadPool(4);
    
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Lets get the multithreading started!");

        THREAD_POOL.submit(new LocalThread("ONE"));
        THREAD_POOL.submit(new LocalThread("TWO"));
        THREAD_POOL.submit(new LocalThread("THREE"));
        THREAD_POOL.submit(new LocalThread("FOUR"));

        Thread.sleep(15_000);
        THREAD_POOL.shutdownNow();
        System.out.println("Task has been finished. Have a nice day!");
    }
}
