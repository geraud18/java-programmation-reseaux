package com.kbytes.threads;

public class MyStack {
    private int array [];
    private int size, index;

    /** Un constructeur de pile */
    public MyStack() {
        this (5);
    }

    /** Un autre constructeur de pile qui prend la taille de cette dernière */
    public MyStack(int size) {
        this.size = size; 
        this.index = 0;
        this.array = new int[size];
    }

    /** Renvoie true si la pile est vide */
    public boolean isEmpty() { return index == 0; }

    /** Renvoie true si la pile est pleine */
    public boolean isFull() { return index == size; }

    /** Cette méthode synchronisée permet de dépiler une valeur */
    public synchronized int pop () {
        try { 
            while (isEmpty()) {
                System.out.println("Consommateur Endormi");
                wait();
            }
        } catch(Exception e) {
            e.printStackTrace();
        }

        int val = array[--index];
        notifyAll();
        return val;
    }

    /** Cette méthode synchronisée permet d'empiler une valeur */
    public synchronized void push(int value) {
        try { 
            while (isFull()) {
                System.out.println("Producteur Endormi");
                wait();
            }
        } catch(Exception e) {
            e.printStackTrace();
        }

        array[index++] = value;
        notifyAll();
    }
}