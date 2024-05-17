package com.deanaraujo.agenda.dto;

public class ContactDto {

	private Long id;
	private String name;
	private String cellphone;
	private String email;
	private Integer age;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCellphone() {
		return cellphone;
	}
	
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getAge() {
		return age;
	}

	public void setIAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "ContactDto [id=" + id + ", name=" + name + ", cellphone=" + cellphone + ", email=" + email + ", age="
				+ age + "]";
	}
}
