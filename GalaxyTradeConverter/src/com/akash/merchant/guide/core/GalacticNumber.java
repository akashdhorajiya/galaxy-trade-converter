package com.akash.merchant.guide.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class GalacticNumber {
	
	private List<GalacticDigit> galacticNumber;
	
	public GalacticNumber() {
		galacticNumber = new ArrayList<>();
	}
	
	public void appendGalacticDigit(GalacticDigit digit) {
		galacticNumber.add(digit);
	}
	
	public int getDecimalValue( ) {
		int decimalValue = 0;
		Stack<Integer> stack = new Stack<>();
		galacticNumber.forEach(digit -> {
			if(!stack.isEmpty() && digit.getDecimalValue() > stack.peek()) {
				stack.push(digit.getDecimalValue() - stack.pop());
			} else {
				stack.push(digit.getDecimalValue());
			}
		});
		while(!stack.isEmpty()) {
			decimalValue += stack.pop();
		}
		return decimalValue;
	}
	
	public String getAsString() {
		return galacticNumber.stream().map(GalacticDigit::getName).collect(Collectors.joining(" "));
	}
	
	public List<GalacticDigit> getGalacticNumber() {
		return galacticNumber;
	}
}
