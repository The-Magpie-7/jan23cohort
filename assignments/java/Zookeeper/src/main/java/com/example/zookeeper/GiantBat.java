/**
 * 
 */
package com.example.zookeeper;

/**
 * @author Dana
 *
 */
public class GiantBat extends Mammal {
//attributes
	private int energy;
	
	/**
	 * @param energy
	 */
	//CONSTRUCTOR
	public GiantBat() {
		super();
		this.energy = 300;
	}

	

	
	//METHODS
	//WORKS GREAT SO FAR!!
	//JUST DO THE SAME THING YOU DID WITH THE GORILLA CLASS
	//AND YOU SHOULD BE GOOD!!
	
	public void climb() {
		System.out.println("Giant Bat has climbed a building!");
		super.climb();
	}
	
	public void fly() {
		System.out.println("You can hear the whooshing of giant bat wings.");
		//decrease Giant Bat's energy level by 50 for flying
		this.energy = this.energy - 50;
	}
	
	public void eatHuman() {
		System.out.println("Aaaah! Here the crunch of the Giant Bat eating a human!");
		//increase the Giant Bat's energy 25 for eating
		this.energy = this.energy + 25;
	}
	
	public void attackTown() {
		System.out.println("You can here the town on fire!");
		//decrease the Giant Bat's energy by 100
		this.energy = this.energy - 100;
	}
	
	public int displayEnergyLevel() {
		System.out.printf("Energy level: %d \n", this.energy);
		return energy;
	}
}
