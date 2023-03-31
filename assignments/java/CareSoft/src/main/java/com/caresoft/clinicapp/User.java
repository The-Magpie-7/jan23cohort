/** 
 * All that is needed here are constructor, getters and setters
 */
package com.caresoft.clinicapp;

/**
 * 
 *
 */
public class User {
    protected Integer id;
    protected int pin;
	/**
	 * @param id
	 * @param pin
	 */
	// Implement a constructor that takes an ID
	public User(Integer id) {
		this.id = id;
		this.pin = 0000;
	}
	
    // Getters and setters
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the pin
	 */
	public int getPin() {
		return pin;
	}
	/**
	 * @param pin the pin to set
	 */
	public void setPin(int pin) {
		this.pin = pin;
	}
    


    
}
