package com.kbytes.threads;

public class CompteurBasique implements Runnable {
	String nom = "Toto";
	int maxIter = 1000;
	int Direction = 0;

	public CompteurBasique(String nom, int laDirection) {
		this.nom = nom;
		this.Direction = laDirection;
	}

	public void run() {
		System.out.format("Ici le  thread %s, je debute!\n", nom);
		for (int i = 0; i < maxIter; i++) {
			System.out.format("[%s] dit %d\n", nom, (maxIter - 1)
					* ((1 - Direction) / 2) + Direction * i);
		}
		System.out.format("Thread %s terminé", nom);
	}

	public static void main(String[] args) throws Exception {
		CompteurBasique objetA = new CompteurBasique("TA", 1);
		Thread TA = new Thread(objetA);
		CompteurBasique objetB = new CompteurBasique("TB", -1);
		Thread TB = new Thread(objetB);
		TA.start();
		TB.start();
		System.out.format("Thread principal terminé  !\n");
	}
}