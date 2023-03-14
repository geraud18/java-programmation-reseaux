package com.kbytes.threads;

public class ObjetEntier {
	private int value;

	public ObjetEntier() {
		value = 0;
		System.out.format("Valeur partagee initialisee a %d\n", value);
	}

	public String toString() {
		return Integer.toString(value);
	}

	public int val() {
		return value;
	}

	public void add(int i) {
		value += i;
	}

}