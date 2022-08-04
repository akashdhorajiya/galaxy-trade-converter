package com.akash.merchant.guide.note;

import java.util.HashMap;
import java.util.Map;

public class NoteRegexPattern {
	
	private NoteRegexPattern() {
		//Empty constructor 
	}

	public static final String COMMODITY_INFO_NOTE_PATTERN = "(([a-z]{4} )+[A-Z]+[a-z]* is \\d+ Credits)";
	
	public static final String GALACTIC_DIGIT_INFO_NOTE_PATTERN = "([a-z]{4} is [I|V|X|L|C|D|M]{1})";
	
	public static final String COMMODITY_QUESTION_NOTE_PATTERN = "(how many Credits is [[a-z]{4} ]+ [A-Z]+[a-z]* \\?)";
	
	public static final String GALACTIC_NUM_QUESTION_NOTE_PATTERN = "(how much is [[a-z]{4} ]+\\?)";
	
	public static final String CREDITS_PATTERN = "(\\d+)";
	
	public static final String GALACTIC_DIGIT_PATTERN = "([a-z]{4})";
	
	public static final String COMMODITY_PATTERN = "([A-Z]+[a-z]*)";
	
	public static final String ROMAN_NUMBER_PATTERN = "([I|V|X|L|C|D|M]{1})";
	
	public static Map<NoteType, String> getNoteRegexMap() {
		Map<NoteType, String> regexMap = new HashMap<>();
		regexMap.put(NoteType.DIGIT_INFO, GALACTIC_DIGIT_INFO_NOTE_PATTERN);
		regexMap.put(NoteType.COMMODITY_INFO, COMMODITY_INFO_NOTE_PATTERN);
		regexMap.put(NoteType.NUMBER_QUESTION, GALACTIC_NUM_QUESTION_NOTE_PATTERN);
		regexMap.put(NoteType.COMMODITY_QUESTION, COMMODITY_QUESTION_NOTE_PATTERN);
		return regexMap;
	}
}
