package com.kbytes.threads;

public class PetitJob implements Runnable {
	private ObjetEntier notreEntier;
	private int increment;

	PetitJob(ObjetEntier notreEntier, int increment) {
		this.increment = increment;
		this.notreEntier = notreEntier;
	}

	public void run() {
		for (int i = 0; i < 1e8; i++) {
			notreEntier.add(increment);
		}
		System.out.format("Thread faisant %d - termine, compteur= %s\n",
				increment, notreEntier);

	}

	public static void main(String[] args) {
		ObjetEntier Compteur = new ObjetEntier();
		PetitJob objex1 = new PetitJob(Compteur, 1);
		PetitJob objex2 = new PetitJob(Compteur, -1);
		Thread tache1 = new Thread(objex1, "incrementeur");
		Thread tache2 = new Thread(objex2, "decrementeur");

		tache1.start();
		tache2.start();

		System.out.format("Le compteur vaut %s\n", Compteur);
		System.out.format("Le compteur vaut %s\n", Compteur);

	}
}