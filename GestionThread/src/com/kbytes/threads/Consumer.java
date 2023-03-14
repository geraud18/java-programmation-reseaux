package com.kbytes.threads;

public class Consumer extends Actor {

    public Consumer() { super(); }
    public Consumer(long sleepTime) { 
        super(sleepTime);
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep ((long)Math.random()*this.sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println (this + " depile " + getMyStack().pop());
        }
    }
}