package com.akash.merchant.guide.note;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.akash.merchant.guide.core.GalacticDigit;
import com.akash.merchant.guide.core.InfoMaps;
import com.akash.merchant.guide.core.RomanNumber;

public class GalacticDigitInfoNote extends AbstractNote {
	
	private GalacticDigit digit;

	@Override
	public String processNote(InfoMaps infoMaps) {
		Map<String, GalacticDigit> digitMap = infoMaps.getGalacticDigitMap();
		digitMap.put(digit.getName(), digit);
		return "";
	}

	@Override
	public void parseNote() {
		String note = this.getNote();
		Pattern digitPattern = Pattern.compile(NoteRegexPattern.GALACTIC_DIGIT_PATTERN);
		Matcher digitMatcher = digitPattern.matcher(note);
		digitMatcher.find();
		Pattern romanPattern = Pattern.compile(NoteRegexPattern.ROMAN_NUMBER_PATTERN);
		Matcher romanMatcher = romanPattern.matcher(note);
		romanMatcher.find();
		digit = new GalacticDigit(digitMatcher.group(), RomanNumber.valueOf(romanMatcher.group()));
	}

}
