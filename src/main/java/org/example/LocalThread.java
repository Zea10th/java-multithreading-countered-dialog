package org.example;

class LocalThread extends Thread {
    private final int PAUSE = 2500;
    private final String NAME;

    LocalThread(String name) {
        NAME = "Thread " + name;
    }

    @Override
    public void run() {
        try {
            while (!isInterrupted()) {
                Thread.sleep((int) (PAUSE * Math.random()));
                System.out.printf("%s is greeting you!\n", getName());
            }
        } catch (InterruptedException err) {
            System.out.printf("%s has been interrupted.\n", getName());
        } finally {
            System.out.printf("%s has been stopped!\n", getName());
        }
    }
}
