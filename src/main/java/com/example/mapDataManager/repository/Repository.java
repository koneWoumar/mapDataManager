package com.example.mapDataManager.repository;

import com.example.mapDataManager.entities.Location;

public interface Repository {
    public abstract Location getByName(String name);
    public abstract Location getByid(long id);
}
