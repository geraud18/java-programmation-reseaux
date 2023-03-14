package com.kbytes.threads;

public class ObjetEntierSynchro {
	private int value;

	public ObjetEntierSynchro() {
		value = 0;
		System.out.format("Valeur partagee initialisee a %d\n", value);
	}

	public String toString() {
		return Integer.toString(value);
	}

	public int val() {
		return value;
	}

	public synchronized void add(int i) {
		value += i;
	}

}