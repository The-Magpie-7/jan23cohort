package com.example.dojoandninjas.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="ninjas")
public class Ninja {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min=2, max=50, message="First name must be 2 to 50 characters.")
	private String firstName;
	
	@NotNull
	@Size(min=2, max=50, message="Last name must be 2 to 50 characters.")
	private String lastName;
	
	@NotNull
	private Integer age;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;

	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	//needed for onCreate and onUpdate
	@PrePersist
	protected void onCreate(){
		this.createdAt = new Date();
	}
	@PreUpdate
	protected void onUpdate(){
		this.updatedAt = new Date();

	//---------------
	//  CONSTRUCTORS
	//---------------
	
	//empty default constructor
	}
	public Ninja() {
	}
	
//	/**
//	 * @param firstName - person who attends a dojo
//	 * @param lastName  - person who attends a dojo
//	 * @param age  - person who attends a dojo
//	 */
//	//constructor
//	public Ninja(@NotNull @Size(min = 2, max = 50, message = "First name must be 2 to 50 characters.") String firstName,
//			@NotNull @Size(min = 2, max = 50, message = "Last name must be 2 to 50 characters.") String lastName,
//			@NotNull Integer age) {
//		this.firstName = firstName;
//		this.lastName = lastName;
//		this.age = age;
//	}
//	
	
	//-----------------
	//RELATIONSHIP - many ninjas to a dojo
	//------------------
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="dojo_id")
	//Dojo instance
	private Dojo dojo;
	
	
	//-----------------------
	//  GETTERS and SETTERS
	//-----------------------
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the age
	 */
	public Integer getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(Integer age) {
		this.age = age;
	}
	/**
	 * @return the createdAt
	 */
	public Date getCreatedAt() {
		return createdAt;
	}
	/**
	 * @param createdAt the createdAt to set
	 */
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	/**
	 * @return the updatedAt
	 */
	public Date getUpdatedAt() {
		return updatedAt;
	}
	/**
	 * @param updatedAt the updatedAt to set
	 */
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	//-----------------
	// from Dojo class
	// getters and setters
	//------------------
	public Dojo getDojo() {
		return dojo;
	}
	
	public void setDojo() {
		this.dojo = dojo;
	}

}
