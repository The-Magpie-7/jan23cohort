package com.example.dojoandninjas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dojoandninjas.models.Dojo;
import com.example.dojoandninjas.repositories.DojoRepository;

@Service
public class DojoService {
	
	@Autowired
	private DojoRepository dojoRepository;
	
	//add methods:
	//find all (read)
	public List<Dojo> allDojos(){
		return dojoRepository.findAll();	
	}

	
	//create
	public Dojo createOne(Dojo d) {
		return dojoRepository.save(d);
	}
	
	//update
	public Dojo updateOne(Dojo d) {
		return dojoRepository.save(d);
	}
	
	//read one
	public Dojo getOne(Long id) {
		return dojoRepository.findById(id).orElse(null);
	}
	
	//delete
	public void deleteOne(Long id) {
		dojoRepository.deleteById(id);
	}
}
