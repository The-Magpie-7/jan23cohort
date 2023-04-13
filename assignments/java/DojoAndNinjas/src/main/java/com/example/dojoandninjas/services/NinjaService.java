package com.example.dojoandninjas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dojoandninjas.models.Ninja;
import com.example.dojoandninjas.repositories.NinjaRepository;

@Service
public class NinjaService {
	
	@Autowired
	private NinjaRepository ninjaRepository;

	
	//add methods:
	//find all (read)
	public List<Ninja> allNinjas(){
		return ninjaRepository.findAll();	
	}
	
	
	//create
	public Ninja createOne(Ninja n) {
		return ninjaRepository.save(n);
	}
	
	//update
	public Ninja updateOne(Ninja n) {
		return ninjaRepository.save(n);
	}
	
	//read one
	public Ninja getOne(Long id) {
		return ninjaRepository.findById(id).orElse(null);
	}
	
	//delete
	public void deleteOne(Long id) {
		ninjaRepository.deleteById(id);
	}
}
