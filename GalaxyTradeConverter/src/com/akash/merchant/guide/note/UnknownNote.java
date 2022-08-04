package com.akash.merchant.guide.note;

import com.akash.merchant.guide.core.Constants;
import com.akash.merchant.guide.core.InfoMaps;

public class UnknownNote extends AbstractNote {

	@Override
	public void parseNote() {
		// Can not parse note since it is unknown format
	}

	@Override
	public String processNote(InfoMaps infoMaps) {
		return Constants.UNKNOWN_NOTE_ANSWER;
	}

}
