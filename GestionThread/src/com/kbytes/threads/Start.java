package com.kbytes.threads;

public class Start {
    static public void main (String args[]) {
        // D�marrage de deux Producteurs
        new Producer(1000);
        new Producer(1000);
        // D�marrage de deux Consommateurs
        new Consumer(1000);
        new Consumer(1000);

        while (true) { // Mise en veille du thread principal
            try { 
                Thread.sleep (10000L);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}