package com.akash.merchant.guide.core;

public final class GalacticDigit {
	
	private final String name;
	
	private final RomanNumber romanNumber;
	
	public GalacticDigit(String name, RomanNumber romanNumber) {
		this.name = name;
		this.romanNumber = romanNumber;
	}
	
	public int getDecimalValue() {
		return romanNumber.getDecimalValue();
	}

	public String getName() {
		return name;
	}

	public RomanNumber getRomanNumber() {
		return romanNumber;
	}
	
}
