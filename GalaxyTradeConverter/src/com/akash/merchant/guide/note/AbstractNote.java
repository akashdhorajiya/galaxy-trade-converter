package com.akash.merchant.guide.note;

public abstract class AbstractNote implements INote {
	
	String note;
	
	public String getNote() {
		return note;
	}
	
	public void setNote(String note) {
		this.note = note;
	}

}
