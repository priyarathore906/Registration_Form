package com.course.registration.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Registration {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String name;
	    private String college;

	    @Column(unique = true)
	    private String contact;
	    
	    @Column(unique = true)
	    private String email;

	    private String courses;
	    private String timing;
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
		public String getCourses() {
			return courses;
		}
		public void setCourses(String courses) {
			this.courses = courses;
		}
		public String getTiming() {
			return timing;
		}
		public void setTiming(String timing) {
			this.timing = timing;
		}
		public Registration(Long id, String name, String college, String contact,String email, String courses, String timing) {
			super();
			this.id = id;
			this.name = name;
			this.college = college;
			this.contact = contact;
			this.email = email;
			this.courses = courses;
			this.timing = timing;
		}
		public Registration() {
			super();
			// TODO Auto-generated constructor stub
		}
	    
	    
}
