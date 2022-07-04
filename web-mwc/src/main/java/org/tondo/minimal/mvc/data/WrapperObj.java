package org.tondo.minimal.mvc.data;

public class WrapperObj {

	private InfoData infoData;
	
	public WrapperObj(InfoData id) {
		this.infoData = id;
	}
	
	public InfoData getInfoData() {
		return infoData;
	}
	public void setInfoData(InfoData infoData) {
		this.infoData = infoData;
	}
}
