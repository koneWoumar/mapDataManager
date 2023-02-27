package com.example.mapDataManager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import com.example.mapDataManager.entities.Location;
import com.example.mapDataManager.services.ManagerService;
import com.example.mapDataManager.entities.BodyVariable;

@RestController
@RequestMapping({"/data"})
public class ManagerController {
	
	@Autowired
	private ManagerService service;
	
	//getting all the location of the card
	@RequestMapping(method=RequestMethod.GET,value="/")
	public ArrayList<Location> getAll() {
		return(this.service.getAll());
	}

	//getting a location by his id
	@RequestMapping(method=RequestMethod.GET ,value="/{id}")
	public Location getById(@PathVariable long id ) {
		return(this.service.getById(id));
	}

	//getting a location by his name : searching a location
	@RequestMapping(method=RequestMethod.POST ,value="/")
	public ArrayList<Location> getByName(@RequestBody String name) {
		return(this.service.SearchLocation(name));
	}
	
	
	
	
	
	
	
	
	
	//getting a person by it id
	//@RequestMapping(method=RequestMethod.GET ,value="{mat}")
	
	//deleting a person
	//@RequestMapping(method=RequestMethod.DELETE,value="{mat}")
	
	
	//putting a person
	//@RequestMapping(method=RequestMethod.PUT,value="/{mat}")
	
	
	//post a person
	//@RequestMapping(method=RequestMethod.POST)
	
	//mvn spring-boot:run
	/*
	@RequestMapping(method=RequestMethod.GET,value="/")
	void test() {
		System.out.println("**********TEST**********");
		this.service.test();
	} */
}
