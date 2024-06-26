package br.com.curso_spring.data.vo.v1;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"Identification", "Localization", "First_Name", "Last_Name", "gender"})
public class PersonVO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("Identification")
	private Long id;
	@JsonProperty("First_Name")
	private String firstName;
	@JsonProperty("Last_Name")
	private String lastName;
	@JsonProperty("Localization")
	private String address;
	@JsonIgnore()
	private String gender;
	
	public PersonVO() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	
}
