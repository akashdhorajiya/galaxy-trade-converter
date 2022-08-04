package com.akash.merchant.guide.note;

import com.akash.merchant.guide.core.InfoMaps;

public interface INote {
	
	public String getNote();
	
	public void setNote(String note);
	
	void parseNote();
	
	String processNote(InfoMaps infoMaps);

}
