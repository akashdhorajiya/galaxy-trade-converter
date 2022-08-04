package com.akash.merchant.guide.note;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import com.akash.merchant.guide.core.Commodity;
import com.akash.merchant.guide.core.Constants;
import com.akash.merchant.guide.core.GalacticDigit;
import com.akash.merchant.guide.core.GalacticNumber;
import com.akash.merchant.guide.core.InfoMaps;

public class CommodityQuestionNote extends AbstractNote {
	
	private List<String> galacticNumberAsStringList = new ArrayList<>();
	private String commodityName;

	@Override
	public String processNote(InfoMaps infoMaps) {
		
		Map<String, Commodity> commodityMap = infoMaps.getCommodityMap();
		Map<String, GalacticDigit> digitMap = infoMaps.getGalacticDigitMap();
		
		GalacticNumber number = new GalacticNumber();
		for(String digitAsString : galacticNumberAsStringList) {
			if(digitMap.containsKey(digitAsString)) {
				number.appendGalacticDigit(digitMap.get(digitAsString));
			} else {
				return Constants.UNKNOWN_NOTE_ANSWER;
			}
		}
		
		if(commodityMap.containsKey(commodityName)) {
			Commodity commodity = commodityMap.get(commodityName);
			return String.format(Constants.COMMODITY_CREDIT_ANSWER, number.getAsString(), 
					commodity.getName(), commodity.getCreditsFor(number.getDecimalValue()));
		} else {
			return Constants.UNKNOWN_NOTE_ANSWER;
		}
	}

	@Override
	public void parseNote() {
		
		List<String> filteredWords = Util.getFilteredWords(this.getNote());
		
		Pattern digitPattern = Pattern.compile(NoteRegexPattern.GALACTIC_DIGIT_PATTERN);
		Pattern commodityPattern = Pattern.compile(NoteRegexPattern.COMMODITY_PATTERN);
		
		for(String word : filteredWords) {
			Matcher digitMatcher = digitPattern.matcher(word);
			Matcher commodityMatcher = commodityPattern.matcher(word);
			if(digitMatcher.find() && digitMatcher.group().equals(word.trim())) {
				galacticNumberAsStringList.add(digitMatcher.group());
			} else if(commodityMatcher.find()) {
				commodityName = commodityMatcher.group();
			}
		}
		
	}

}
