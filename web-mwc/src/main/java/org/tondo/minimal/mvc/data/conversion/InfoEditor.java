package org.tondo.minimal.mvc.data.conversion;

import java.beans.PropertyEditorSupport;

import org.tondo.minimal.mvc.data.InfoData;

public class InfoEditor extends PropertyEditorSupport{

	@Override
	public String getAsText() {
		InfoData data = (InfoData) getValue();
		System.out.println("=== Editor FORMAT");
		return "data_" + data.getFirstName() + "_info";
	}
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		System.out.println("=== Editor PARSE");
		InfoData data = new InfoData();
		data.setFirstName(text);
		setValue(data);
	}
}
