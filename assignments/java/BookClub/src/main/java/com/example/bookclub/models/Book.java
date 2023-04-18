package com.example.bookclub.models;

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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="books")
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	 @NotNull
	 @Size(min = 2, max = 50, message="Title must be between 2 and 100 characters")
	 private String title;
	 
	 @NotNull
	 @Size(min = 2, max = 50, message="Author's name must be between 2 and 50 characters")
	 private String author;
	 
	 @NotNull
	 @Size(min = 2, message="Please include your thoughts about this book.")
	 private String thoughts;
	 
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
	 
	 //-------------------
	 // constructors
	 //-------------------
	 
	public Book() {
	}

	public Book(@NotNull @Size(min = 2, max = 50, message = "Title must be between 2 and 100 characters") String title,
			@NotNull @Size(min = 2, max = 50, message = "Author's name must be between 2 and 50 characters") String author,
			@NotNull @Size(min = 2, message = "Please include your thoughts about this book.") String thoughts) {
		this.title = title;
		this.author = author;
		this.thoughts = thoughts;
	}



	//------------------
	// relationships
	//------------------
	
	//many books to one user
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;
	
    
	//-----------------
	// getters and setters
	//-----------------
	
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
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
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
	/**
	 * @return the thoughts
	 */
	public String getThoughts() {
		return thoughts;
	}
	/**
	 * @param thoughts the thoughts to set
	 */
	public void setThoughts(String thoughts) {
		this.thoughts = thoughts;
	}
	
	
	//---------------------
	//getters and setters
	//for relationship
	//---------------------
	
	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
	
	 
}
