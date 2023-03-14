package com.kbytes.threads;

abstract class Actor implements Runnable {
    /** La pile partag�e par tous nos threads */
    private static MyStack p = new MyStack(5);
    /** Un d�lai d'attente pour chaque thread */
    protected long sleepTime;

    /** Un constructeur par d�faut. Pas de d�lai d'attente */
    public Actor () {
        this (0);
    }

    /** Un constructeur qui prend un d�lai d'attente pour le thread */
    public Actor (long sleepTime) {
        this.sleepTime = sleepTime;
        (new Thread(this)).start();
    }

    /** Permet de pouvoir r�cup�rer la pile */
    public MyStack getMyStack() { return p; }
}