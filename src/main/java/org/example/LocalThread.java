package org.example;

import java.util.concurrent.Callable;

class LocalThread implements Callable<String> {
    private final int PAUSE = 2500;
    private final String NAME;
    private boolean isInterrupted = Thread.currentThread().isInterrupted();
    private int counter = 0;

    LocalThread(String name) {
        NAME = "Thread " + name;
    }

    @Override
    public String call() {
        try {
            while (!isInterrupted) {
                System.out.printf("%s is greeting you!\n", this.NAME);
                Thread.sleep((int) (PAUSE * Math.random()));
                this.counter++;
            }
        } catch (InterruptedException err) {
            System.out.printf("%s has been interrupted.\n", this.NAME);
        } finally {
            System.out.printf("%s has been stopped!\n", this.NAME);
        }

        return "Result: task of thread " + this.NAME + " has been done "
                + this.counter + "times.";
    }
}
