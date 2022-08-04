package com.akash.merchant.guide.core;

public class Commodity {
	
	private String name;
	
	private int credit;
	
	public Commodity (String name, int credit) {
		this.name = name;
		this.credit = credit;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return credit;
	}
	
	public int getCreditsFor(int units) {
		return units * credit;
	}

}
