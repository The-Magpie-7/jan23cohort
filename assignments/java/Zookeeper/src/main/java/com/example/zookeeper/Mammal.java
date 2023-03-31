/**
 * 
 */
package com.example.zookeeper;

/**
 * @author Dana
 * Mammal class is superclass to Gorilla and GiantBat subclasses
 */
public class Mammal {

	//attributes
	private int energy;
	

	//CONSTRUCTOR
	/**
	 * @param energy - energy level of mammals
	 */
	public Mammal() {
		//mammals start with energy level of 100 by default
		this.energy = 100;
		
	}

	//GETTERS and SETTERS
	/**
	 * @return the energy
	 */
	public int getEnergy() {
		return energy;
	}
	/**
	 * @param energy the energy to set
	 */
	public void setEnergy(int energy) {
		this.energy = energy;
	}
	
	
	
	//METHODS
	public int displayEnergyLevel() {
		System.out.printf("Energy level: %d \n", this.energy);
		return energy;
	}
	
	public void eat() {
		this.energy = energy + 10;
	}
	
	public void climb() {
		this.energy = energy - 10;
	}
	
}
