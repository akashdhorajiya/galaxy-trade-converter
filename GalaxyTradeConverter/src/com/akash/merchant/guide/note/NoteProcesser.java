package com.akash.merchant.guide.note;

import java.util.ArrayList;
import java.util.List;

import com.akash.merchant.guide.core.InfoMaps;

public class NoteProcesser {
	
	private List<String> results;
	
	private InfoMaps infoMaps;
	
	private static NoteProcesser engine;
	
	private NoteProcesser() {
		results = new ArrayList<>();
		infoMaps = InfoMaps.getInstance();
	}
	
	public static NoteProcesser getInstance() {
		if(engine != null) {
			return engine;
		} else {
			return new NoteProcesser();
		}
	}
	
	public void processNote(INote note) {
		if (note instanceof GalacticDigitInfoNote) {
			GalacticDigitInfoNote digitInfoNote = (GalacticDigitInfoNote) note;
			digitInfoNote.processNote(infoMaps);
		} else if(note instanceof CommodityInfoNote) {
			CommodityInfoNote commodityInfoNote = (CommodityInfoNote) note;
			commodityInfoNote.processNote(infoMaps);
		} else if (note instanceof GalacticNumberQuestionNote) {
			GalacticNumberQuestionNote numberQNote = (GalacticNumberQuestionNote) note;
			results.add(numberQNote.processNote(infoMaps));
		} else if (note instanceof CommodityQuestionNote) {
			CommodityQuestionNote commodityQNote = (CommodityQuestionNote) note;
			results.add(commodityQNote.processNote(infoMaps));
		} else if (note instanceof UnknownNote) {
			UnknownNote unknownNote = (UnknownNote) note;
			results.add(unknownNote.processNote(infoMaps));
		}
	}

	public List<String> getResults() {
		return results;
	}
}
