package com.example.dojoandninjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.dojoandninjas.models.Dojo;
import com.example.dojoandninjas.models.Ninja;

@Repository
public interface NinjaRepository extends CrudRepository<Ninja, Long> {
	
	// this method retrieves all from the database
    List<Ninja> findAll();
    
    //list that gets all the 
    //List<Ninja> findByDojo(Dojo dojo);

}
