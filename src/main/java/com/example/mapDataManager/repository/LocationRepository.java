package com.example.mapDataManager.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mapDataManager.entities.Location;

@Service
public class LocationRepository implements Repository{
    //
    @Autowired
    private DataBase db;

    //
    public LocationRepository(){}

    //
    public Location getByName(String name){
        return(null);
    }

    //
    public Location getByid(long id){
        return(null);
    }
}
