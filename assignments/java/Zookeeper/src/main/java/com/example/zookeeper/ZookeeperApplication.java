package com.example.zookeeper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ZookeeperApplication {

	public static void main(String[] args) {
		//Gorilla test
		Gorilla gorilla = new Gorilla();
		gorilla.throwThing(gorilla);
		gorilla.throwThing(gorilla);
		gorilla.throwThing(gorilla);
		gorilla.displayEnergyLevel();
		
		gorilla.eatBanana();
		gorilla.eatBanana();
		
		gorilla.climb();
		
		//instance of GiantBat
		GiantBat giantBat = new GiantBat();
		giantBat.attackTown();
		giantBat.attackTown();
		giantBat.attackTown();
		
		giantBat.eatHuman();
		giantBat.eatHuman();
		
		giantBat.fly();
		giantBat.fly();
		
		giantBat.displayEnergyLevel();
		
		
		SpringApplication.run(ZookeeperApplication.class, args);
	}

}
