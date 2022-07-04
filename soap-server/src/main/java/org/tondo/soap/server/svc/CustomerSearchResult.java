package org.tondo.soap.server.svc;

import java.time.LocalDate;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CustomerSearchResult {

	
	private String name;
	private String surname;
	private LocalDate birthDate;
	private Double credit;
	private Integer custId;
	private CustomerLevel level;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public LocalDate getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	public Double getCredit() {
		return credit;
	}
	public void setCredit(Double credit) {
		this.credit = credit;
	}
	public Integer getCustId() {
		return custId;
	}
	public void setCustId(Integer custId) {
		this.custId = custId;
	}
	
	public CustomerLevel getLevel() {
		return level;
	}
	
	public void setLevel(CustomerLevel level) {
		this.level = level;
	}
}
