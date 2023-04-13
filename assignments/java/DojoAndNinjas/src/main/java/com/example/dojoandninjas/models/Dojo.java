package com.example.dojoandninjas.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="dojos")
public class Dojo {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotNull
	@Size(min=2, max=75, message="Name of Dojo location must be between 2 and 75 characters.")
	private String location;
	
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
	}
	
	//------------------
	//  CONSTRUCTORS
	//------------------
	//empty default constructor
	public Dojo() {
	}
	
	/**
	 * @param location
	 */
	//constructor
//	public Dojo(
//			@NotNull @Size(min = 2, max = 75, message = "Name of Dojo location must be between 2 and 75 characters.") String location) {
//		this.location = location;
//	}
	
	
	//----------------
	//RELATIONSHIP - one dojo has many ninjas
	//-----------------
    @OneToMany(mappedBy="dojo", fetch = FetchType.LAZY)
    //empty list of ninjas
    private List<Ninja> ninjas;

	
	//---------------------
	// GETTERS and SETTERS
	//---------------------
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
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
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
	
	//-------------------
	// from Ninja class
	// getters and setters
	//-------------------
	
	public List<Ninja> getNinjas(){
		return ninjas;
	}
	
	public void setNinjas(List<Ninja> ninjas) {
		this.ninjas = ninjas;
	}
}
