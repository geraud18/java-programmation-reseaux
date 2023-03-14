package com.kbytes.threads;

public class Producer extends Actor {

    private int value = 0;
    
    public Producer() { super(); }

    public Producer(long sleepTime) { 
        super(sleepTime);
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep ((long)Math.random()*this.sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println (this + " empile " + value);
            getMyStack().push(value++);
        }
    }
}