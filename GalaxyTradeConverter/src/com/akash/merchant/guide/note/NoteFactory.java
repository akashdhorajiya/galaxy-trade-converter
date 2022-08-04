package com.akash.merchant.guide.note;

import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NoteFactory {
	
	public static INote getNote(String noteLine) {
		INote note = createNote(getNoteType(noteLine));
		note.setNote(noteLine);
		note.parseNote();
		return note;
	}
	
	private static INote createNote(NoteType noteType) {
		if(noteType.equals(NoteType.DIGIT_INFO)) {
			return new GalacticDigitInfoNote();
		} else if(noteType.equals(NoteType.COMMODITY_INFO)) {
			return new CommodityInfoNote();
		} else if(noteType.equals(NoteType.COMMODITY_QUESTION)) {
			return new CommodityQuestionNote();
		} else if(noteType.equals(NoteType.NUMBER_QUESTION)) {
			return new GalacticNumberQuestionNote();
		} else {
			return new UnknownNote();
		}
	}
	
	private static NoteType getNoteType(String noteLine) {
		for(Entry<NoteType, String> entry: NoteRegexPattern.getNoteRegexMap().entrySet()){
			Pattern regexPattern = Pattern.compile(entry.getValue());
			Matcher matcher = regexPattern.matcher(noteLine);
			if(matcher.find()) {
				return entry.getKey();
			}
		}
		return NoteType.UNKNOWN;
	}
}
