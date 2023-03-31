/**
 * 
 */
package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author Dana
 *
 */
public class AdminUser extends User implements HIPAACompliantUser, HIPAACompliantAdmin {	
    
    // class members/attributes
    private Integer employeeID;
    private String role;
    private ArrayList<String> securityIncidents;
    
	/**
	 * @param employeeID
	 * @param role
	 * @param securityIncidents
	 */
	//Implementing a constructor that takes an ID and a role
	//constructor
	public AdminUser(Integer employeeID, String role) {
		super(employeeID);
		this.employeeID = employeeID;
		this.role = role;
		
		this.securityIncidents = new ArrayList<>();
	}
    
    
    // TO DO: Implement HIPAACompliantUser!
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
	
	//TO DO: Implement accessAuthorized
	public boolean accessAuthorized(Integer confirmedAuthID) {
		//TODO: FINISH THIS METHOD!!!!!!!!!!!!!!!!!!!!!
		// Auto-generated method stub
		//Checks the physician's id against the given id;
		
		if(id.equals(confirmedAuthID)) {
			//returns true if they are a match,
			return true;
		}
		else {
			//if fail, call authIncident
			authIncident();
			//returns false if not a match
			return false;
		}
	}

	
    // TO DO: Implement HIPAACompliantAdmin!
	@Override
	public ArrayList<String> reportSecurityIncidents() {
		//uuuuuhhhh.. add?
		//securityIncidents.add
		//setSecurityIncidents
		
		return this.securityIncidents;
	}
	
	
    public void newIncident(String notes) {
        String report = String.format(
            "Datetime Submitted: %s \n,  Reported By ID: %s\n Notes: %s \n", 
            new Date(), this.employeeID, notes
        );
        securityIncidents.add(report);
    }
    public void authIncident() {
        String report = String.format(
            "Datetime Submitted: %s \n,  ID: %s\n Notes: %s \n", 
            new Date(), this.employeeID, "AUTHORIZATION ATTEMPT FAILED FOR THIS USER"
        );
        securityIncidents.add(report);
    }


    //GETTERS and  SETTERS
	public Integer getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(Integer employeeID) {
		this.employeeID = employeeID;
	}


	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}	
}
