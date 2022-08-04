package com.akash.merchant.guide;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.akash.merchant.guide.note.NoteFactory;
import com.akash.merchant.guide.note.NoteProcesser;

public class GuideToGalaxyApplication {

	public static void main(String[] args) {
		
		NoteProcesser noteProcessor = NoteProcesser.getInstance();
		
		List<String> inputNotes = new ArrayList<>(Arrays.asList(
				"glob is I",
				"prok is V",
				"pish is X",
				"tegj is L",
				"glob glob Silver is 34 Credits",
				"glob prok Gold is 57800 Credits",
				"pish pish Iron is 3910 Credits",
				"how much is pish tegj glob glob ?",
				"how many Credits is glob prok Silver ?",
				"how many Credits is glob prok Gold ?",
				"how many Credits is glob prok Iron ?",
				"how much wood could a woodchuck chuck if a woodchuck could chuck wood ?"
				));
		
		inputNotes.forEach(inputNote -> {
			noteProcessor.processNote(NoteFactory.getNote(inputNote));
		});
		
		noteProcessor.getResults().forEach(System.out::println);
	}
}
