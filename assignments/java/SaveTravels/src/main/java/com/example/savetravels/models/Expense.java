package com.example.savetravels.models;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="expense")
public class Expense {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min=2, max=100, message="Expense item must be between 2 and 100 characters")
	private String expense;
	
	@NotNull
	@Size(min=2, max=100, message="Vendor name must be between 2 and 100 characters")
	private String vendor;
	
	@NotNull(message="Dollar amount must be at least 0.01.")
	private BigDecimal amount;
	
	@NotNull
	@Size(min=2, max=1000, message="Description must be between 2 and 1000 characters")
	private String description;
	
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
		
	//CONSTRUCTORS
	//empty default constructor
	public Expense() {
	}
	
	//constructor
	public Expense(
			@NotNull @Size(min = 2, max = 100, message = "Expense item must be between 2 and 100 characters") String expense,
			@NotNull @Size(min = 2, max = 100, message = "Vendor name must be between 2 and 100 characters") String vendor,
			@DecimalMin(value = "0.1", inclusive = true) @Digits(integer = 5, fraction = 2) BigDecimal amount,
			@NotNull @Size(min = 2, max = 1000, message = "Description must be between 2 and 1000 characters") String description) {
		this.expense = expense;
		this.vendor = vendor;
		this.amount = amount;
		this.description = description;
	}
	
	//GETTERS AND SETTERS
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
	 * @return the expense
	 */
	public String getExpense() {
		return expense;
	}
	/**
	 * @param expense the expense to set
	 */
	public void setExpense(String expense) {
		this.expense = expense;
	}
	/**
	 * @return the vendor
	 */
	public String getVendor() {
		return vendor;
	}
	/**
	 * @param vendor the vendor to set
	 */
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	/**
	 * @return the amount
	 */
	public BigDecimal getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
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
