package com.example.bookclub.models;

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
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="users")
public class User {

	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 
	 @NotBlank(message="Name is required!")
	 @Pattern(regexp = "^[A-Za-z]+$", message="Name may only contain letters A-Z")
	 @Size(min=3, max=30, message="Name must be between 3 and 30 letters")
	 private String name;
	 
//	 @NotBlank(message="Last name is required!")
//	    @Size(min=3, max=30, message="Last Name must be between 3 and 30 characters")
//	 private String lastName;
	 
	 
	 @NotBlank(message="Email is required!")
	 @Email(message="Please enter a valid email!")
	 private String email;
	 
	 @NotBlank(message="Password is required!")
	 @Size(min=8, max=128, message="Password must be between 8 and 128 characters")
	 private String password;
	 
	 @Transient
	 @NotEmpty(message="Confirm Password is required!")
	 @Size(min=8, max=128, message="Confirm Password must be between 8 and 128 characters")
	 private String confirmPassword;

	 @Column(updatable=false)
	 @DateTimeFormat(pattern = "yyy-MM-DD HH:mm:ss")
	 private Date createdAt;
	 
	 @DateTimeFormat(pattern = "yyy-MM-DD HH:mm:ss")
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
	 * empty default constructor
	 */
	public User() { }
	
	//------------------
	// relationships
	//------------------
	
	//one user has many books
    @OneToMany(mappedBy="user", fetch = FetchType.LAZY)
    //empty list of books
    private List<Book> books;
	
    
	//------------------
	// getters and setters
	//------------------
	
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
	 * @param name - the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the confirmPassword
	 */
	public String getConfirmPassword() {
		return confirmPassword;
	}
	/**
	 * @param confirmPassword the confirmPassword to set
	 */
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
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
	
	
	//------------------
	//getters and setters
	//for relationship
	//------------------
	
	/**
	 * @return the books
	 */
	public List<Book> getBooks() {
		return books;
	}
	/**
	 * @param books the books to set
	 */
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
	
}
