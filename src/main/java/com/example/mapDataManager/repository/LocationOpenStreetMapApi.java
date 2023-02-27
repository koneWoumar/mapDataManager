package com.example.mapDataManager.repository;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Service;

@Service
public class LocationOpenStreetMapApi implements OpenStreetMapAPI {

    public LocationOpenStreetMapApi(){}

    public JSONArray chargerJasonFile(String chemin){
        JSONParser jsonP = new JSONParser();
        try {
            //
            JSONObject data = (JSONObject)jsonP.parse(new FileReader(chemin));
            JSONArray elements =  (JSONArray) data.get("elements");
            //
            return(elements);
            //
        }
        catch (org.json.simple.parser.ParseException e) {
			e.printStackTrace();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
			} 
		catch (IOException e) {
			e.printStackTrace();
		}
        return null;
    }

    //
    public JSONArray getLocation(String nom_location){
        return(null);
    }

}

