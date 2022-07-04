package org.tondo.minimal.mvc.data;

public enum Occupation {

	DEVELOPER("dev"), MAID("maid"), ACCOUNTANT("acc");
	
	private String id;
	
	private Occupation(String id) {
		this.id = id;
	}
	
	public String getId() {
		return this.id;
	}
	
}
