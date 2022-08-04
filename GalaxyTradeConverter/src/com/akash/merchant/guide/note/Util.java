package com.akash.merchant.guide.note;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Util {
	
	public static List<String> getFilteredWords(String note) {
		List<String> notUsefulWords = new ArrayList<>(Arrays.asList("how", "much", "is", "Credits", "many", "?"));
		String[] words = note.split(" ");
		return Arrays.asList(words).stream()
				.filter(word -> !notUsefulWords.contains(word)).collect(Collectors.toList());
	}

}
