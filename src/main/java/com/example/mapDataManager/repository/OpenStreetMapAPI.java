package com.example.mapDataManager.repository;

import org.json.simple.JSONArray;

public interface OpenStreetMapAPI {
    public abstract JSONArray chargerJasonFile(String chemin);
    public abstract JSONArray getLocation(String nom_location);
}
