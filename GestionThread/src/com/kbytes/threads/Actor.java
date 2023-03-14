package com.kbytes.threads;

abstract class Actor implements Runnable {
    /** La pile partagée par tous nos threads */
    private static MyStack p = new MyStack(5);
    /** Un délai d'attente pour chaque thread */
    protected long sleepTime;

    /** Un constructeur par défaut. Pas de délai d'attente */
    public Actor () {
        this (0);
    }

    /** Un constructeur qui prend un délai d'attente pour le thread */
    public Actor (long sleepTime) {
        this.sleepTime = sleepTime;
        (new Thread(this)).start();
    }

    /** Permet de pouvoir récupérer la pile */
    public MyStack getMyStack() { return p; }
}