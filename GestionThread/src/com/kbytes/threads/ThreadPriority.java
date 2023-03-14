package com.kbytes.threads;

public class ThreadPriority extends Thread {
    private int counter = 0;
    private boolean stopped = false;

    public void run() {
        while(!stopped) counter++;
    }
    
    public void setStopped(boolean stopped){
    	this.stopped = stopped;
    }

    public int getCounter() { return this.counter; }

    public static void main(String args[]) throws Exception {
        ThreadPriority thread1 = new ThreadPriority();
        ThreadPriority thread2 = new ThreadPriority();
        ThreadPriority thread3 = new ThreadPriority();

        thread1.setPriority(Thread.MAX_PRIORITY);
        thread2.setPriority(Thread.NORM_PRIORITY);
        thread3.setPriority(Thread.MIN_PRIORITY);

        thread1.start(); thread2.start(); thread3.start();
        Thread.sleep(1000);
        thread1.setStopped(true); thread2.setStopped(true); thread3.setStopped(true);

        System.out.println("Thread 1 : counter == " + thread1.getCounter());
        System.out.println("Thread 2 : counter == " + thread2.getCounter());
        System.out.println("Thread 3 : counter == " + thread3.getCounter());
    }
}
