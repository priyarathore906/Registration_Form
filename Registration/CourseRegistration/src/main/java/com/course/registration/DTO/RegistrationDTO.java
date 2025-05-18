package com.course.registration.DTO;

import java.util.List;

public class RegistrationDTO {

    private String name;
    private String college;
    private String contact;
    private String email;  
    private List<String> courses;
    private String timing;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<String> getCourses() {
		return courses;
	}
	public void setCourses(List<String> courses) {
		this.courses = courses;
	}
	public String getTiming() {
		return timing;
	}
	public void setTiming(String timing) {
		this.timing = timing;
	}
	public RegistrationDTO(String name, String college, String contact,String email, List<String> courses, String timing) {
		super();
		this.name = name;
		this.college = college;
		this.contact = contact;
		this.email = email;
		this.courses = courses;
		this.timing = timing;
	}
	public RegistrationDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
