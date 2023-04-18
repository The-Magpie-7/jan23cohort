package com.example.burgertracker1.models;


import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author Dana
 *
 */
@Entity
@Table(name="burger")
public class Burger {
	
	//members/fields
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min = 2, max=50, message="Name must be between 2 and 50 characters")
	private String name;
	
	@NotNull
	@Size(min=2, max=50, message="Name must be between 2 and 50 characters")
	private String restaurant;
	
	@NotEmpty
	private String notes;
	
	@NotNull
	private Integer rating;
	
	//list for ratings
	//List<Integer> rateList;
	
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
	/**
	 * 
	 */
	//empty default constructor
	public Burger() {
	}
	/**
	 * @param name
	 * @param restaurant
	 * @param rating
	 * @param notes
	 */
	//constructor
	public Burger(@NotNull @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters") String name,
			@NotNull @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters") String restaurant,
			@NotNull Integer rating,
			@NotNull String notes) {
		this.name = name;
		this.restaurant = restaurant;
		this.rating = rating;
		this.notes = notes;
	}
	/**
	 * @param name
	 * @param restaurant
	 * @param rating
	 * @param notes
	 */
	//constructor

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
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the restaurant
	 */
	public String getRestaurant() {
		return restaurant;
	}
	/**
	 * @param restaurant the restaurant to set
	 */
	public void setRestaurant(String restaurant) {
		this.restaurant = restaurant;
	}
	/**
	 * @return the rating
	 */
	public Integer getRating() {
		return rating;
	}
	/**
	 * @param rating the rating to set
	 */
	public void setRating(Integer rating) {
		this.rating = rating;
	}
	/**
	 * @return the notes
	 */
	public String getNotes() {
		return notes;
	}
	/**
	 * @param notes the notes to set
	 */
	public void setNotes(String notes) {
		this.notes = notes;
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
	
	

}
