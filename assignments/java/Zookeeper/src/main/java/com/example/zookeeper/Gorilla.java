/**
 * 
 */
package com.example.zookeeper;

/**
 * @author Dana
 *
 * Gorilla is subclass of Mammal
 */
public class Gorilla extends Mammal{

	//CONSTRUCTOR
	public Gorilla() {
		super();
	}
	

	
	//METHODS
	public void throwThing(Mammal m) {
		System.out.println("Gorilla has thrown something!");
		//get the energy level from super class
		int e = m.getEnergy();
		//reduce energy level by 5 for throwing
		e = e - 5;
		//set the energy level back into super class
		m.setEnergy(e);
	}
	
//	public void eatBanana(Mammal m) {
//		//get the energy level from super class
//		int e = m.getEnergy();
//		//increase energy level by 10 for eating
//		e = e + 10;
//		//set the energy level back into super class
//		m.setEnergy(e);
//	}
	
	public void eatBanana() {
		System.out.println("Gorilla is satisfied after eating bananas.");
		//call the eat method from super class
		super.eat();
	}
	
	public void climb() {
		System.out.println("Gorilla has climbed a tree.");
		//call the climb method from super class
		super.climb();
	}
	
//	public void climb(Mammal m) {
//		//get the energy level from super class
//		int e = m.getEnergy();
//		//decrease energy level by 10 for climbing
//		e = e - 10;
//		//set the energy level back into super class
//		m.setEnergy(e);
//	}
	
	public int displayEnergyLevel() {
		return super.displayEnergyLevel();
	}
}
