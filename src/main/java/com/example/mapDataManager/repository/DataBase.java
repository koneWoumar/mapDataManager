package com.example.mapDataManager.repository;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mapDataManager.entities.Location;
import com.example.mapDataManager.entities.Node;
import com.example.mapDataManager.entities.Point;

@Service
public class DataBase {
    //
    @Autowired
    private LocationOpenStreetMapApi api;
    //
    private ArrayList<Location> location_db = new ArrayList<>();
    //
    public DataBase(){}
    //
    public void chargerDB(){
        //
        JSONArray elements = api.chargerJasonFile("/home/darkone/Bureau/Mes_Projet_Esir/Projet_SI/map_data/Bars.json");
        int taille = elements.size();
        for(int i=0;i<taille;i++){
            JSONObject element = (JSONObject) elements.get(i);
            String type = (String) element.get("type");
            //
            if(type.equals("node")){
                Node node =this.TraitementNode(element);
                this.location_db.add(node);
            }
        }
    }
    //
    public Node TraitementNode(JSONObject element){
        //
        Long id = (Long) element.get("id");
        double lon = (double) element.get("lon");
        double lat = (double) element.get("lat");
        String name = "";
        //
        JSONObject tags =(JSONObject) element.get("tags");
        //
        if(tags != null){
            name = (String) tags.get("name");
        }
        //
        Node node = new Node(id,new Point(lat,lon),name);
        return(node);
        //
    }
    //
    public void afficherDB() {
        for(Location l:location_db){
            System.out.println(l.toString());
        }
    }
    //
    public ArrayList<Location> getLocation_db() {
        this.chargerDB();
        return location_db;
    }
    
}


/*
 * public void chargerDB(){
        System.out.println("Dans la methode chargerB");
		JSONParser jsonP = new JSONParser();
        try {
        //
        JSONObject data = (JSONObject)jsonP.parse(new FileReader("/home/darkone/Bureau/Mes_Projet_Esir/Projet_SI/map_data/Bars.json"));
        JSONArray elements =  (JSONArray) data.get("elements");
        //
        int taille = elements.size();
        for(int i=0;i<taille;i++){
            JSONObject element = (JSONObject) elements.get(i);
            String type = (String) element.get("type");
            //
            if(type.equals("node")){
                //
                Long id = (Long) element.get("id");
                double lon = (double) element.get("lon");
                double lat = (double) element.get("lat");
                String name = "";
                //
                JSONObject tags =(JSONObject) element.get("tags");
                //
                if(tags != null){
                    name = (String) tags.get("name");
                }
                //
                Node node = new Node(id,new Point(lat,lon),name);
                location.add(node);
            }
        }
 */
