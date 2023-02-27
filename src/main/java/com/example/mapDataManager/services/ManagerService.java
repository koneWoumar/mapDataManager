package com.example.mapDataManager.services;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mapDataManager.repository.DataBase;
import java.util.ArrayList;
import com.example.mapDataManager.entities.Location;


@Service
public class ManagerService {

	@Autowired
	private DataBase repository;
	//
	public void test() {
		this.repository.chargerDB();
		this.repository.afficherDB();
	}

	//getting all the location
	public ArrayList<Location> getAll(){
		return(this.repository.getLocation_db());
	}

	//getting a location by his id
	public Location getById(long id){
		ArrayList<Location> db=this.repository.getLocation_db();
		for(Location ptr:db){
			if(ptr.getId().equals(id)){
				return(ptr);
			}
		}
		return(null);
	}

	//getting locations by name : searching a location
	public ArrayList<Location> SearchLocation(String name){
		//
		ArrayList<Location> db=this.repository.getLocation_db();
		ArrayList<Location> resultat=new ArrayList<Location>();
		String cle = "" ;
		JSONParser parser = new JSONParser();
		//
		try {
			JSONObject json = (JSONObject) parser.parse(name);
			cle = (String) json.get("name");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		//
		for(Location ptr:db){
			String nom = ptr.getName();
			if(nom!=null){
				if((nom.contains(cle))){
					resultat.add(ptr);
					System.out.println(1);
				}
			}
		}
		return(resultat);
	}
}
