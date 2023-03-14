package com.kbytes.threads;

public class PetitJobSynchro implements Runnable {
	private ObjetEntierSynchro notreEntier;
	private int increment;

	PetitJobSynchro(ObjetEntierSynchro notreEntier, int increment) {
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

	public static void main(String[] args) throws Exception {
		ObjetEntierSynchro Compteur = new ObjetEntierSynchro();
		PetitJobSynchro objex1 = new PetitJobSynchro(Compteur, 1);
		PetitJobSynchro objex2 = new PetitJobSynchro(Compteur, -1);
		Thread tache1 = new Thread(objex1, "incrementeur");
		Thread tache2 = new Thread(objex2, "decrementeur");

		tache1.start();
		tache2.start();

		tache1.join();
		tache2.join();

		System.out.format("Le compteur vaut %s\n", Compteur);

	}
}