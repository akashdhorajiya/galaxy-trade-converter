package com.akash.merchant.guide.note;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import com.akash.merchant.guide.core.Constants;
import com.akash.merchant.guide.core.GalacticDigit;
import com.akash.merchant.guide.core.GalacticNumber;
import com.akash.merchant.guide.core.InfoMaps;

public class GalacticNumberQuestionNote extends AbstractNote {
	
	private List<String> galacticNumberAsStringList = new ArrayList<>();

	@Override
	public String processNote(InfoMaps infoMaps) {
		Map<String, GalacticDigit> digitMap = infoMaps.getGalacticDigitMap();
		
		GalacticNumber number = new GalacticNumber();
		for(String digitAsString : galacticNumberAsStringList) {
			if(digitMap.containsKey(digitAsString)) {
				number.appendGalacticDigit(digitMap.get(digitAsString));
			} else {
				return Constants.UNKNOWN_NOTE_ANSWER;
			}
		}
		
		return String.format(Constants.GALACTIC_NUMBER_ANSWER, number.getAsString(), 
				number.getDecimalValue());
	}

	@Override
	public void parseNote() {
		
		List<String> filteredWords = Util.getFilteredWords(this.getNote());
		
		Pattern digitPattern = Pattern.compile(NoteRegexPattern.GALACTIC_DIGIT_PATTERN);
		
		for(String word : filteredWords) {
			Matcher digitMatcher = digitPattern.matcher(word);
			if(digitMatcher.find()) {
				galacticNumberAsStringList.add(digitMatcher.group());
			}
		}
	}

}
