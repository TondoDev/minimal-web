package org.tondo.minimal.mvc.data;

import java.time.LocalDate;
import java.util.List;

public class InfoData {

	private String firstName;
	private String surname;
	
	private LocalDate birtDate;
	private LocalDate startDate;
	
	private Integer xpPoints;
	private Double index;
	
	private Occupation occupation;
	private Gender sex;
	
	private List<String> skills;
	
	public InfoData() {
		//
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public LocalDate getBirtDate() {
		return birtDate;
	}

	public void setBirtDate(LocalDate birtDate) {
		this.birtDate = birtDate;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public Integer getXpPoints() {
		return xpPoints;
	}

	public void setXpPoints(Integer xpPoints) {
		this.xpPoints = xpPoints;
	}

	public Double getIndex() {
		return index;
	}

	public void setIndex(Double index) {
		this.index = index;
	}

	public Occupation getOccupation() {
		return occupation;
	}

	public void setOccupation(Occupation occupation) {
		this.occupation = occupation;
	}

	public Gender getSex() {
		return sex;
	}

	public void setSex(Gender sex) {
		this.sex = sex;
	}

	public List<String> getSkills() {
		return skills;
	}

	public void setSkills(List<String> skills) {
		this.skills = skills;
	}
}
