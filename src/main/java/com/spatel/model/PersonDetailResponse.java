package com.spatel.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PersonDetailResponse {
	@JsonIgnore
	private Integer id;
	@JsonProperty("Names")
	private String name;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("Sub Classes")
	private List<PersonDetailResponse> subClasses;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<PersonDetailResponse> getSubClasses() {
		return subClasses;
	}

	public void setSubClasses(List<PersonDetailResponse> subClasses) {
		this.subClasses = subClasses;
	}

	public PersonDetailResponse() {
		super();
	}

	public PersonDetailResponse(Integer id, String name) {
		super();
		this.name = name;
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object obj) {
		PersonDetailResponse compareObj = (PersonDetailResponse) obj;
		
		return this.id == compareObj.id;
	}

	
}
