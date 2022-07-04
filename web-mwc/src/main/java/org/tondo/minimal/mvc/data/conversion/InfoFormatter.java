package org.tondo.minimal.mvc.data.conversion;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;
import org.tondo.minimal.mvc.data.InfoData;

public class InfoFormatter implements Formatter<InfoData>{
	private String border;
	
	public InfoFormatter(String border) {
		this.border = border;
	}
	public InfoFormatter() {
			System.out.println("InfoFormatter created!");
			this.border = "fmt";
	}

	@Override
	public String print(InfoData object, Locale locale) {
		return this.border + "_" + object.getFirstName() + "_" + this.border;
	}

	@Override
	public InfoData parse(String text, Locale locale) throws ParseException {
		InfoData data = new InfoData();
		data.setFirstName("fomratter:"+ text);
		return data;
	}

}
