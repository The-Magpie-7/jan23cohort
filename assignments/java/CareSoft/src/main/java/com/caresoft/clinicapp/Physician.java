/**
 * 
 */
package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

/**
 * 
 *
 */
public class Physician extends User implements HIPAACompliantUser {

	//class members
	private Integer id;
	private ArrayList<String> patientNotes;
	
	
	//Constructor that takes an ID
	public Physician(Integer id) {
		super(id);
		this.id = id;
	}
   
	
    //Implementing HIPAACompliantUser:
	@Override
	public boolean assignPin(int pin) {
		//Pin must be exactly 4 digits, returns false if not.
		//convert int to String to check if 4-digits
		//and the pin could start with a zero
		String pinStr = Integer.toString(pin);
		if(pinStr.length() < 4 || pinStr.length() >= 5) {
			//string is not 4-digits
			return false;
		}
		else {
			//pin is 4-digits
			//Expected to assign the pin to the user (as a member variable)
			super.setPin(pin);
			return true;
		}
	}

	@Override
	public boolean accessAuthorized(Integer confirmedAuthID) {
		// Auto-generated method stub
		//Checks the physician's id against the given id;
		
		if(id.equals(confirmedAuthID)) {
			//returns true if they are a match,
			return true;
		}
		else {
			//returns false if not a match
			return false;
		}
	}
	
	
    public void newPatientNotes(String notes, String patientName, Date date) {
        String report = String.format(
            "Datetime Submitted: %s \n", date);
        report += String.format("Reported By ID: %s\n", this.id);
        report += String.format("Patient Name: %s\n", patientName);
        report += String.format("Notes: %s \n", notes);
        this.patientNotes.add(report);
    }

    
    // Setters & Getters 
    //should not be needed
    //because they can be used from the superclass instead
//	public Integer getId() {
//		//call the getId method from super class
//		super.getId();
//		return id;
//	}
//	public void setId(Integer id) {
//		super.setId(id);
//		//this.id = id;
//	}
    
	
    
    //I do not think these are valid!!!!!!!!!!!!
//	public ArrayList<String> getPatientNotes() {
//		return patientNotes;
//	}
//	
//	public void setPatientNotes(ArrayList<String> patientNotes) {
//		this.patientNotes = patientNotes;
//	}

}


